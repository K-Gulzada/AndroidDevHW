package com.example.androiddevhw_2.hw_7_rx

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddevhw_2.databinding.UserRecyclerBinding
import com.example.androiddevhw_2.hw_7_rx.model.User
import java.util.ArrayList

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {
    private var data: ArrayList<User> = arrayListOf()

    fun setData(list: ArrayList<User>) {
        this.data = list
        notifyDataSetChanged()
    }

    inner class UserViewHolder(private val binding: UserRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setUser(user: User) {
            binding.name.setText(user.name)
            binding.email.setText(user.email)
            binding.gender.setText(user.gender.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserRecyclerBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = data[position]
        holder.setUser(user)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}