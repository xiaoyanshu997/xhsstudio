package com.example.xhs

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// Model层：定义数据结构
@Parcelize

data class NoteItem(
    val id: Long, // 必须唯一，用于DiffUtil
    val coverUrl: String,
    val title: String,
    val avatarUrl: String,
    val username: String,
    val isVertical: Boolean, // 布局类型标识
    val aspectRatio: Float = if (isVertical) 0.75f else 1.33f // 动态计算比例
): Parcelable