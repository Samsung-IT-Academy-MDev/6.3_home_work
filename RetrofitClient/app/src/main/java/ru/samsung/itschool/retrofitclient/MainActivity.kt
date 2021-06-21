package ru.samsung.itschool.retrofitclient

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    val connectionURL: String = "http://192.168.49.102:8080/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et_url: TextView = findViewById(R.id.url)
        et_url.text = connectionURL;
        val firstname: EditText = findViewById(R.id.firstname)
        val lastname: EditText = findViewById(R.id.lastname)
        val send: Button = findViewById(R.id.send)
        val get: Button = findViewById(R.id.get)
        val receive: Button = findViewById(R.id.receive)
        val result: TextView = findViewById(R.id.result)
        val retrofit = Retrofit.Builder()
            .baseUrl(connectionURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: StudentController = retrofit.create(StudentController::class.java)
        get.setOnClickListener(View.OnClickListener {
            result.text=""
           TODO("вставьте код решения здесь")
        })
    }
}