package com.xurxodev.multiplatform.library.common.models

import kotlinx.serialization.Serializable

@Serializable
data class Pager(
    val nextPage: String,
    val page: Int,
    val pageCount: Int,
    val pageSize: Int,
    val total: Int
)