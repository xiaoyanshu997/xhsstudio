package com.example.xhs

class NoteRepository {
    // 模拟网络请求获取数据
    val allNotes = listOf(
        // 竖图示例 (3:4)
        NoteItem(
            id = 1,
            "https://gips3.baidu.com/it/u=2164025718,1883077975&fm=3028&app=3028&f=PNG&fmt=auto&q=75&size=f271_270",
            "1",
            "https://img1.baidu.com/it/u=1813967122,1482053711&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=1082",
            "2",
            true,
        ),
        NoteItem(
            id = 2,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "2",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "3",
            true,
        ),
        NoteItem(
            id = 3,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "3",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "4",
            true,
        ),
        NoteItem(
            id = 4,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "4",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "5",
            true,
        ),
        NoteItem(
            id = 5,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "5",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "6",
            true,
        ),
        NoteItem(
            id = 6,
            "https://img0.baidu.com/it/u=2707386529,1220667635&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500",
            "6",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "7",
            true,
        ),
        NoteItem(
            id = 7,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "7",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "8",
            true,
        ),
        NoteItem(
            id = 8,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "8",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "9",
            true,
        ),
        NoteItem(
            id = 9,
            "https://img0.baidu.com/it/u=2707386529,1220667635&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500",
            "9",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "10",
            false,
        ),
        // 横图示例 (4:3)
        NoteItem(
            id = 10,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "10",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "11",
            true,
        ),
        NoteItem(
            id = 11,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "11",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "12",
            true,
        ),
        NoteItem(
            id = 12,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "12",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "13",
            true,
        ),
        NoteItem(
            id = 13,
            "https://gips3.baidu.com/it/u=2164025718,1883077975&fm=3028&app=3028&f=PNG&fmt=auto&q=75&size=f271_270",
            "1",
            "https://img1.baidu.com/it/u=1813967122,1482053711&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=1082",
            "2",
            true,
        ),
        NoteItem(
            id = 14,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "2",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "3",
            true,
        ),
        NoteItem(
            id = 15,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "3",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "4",
            true,
        ),
        NoteItem(
            id =16,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "4",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "5",
            true,
        ),
        NoteItem(
            id = 17,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "5",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "6",
            true,
        ),
        NoteItem(
            id = 18,
            "https://img0.baidu.com/it/u=2707386529,1220667635&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500",
            "6",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "7",
            true,
        ),
        NoteItem(
            id = 19,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "7",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "8",
            true,
        ),
        NoteItem(
            id = 20,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "8",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "9",
            true,
        ),
        NoteItem(
            id = 21,
            "https://img0.baidu.com/it/u=2707386529,1220667635&fm=253&fmt=auto&app=120&f=JPEG?w=889&h=500",
            "9",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "10",
            false,
        ),
        // 横图示例 (4:3)
        NoteItem(
            id = 22,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "10",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "11",
            true,
        ),
        NoteItem(
            id = 23,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "11",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "12",
            true,
        ),
        NoteItem(
            id = 24,
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "12",
            "https://img2.baidu.com/it/u=586058312,1869204209&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=600",
            "13",
            true,
        )
//        // 更多数据...

    )
    fun getNotes(page: Int): List<NoteItem> {


        val pageSize = 8
        val startIndex = (page - 1) * pageSize

        // 确保索引在有效范围内
        if (startIndex >= allNotes.size) return emptyList()

        val endIndex = minOf(startIndex + pageSize, allNotes.size)
        return allNotes.subList(startIndex, endIndex)
    }
}