package com.example.userlist2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.userlist2.UsersAdapter.ViewHolder
import kotlinx.android.synthetic.main.user_row.view.*

class UsersAdapter(private val users: MutableList<User>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {

        return users.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user = users[position]

        holder.firstName.text = user.firstName
        holder.lastName.text = user.lastName

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val firstName: TextView = itemView.firstName
        val lastName: TextView = itemView.lastName

    }


}

