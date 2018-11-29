package com.xurxodev.multiplatform.androidapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import com.xurxodev.multiplatform.library.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val d2Api = D2Api.Builder()
            .url("sample url")
            .credentials("user","pwd")
            .build();
        val response = d2Api.optionSets().getAll()

        when (response){
            is D2Response.Success -> helloTextView.text = response.value.toString()
            is D2Response.Error -> helloTextView.text = response.toString()
        }

        //helloTextView.text = Hello().multiplatformHello()
    }
}
