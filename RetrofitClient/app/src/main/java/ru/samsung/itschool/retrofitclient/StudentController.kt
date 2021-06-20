package ru.samsung.itschool.retrofitclient

import retrofit2.Call
import retrofit2.http.*

interface StudentController {
    @GET("/student")
    fun get(): Call<List<Student>>
}