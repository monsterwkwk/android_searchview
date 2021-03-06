package com.example.searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {

    lateinit var searchView: SearchView
    lateinit var myList: ListView
    lateinit var list: ArrayList<String>
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById<SearchView>(R.id.searchView)
        myList = findViewById<ListView>(R.id.myList)

        addDataList()
        searchAdapter()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun searchAdapter(){
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list)
        myList.setAdapter(adapter)
    }

    private fun addDataList(): ArrayList<String>{
        list = ArrayList<String>()

        // add data
        list.add("Monday")
        list.add("Tuesday")
        list.add("Wednesday")
        list.add("Thursday")
        list.add("Friday")
        list.add("Saturday")
        list.add("Sunday")

        return list
    }
}
