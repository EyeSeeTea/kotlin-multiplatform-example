package com.xurxodev.multiplatform.library

import kotlin.test.Test
import kotlin.test.assertEquals

class D2ApiShould {

    @Test
    fun create_d2api_successfully_via_constructor() {

        val someUrl = "https://someurl.com"
        val someCredentials =
            D2Credentials("some username", "some password")

        val d2Api = D2Api(someUrl, someCredentials)

        assertEquals(someUrl, d2Api.urlBase)
        assertEquals(someCredentials, d2Api.credentials)
    }
}