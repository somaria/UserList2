package com.example.userlist2

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchAllUsers().enqueue(object: Callback<List<User>> {

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                d("daniel", "onFailure")

                }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                    d("daniel", "onResponse")
                    println("response 373: ${response.body()!![0].phone}")

                }

        })

        val users = mutableListOf<User>()
        for (i in 0..100) {
            users.add(User("Daniel", "Malone", "dm@gmail.com", "412-4743-74747"))
            println(users[i].firstName)
        }

        recycler_view_id.apply {

            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(users)

        }

    }
}
