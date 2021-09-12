package com.example.androiddevhw_2.hw_7_rx.retrofit

import com.example.androiddevhw_2.hw_7_rx.model.Comments
import com.example.androiddevhw_2.hw_7_rx.model.User
import com.example.androiddevhw_2.hw_7_rx.model.Users
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/public/v1/users")
    fun getUsers(): Observable<Users>

    @GET("/public/v1/comments")
    fun getComments(): Observable<Comments>

    @POST("/public/v1/users")
    fun CreateUser(@Body user: User): Observable<User>
}