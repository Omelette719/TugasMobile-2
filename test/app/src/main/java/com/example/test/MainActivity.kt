package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    private lateinit var tvResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResponse = findViewById(R.id.tvResponse)

        val url = "https://admin123.free.beeceptor.com/keren"
        val queue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    val hasil = response.getString("keren")
                    tvResponse.text = hasil
                } catch (e: Exception) {
                    tvResponse.text = "Parsing error: ${e.message}"
                }
            },
            { error ->
                tvResponse.text = "Error: ${error.message}"
            }
        )

        queue.add(jsonObjectRequest)
    }
}
