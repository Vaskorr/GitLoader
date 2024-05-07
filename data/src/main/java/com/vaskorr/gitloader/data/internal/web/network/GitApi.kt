package com.vaskorr.gitloader.data.internal.web.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vaskorr.gitloader.data.internal.web.model.Repository
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.java.KoinJavaComponent.getKoin
import java.io.IOException
import java.lang.reflect.Type
import javax.inject.Inject


internal class GitApi @Inject constructor(
    private val client: OkHttpClient
){
    fun getUserRepositories(username: String): List<Repository>{
        val request = Request.Builder()
            .url("https://api.github.com/users/$username/repos")
            .addHeader("accept", "application/json")
            .build()

        var body: String

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IOException(
                        "Запрос к серверу не был успешен:" +
                                " ${response.code} ${response.message}"
                    )
                }
                body = response.body!!.string()
                Log.d("BODY", body)
                val listType: Type = object : TypeToken<List<Repository>>() {}.type
                return Gson().fromJson(body, listType)
            }
        } catch (e: IOException) {
            println("Ошибка подключения: $e")
        }
        return emptyList()
    }
}