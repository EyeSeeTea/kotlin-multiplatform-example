package com.xurxodev.multiplatform.library.optionsets

import com.xurxodev.multiplatform.library.common.models.IdentifiableObject
import kotlinx.serialization.Serializable

@Serializable
data class OptionSet(
    override val displayName: String,
    override val id: String,
    override val name: String,
    val options: List<Option>?,
    val version: Int
) : IdentifiableObject