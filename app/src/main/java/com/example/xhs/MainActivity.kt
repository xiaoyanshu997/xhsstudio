package com.example.xhs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.xhs.databinding.ActivityMainBinding
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lastItemCountBeforeRefresh = 0
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private lateinit var viewModel: NoteViewModel
    private var isRefreshing = false
    private lateinit var swipeRefresh: SwipeRefreshLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        swipeRefresh = findViewById(R.id.swipeRefresh)

        val repository = NoteRepository()
        val factory = NoteViewModelFactory(repository)
        Fresco.initialize(this)

        viewModel = ViewModelProvider(this, factory)[NoteViewModel::class.java]

        // 初始化RecyclerView（瀑布流关键）[9](@ref)
        recyclerView = findViewById(R.id.recyclerView)



        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL).apply {
            gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE // 防止错位
            reverseLayout = false  // 关键：反转列表方向
            //stackFromEnd = false
        }
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = null // 禁用动画避免刷新冲突

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy <= 0) return
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as StaggeredGridLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItems = IntArray(layoutManager.spanCount)
                layoutManager.findFirstVisibleItemPositions(firstVisibleItems)

                // 找到最后一个可见项位置
                val lastVisibleItemPosition = firstVisibleItems.maxOrNull() ?: 0

                // 检查是否接近底部
                val isAtBottom = lastVisibleItemPosition + visibleItemCount >= totalItemCount - 1

                // 当接近底部且不在加载中且有更多数据时加载
                if (isAtBottom &&
                    viewModel.loadState.value != NoteViewModel.LoadState.LOADING_MORE &&
                    !viewModel.isLastPage) {
                    viewModel.loadMore()
                }

            }
        })



        // 设置适配器
        adapter = NoteAdapter(recyclerView  ,loadMore = { viewModel.loadMore() })
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : NoteAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                viewModel.notes.value?.get(position)?.let { note ->
                    startActivity(Intent(this@MainActivity, DetailActivity::class.java).apply {
                        putExtra("NOTE_ITEM", note)
                    })
                }
            }
        })

        swipeRefresh.setOnRefreshListener {
            if (!isRefreshing) { // 防止重复刷新
                isRefreshing = true
                // 记录刷新前的项目数量
                //lastItemCountBeforeRefresh = adapter.itemCount
                viewModel.resetData()
            }
            isRefreshing = false
        }
        viewModel.resetData()
        // 触发刷新
        viewModel.loadMore()
        // 观察数据
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.notes.observe(this) { notes ->
            adapter.submitListWithState(notes, viewModel.loadState.value ?: NoteViewModel.LoadState.IDLE)

            // 在数据更新后检查是否需要停止刷新
            stopRefreshIfNeeded()
        }

        viewModel.loadState.observe(this) { state ->
            adapter.submitListWithState(viewModel.notes.value, state)

            // 在状态更新后检查是否需要停止刷新
            stopRefreshIfNeeded()
        }
        val state = viewModel.loadState.value ?: NoteViewModel.LoadState.IDLE
        if (state != NoteViewModel.LoadState.LOADING_MORE && isRefreshing) {
            stopRefresh()
        }
    }

    private fun stopRefreshIfNeeded() {
        if (!isRefreshing) return
        if (swipeRefresh.isRefreshing && viewModel.loadState.value != NoteViewModel.LoadState.LOADING_MORE) {
            swipeRefresh.postDelayed({
                swipeRefresh.isRefreshing = false
                // 自动滚动到底部显示新数据
                recyclerView.post {
                    val newItemCount = adapter.itemCount - lastItemCountBeforeRefresh
                    if (newItemCount > 0) {
                        // 滚动到新添加的第一个项目
                        recyclerView.scrollToPosition(lastItemCountBeforeRefresh)
                    }
                }
            }, 500) // 0.5秒延迟确保动画流畅
        }
    }



    private fun stopRefresh() {
        if (isRefreshing) {
            isRefreshing = false

            // 停止刷新动画
            swipeRefresh.isRefreshing = false

            // 检查是否有新项目添加并滚动
            val newItemCount = adapter.itemCount - lastItemCountBeforeRefresh
            if (newItemCount > 0) {
                scrollToNewItems(lastItemCountBeforeRefresh)
            }
        }
    }

    private fun scrollToNewItems(startPosition: Int) {
        recyclerView.post {
            try {
                // 确保位置在有效范围内
                if (startPosition >= 0 && startPosition < adapter.itemCount) {
                    // 滚动到新添加的第一个项目
                    recyclerView.smoothScrollToPosition(startPosition)
                }
            } catch (e: Exception) {
                // 处理可能的异常
            }
        }
    }
}