package com.example.androiddevhw_2.hw_7_rx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddevhw_2.R
import com.example.androiddevhw_2.hw_7_rx.model.Comment
import com.example.androiddevhw_2.hw_7_rx.model.Comments
import com.example.androiddevhw_2.hw_7_rx.model.User
import com.example.androiddevhw_2.hw_7_rx.model.Users
import com.example.androiddevhw_2.hw_7_rx.retrofit.RetrofitClient
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

class RxActivity : AppCompatActivity() {
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var commentRecyclerView: RecyclerView

    private lateinit var progressBar: ProgressBar

    private val userAdapter: RecyclerAdapter = RecyclerAdapter()
    private val commentAdapter: CommentsAdapter = CommentsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)

        userRecyclerView = findViewById(R.id.user_recycler_view)
        commentRecyclerView = findViewById(R.id.comments_recycler_view)
        progressBar = findViewById(R.id.progress_bar)

        userRecyclerView.layoutManager = LinearLayoutManager(this)
        commentRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = userAdapter
        commentRecyclerView.adapter = commentAdapter

        fetchData()
    }

    private inner class Wrapper(
        val users: ArrayList<User>,
        val comments: ArrayList<Comment>
    )

    private fun fetchData() {
        progressBar.visibility = View.VISIBLE

        Observable.zip(
            RetrofitClient.getUsers(),
            RetrofitClient.getComments(), object : BiFunction<Users, Comments, Wrapper> {
                override fun apply(t1: Users, t2: Comments): Wrapper {
                    return Wrapper(t1.data, t2.data)
                }

            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Wrapper> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Wrapper) {
                    hideProgress()
                    userAdapter.setData(t.users)
                    commentAdapter.setData(t.comments)
                }

                override fun onError(e: Throwable) {
                    hideProgress()
                    println(e)
                }

                override fun onComplete() {
                    hideProgress()
                }

            })
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    private fun setUsers(list: ArrayList<User>) {
        userAdapter.setData(list)
    }

    private fun setComments(list: ArrayList<Comment>) {
        commentAdapter.setData(list)
    }
}