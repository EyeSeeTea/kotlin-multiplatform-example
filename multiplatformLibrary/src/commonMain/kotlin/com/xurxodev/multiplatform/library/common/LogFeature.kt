package com.xurxodev.multiplatform.library.common

import io.ktor.client.HttpClient
import io.ktor.client.features.HttpClientFeature
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.util.AttributeKey

object LogFeature : HttpClientFeature<Unit, LogFeature> {
    override val key: AttributeKey<LogFeature> = AttributeKey("LogFeature")

    override fun prepare(block: Unit.() -> Unit): LogFeature = this

    override fun install(feature: LogFeature, scope: HttpClient) {
        scope.requestPipeline.intercept(HttpRequestPipeline.State) {
            writeLogMessage(context.url.build().toString(),LogLevel.DEBUG)
        }

/*        scope.responsePipeline.intercept(HttpResponsePipeline.Receive) {
            val response = subject.response as HttpResponse
            writeLogMessage(response.readText(),LogLevel.DEBUG)

            proceedWith(subject)
        }*/
    }
}