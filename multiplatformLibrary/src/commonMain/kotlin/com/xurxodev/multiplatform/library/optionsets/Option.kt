package com.xurxodev.multiplatform.library.optionsets

import com.xurxodev.multiplatform.library.common.models.IdentifiableObject
import kotlinx.serialization.Serializable

@Serializable
data class Option(
    override val displayName: String,
    override val id: String,
    override val name: String,
    val attributeValues: List<Any>?,
    val code: String
) : IdentifiableObject