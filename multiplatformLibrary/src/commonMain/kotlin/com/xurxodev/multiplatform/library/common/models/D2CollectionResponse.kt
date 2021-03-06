package com.xurxodev.multiplatform.library.common.models

import com.xurxodev.multiplatform.library.optionsets.OptionSet
import kotlinx.serialization.Decoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTreeMapper

//Generic serialization in javascript is broken forJs
//https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/custom_serializers.md#about-generic-serializers
//https://github.com/Kotlin/kotlinx.serialization/issues/244
@Serializable(with = D2CollectionResponseCustomSerializer::class)
class D2CollectionResponse(
    val pager: Pager?,
    var items: List<OptionSet>
)

/**
 * The collection response in Dhis2 Api always contains pager and items,
 * where items key name is variable according to type (events, optionSets ...).
 * for this reason with gson is necessary to create a specific deserializer
 */
@Serializer(forClass = D2CollectionResponse::class)
class D2CollectionResponseCustomSerializer(private val dataSerializer: KSerializer<OptionSet>)
    : KSerializer<D2CollectionResponse> {

    override fun deserialize(input: Decoder): D2CollectionResponse {
        val jsonReader = input as? JSON.JsonInput
            ?: throw SerializationException("This class can be loaded only by JSON")
        val tree = jsonReader.readAsTree() as? JsonObject
            ?: throw SerializationException("Expected JSON object")

        var items = mutableListOf<OptionSet>()
        lateinit var pager: Pager

        for (entry in tree.content) {
            if (entry.key == "pager") {
                pager = JsonTreeMapper().readTree(entry.value, Pager.serializer())
            } else {
                for (jsonElement in entry.value.jsonArray) {
                    items.add(JsonTreeMapper().readTree(jsonElement, dataSerializer))
                }
            }
        }

        return D2CollectionResponse(pager, items)
    }
}

