package com.example.xhs

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.xhs.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val note = intent.getParcelableExtra<NoteItem>("NOTE_ITEM")
        note?.let { bindDataToViews(it) } ?: finish() // 数据无效则关闭页面
    }

    private fun bindDataToViews(note: NoteItem) {
        // 2. 绑定数据到UI
        binding.titleTextView.text = note.title
        binding.coverImageView.setImageURI(Uri.parse(note.coverUrl))
        binding.avatarImageView.setImageURI(Uri.parse(note.avatarUrl))
        binding.usernameTextView.text = note.username

        // 3. 动态调整图片高度（可选）
        if (note.isVertical) {
            binding.coverImageView.layoutParams.height = resources.getDimensionPixelSize(R.dimen.detail_image_vertical_height)
        }
    }
}