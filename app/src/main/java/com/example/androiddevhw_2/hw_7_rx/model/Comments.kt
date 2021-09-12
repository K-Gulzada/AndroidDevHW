package com.example.androiddevhw_2.hw_7_rx.model

data class Comments(val data:ArrayList<Comment>)

data class Comment (
    val id: Int,
    val post_id: Int,
    val name: String,
    val email: String,
    val body: String
)