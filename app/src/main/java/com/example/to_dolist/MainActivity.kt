package com.example.to_dolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(),TodoAdapter.OnItemClickListener {

    val exampleList = generateDummyList(5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<RecyclerView>(R.id.recycler_view).adapter = TodoAdapter(exampleList, this)
        findViewById<RecyclerView>(R.id.recycler_view).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.recycler_view).setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {


            when (position)
            {
                0 -> {
                    val intent = Intent(this,handball::class.java)
                    startActivity(intent)
                }
                1 -> {
                    val intent = Intent(this,Smoke::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this,Spa::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this,Read::class.java)
                    startActivity(intent)
                }
                else -> {
                    val intent = Intent(this,Games::class.java)
                    startActivity(intent)
                }
            }

    }

    private fun generateDummyList(size: Int) : List<Todo>
    {
        val list = ArrayList<Todo>()

            for (i in 0 until size)
            {
                val drawable = when (i){
                        0 -> R.drawable.hand_ball
                        1 -> R.drawable.smoke
                        2 -> R.drawable.spa
                        3 -> R.drawable.read_more
                      else -> R.drawable.use_phone
                }
                val text = when(i)
                {
                    0 -> "Play HandBall"
                    1 -> "Smoke some cigarette"
                    2 -> "Go to the Spa"
                    3 -> "Read some more"
                    else -> "Play games"
                }

                val item = Todo(drawable,text)
                list += item
            }

            return list
        }

}