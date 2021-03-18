package com.example.crud.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud.CRUDApplication
import com.example.crud.R
import com.example.crud.presentation.list.listadapter.ListAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = ListAdapter()
        userRecyclerView.adapter = adapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        val data = (application as CRUDApplication).getDataBase()?.userDao()?.getAll()
        Log.d("ListActivity", "data = $data")
        data?.let { adapter.setData(it) }
    }
}


