package com.xurxodev.multiplatform.library

import com.xurxodev.multiplatform.library.common.LogFeature
import com.xurxodev.multiplatform.library.common.models.D2CollectionResponseCustomSerializer
import com.xurxodev.multiplatform.library.common.models.Pager
import com.xurxodev.multiplatform.library.optionsets.Option
import com.xurxodev.multiplatform.library.optionsets.OptionSet
import com.xurxodev.multiplatform.library.optionsets.OptionSetEndpoint
import io.ktor.client.HttpClient
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.takeFrom
import io.ktor.util.InternalAPI
import io.ktor.util.encodeBase64
import kotlinx.serialization.json.JSON

expect fun <T> executeCall(block: suspend () -> T): T

@UseExperimental(InternalAPI::class)
class D2Api(val urlBase: String, val credentials: D2Credentials, externalClient: HttpClient? = null) {
    private val client: HttpClient

    init {
        if (externalClient != null)
            client = externalClient
        else {
            client = HttpClient() {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(JSON.nonstrict).apply {
                        register(D2CollectionResponseCustomSerializer(OptionSet.serializer()))
                        register(OptionSet.serializer())
                        register(Option.serializer())
                        register(Pager.serializer())
                    }
                }

                install(LogFeature)

                defaultRequest {
                    url {
                        takeFrom(urlBase)
                    }
                    header(
                        "Authorization", "Basic " +
                            "${credentials.username}:${credentials.password}".encodeBase64()
                    )
                }
            }
        }
    }

    fun getHtmlContent(): String {
        return executeCall {
            client.get("https://en.wikipedia.org/wiki/Main_Page") as String
        }
    }

    fun optionSets(): OptionSetEndpoint {
        return OptionSetEndpoint(client)
    }

    class Builder {
        var url: String? = null
        var credentials: D2Credentials? = null

        fun url(url: String): Builder {
            this.url = url
            return this
        }

        fun credentials(username: String, password: String): Builder {
            this.credentials = D2Credentials(username, password)
            return this
        }

        fun build(): D2Api {
            /*if (url == null)
                throw java.lang.IllegalArgumentException("url is required")
            if (credentials == null)
                throw IllegalArgumentException("credentials is required")*/

            return D2Api(this.url!!, this.credentials!!)
        }
    }
}