package com.io.muhsin.testapplication

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.io.muhsin.testapplication.Constants.Companion.URL
import com.io.muhsin.testapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val link = URL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    fun init() {

        val utmParams = parseUtmParams(link)

        // Выводим значения каждого параметра utm в лог
        for ((key, value) in utmParams) {
            Log.e("UTM", "$key: $value")
        }

    }

    fun parseUtmParams(link: String): HashMap<String, String> {
        val utmParams = hashMapOf<String, String>()
        val uri = Uri.parse(link)

        uri.getQueryParameter("utm_source")?.let { utmParams["utm_source"] = it }
        uri.getQueryParameter("utm_medium")?.let { utmParams["utm_medium"] = it }
        uri.getQueryParameter("utm_campaign")?.let { utmParams["utm_campaign"] = it }
        uri.getQueryParameter("utm_content")?.let { utmParams["utm_content"] = it }
        uri.getQueryParameter("utm_term")?.let { utmParams["utm_term"] = it }

        return utmParams
    }
}