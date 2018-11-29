"use strict";

var multiplatformLibrary = require('multiplatformLibrary');

var library = multiplatformLibrary.com.xurxodev.multiplatform.library

var credentials = new library.D2Credentials("user","pwd")

var d2Api = new library.D2Api("dhisurl", credentials);

d2Api.optionSets().getAll()
    .then((response) => {
       console.log(response);
    });