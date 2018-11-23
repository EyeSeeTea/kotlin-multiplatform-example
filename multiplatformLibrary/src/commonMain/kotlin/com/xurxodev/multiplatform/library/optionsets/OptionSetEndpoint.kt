package com.xurxodev.multiplatform.library.optionsets

import com.xurxodev.multiplatform.library.D2Endpoint
import com.xurxodev.multiplatform.library.D2Response
import com.xurxodev.multiplatform.library.common.models.D2CollectionResponse
import com.xurxodev.multiplatform.library.executeCall
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.InternalAPI

class OptionSetEndpoint internal constructor(private val client: HttpClient)
    : D2Endpoint<D2CollectionResponse<OptionSet>>() {

    @InternalAPI
    fun getAll(): D2Response<List<OptionSet>> {
        var response: D2CollectionResponse<OptionSet>?

        return executeCall {
            response = client.get{
                url { encodedPath = "/api/optionSets" }
                //parameter("paging",false)
/*                parameter("fields","id,name,displayName,created,lastUpdated,access," +
                    "version,options[id,name,displayName,created,lastUpdated,access," +
                "code,attributeValues[*,attribute[id,code]]]")*/
                parameter("fields","id,name,displayName,created,lastUpdated,access," +
                    "version,options[id,name,displayName,created,lastUpdated,access," +
                    "code]")
            } as D2CollectionResponse<OptionSet>

            D2Response.Success(response!!.items)
        }
    }
}
