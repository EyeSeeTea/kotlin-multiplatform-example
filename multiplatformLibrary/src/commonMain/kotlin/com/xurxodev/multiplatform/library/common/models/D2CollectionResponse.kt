package com.xurxodev.multiplatform.library.common.models

import kotlinx.serialization.Serializable

@Serializable
data class D2CollectionResponse<T>(
    val pager: Pager,
    var optionSets: List<T>
)