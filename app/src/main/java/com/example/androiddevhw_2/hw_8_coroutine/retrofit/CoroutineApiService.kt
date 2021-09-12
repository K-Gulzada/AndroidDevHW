package com.example.androiddevhw_2.hw_8_coroutine.retrofit

import com.example.androiddevhw_2.hw_7_rx.model.Comments
import com.example.androiddevhw_2.hw_7_rx.model.User
import com.example.androiddevhw_2.hw_7_rx.model.Users
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/*interface CoroutineApiService {

    @GET("/public/v1/users")
   suspend fun getUsers(): Users

    @GET("/public/v1/comments")
    suspend  fun getComments(): Comments

    @POST("/public/v1/users")
    suspend fun CreateUser(@Body user: User):User
}*/

// 06.09.21 coroutine flow

interface CoroutineApiService {

    @GET("/public/v1/users")
    suspend fun getUsers(): Users

    @GET("/public/v1/comments")
    suspend fun getComments(): Comments

    @POST("/public/v1/users")
    suspend fun CreateUser(@Body user: User): User
}