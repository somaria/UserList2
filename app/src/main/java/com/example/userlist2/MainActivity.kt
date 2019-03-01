package com.example.userlist2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val users = mutableListOf<User>()

        for (i in 0..100) {
            users.add(User("Daniel", "Malone", "dm@gmail.com"))
            println(users[i].firstName)
        }

        recycler_view_id.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(users)

        }

    }
}
