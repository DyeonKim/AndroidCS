package com.example.androidcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcs.data.DataSet
import com.example.androidcs.data.Person
import com.example.androidcs.data.getFullName
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var personsAdapter: PersonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initEvent()
    }

    private fun initView() {
        personsAdapter = PersonsAdapter(DataSet.persons)
        findViewById<RecyclerView>(R.id.rv_persons).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = personsAdapter
        }
    }

    private fun initEvent() {
        personsAdapter.setItemClickListener(object : PersonsAdapter.ItemClickListener {
            override fun onClick(person: Person) {
                AlertDialog.Builder(this@MainActivity).apply {
                    setTitle(person.getFullName())
                    setMessage(person.age.toString())
                    setPositiveButton("확인", null)
                }.show()
            }
        })
        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener {
            Toast.makeText(this, "Add Button Click!", Toast.LENGTH_SHORT).show()
        }
    }
}
