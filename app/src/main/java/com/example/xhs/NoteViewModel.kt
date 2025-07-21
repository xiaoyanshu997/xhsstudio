package com.example.xhs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class NoteViewModel(repo1: NoteRepository) : ViewModel() {
    enum class LoadState { IDLE, LOADING_MORE, COMPLETE }

    private val _notes = MutableLiveData<List<NoteItem>>(emptyList())
    val notes: LiveData<List<NoteItem>> = _notes

    var currentPage = 1

    var isLastPage: Boolean = false
        private set

    val repository = NoteRepository()

    private val _loadState = MutableLiveData<LoadState>(LoadState.IDLE)
    val loadState: LiveData<LoadState> = _loadState

    companion object {
        const val PAGE_SIZE = 8
    }

    fun loadMore() {
        // 添加双重检查防止重复加载
        if (isLastPage || _loadState.value == LoadState.LOADING_MORE) return

        _loadState.value = LoadState.LOADING_MORE

        viewModelScope.launch(Dispatchers.IO) {
            try {
                delay(1000) // 模拟网络延迟
                val newData = repository.getNotes(currentPage)

                withContext(Dispatchers.Main) {
                    if (newData.isEmpty()) {
                        isLastPage = true
                        _loadState.value = LoadState.COMPLETE
                    } else {
                        // 使用新列表替换而不是累加
                        val currentList = _notes.value ?: emptyList()
                        _notes.value = currentList + newData
                        currentPage++
                        _loadState.value = LoadState.IDLE
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _loadState.value = LoadState.IDLE // 确保状态重置
                }
            }
        }
    }


    fun resetData() {
        currentPage = 1
        isLastPage = false
        _notes.value = emptyList()
        _loadState.value = LoadState.IDLE
    }
}