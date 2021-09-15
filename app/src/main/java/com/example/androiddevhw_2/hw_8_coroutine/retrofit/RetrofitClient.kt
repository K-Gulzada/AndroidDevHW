package com.example.androiddevhw_2.hw_8_coroutine.retrofit

import com.example.androiddevhw_2.hw_7_rx.model.Comments
import com.example.androiddevhw_2.hw_7_rx.model.User
import com.example.androiddevhw_2.hw_7_rx.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.sql.DriverManager.println
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.flow


class RetrofitClient {
    private val service = Retrofit.Builder()
        .baseUrl("https://gorest.co.in")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()
        .create(CoroutineApiService::class.java)

    // Flow<Users>
     fun getUsers(): Flow<Users> = flow {
         println("ACADEMY STEP ${Thread.currentThread()}")
         emit(service.getUsers())
     }.flowOn(Dispatchers.IO)

    // Flow<List<User>>
   /* fun getUsers(): Flow<List<User>> = flow {
        println("ACADEMY STEP ${Thread.currentThread()}")
        emit(listOf<User>(service.getUsers().data[0]))
        delay(1000)
        emit(listOf<User>(service.getUsers().data[1]))
        delay(1000)
        emit(listOf<User>(service.getUsers().data[0]))
        delay(1000)
        emit(listOf<User>(service.getUsers().data[1]))
    }.flowOn(Dispatchers.IO)*/

    fun getComments(): Flow<Comments> = flow {
        emit(service.getComments())
    }.flowOn(Dispatchers.IO)

    fun createUsers(user: User): Flow<User> {
        return flow {
            emit(service.CreateUser(user))
        }.flowOn(Dispatchers.IO)
    }

    private val httpClient: OkHttpClient
    get() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request: Request = chain.request()
                    val newRequest: Request = request.newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer 39e3a3bbb7e41898018dd60046ef639dcb7a5d1344a712d5d54b15ad82b3e45b"//tak ne delat`
                        )
                        .build()
                    return chain.proceed(newRequest)
                }
            })
            .build()
    }
}