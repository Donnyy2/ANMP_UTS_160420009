package com.ubaya.uts_anmp_160420009.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.uts_anmp_160420009.model.Akun
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class LoginModel():ViewModel() {
    val loginStatus = MutableLiveData<Boolean>()

    fun login(username:String, password:String){
        val url = "http://10.0.2.2/Akun/Akun.php"

        val urlObject = URL(url)
        val connection = urlObject.openConnection() as HttpURLConnection

        connection.requestMethod = "POST"
        connection.doOutput = true

        val postData = "username=$username%password=$password"
        val outputStream = connection.outputStream
        outputStream.write(postData.toByteArray())
        outputStream.flush()

        val responseCode = connection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val response = reader.readLine()
            loginStatus.postValue(response == "success")
        } else {
            loginStatus.postValue(false)
        }
    }
}