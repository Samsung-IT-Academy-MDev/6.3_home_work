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
            val call: Call<List<Student>> = service.get()
            call.enqueue(object : Callback<List<Student>> {
                override fun onResponse(call: Call<List<Student>>, response: Response<List<Student>>) {
                    if (response.isSuccessful) {
                        val student: List<Student>? = response.body()
                        result.text = student?.get(0)?.firstName.toString()
                    }
                }

                override fun onFailure(call: Call<List<Student>>, t: Throwable) {
                    Log.d("RetrofitClient","Receive data from server problem ")
                }
            })
        })
    }
}