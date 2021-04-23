package com.example.myandroid10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*
class ListActivity :  AppCompatActivity(), AdapterView.OnItemClickListener {

    val langList= mutableListOf("Kotlin","python","JAVA","Swift","Dart","C","C#","Cpp","Ruby","Perl","Verilog" ,"VHDL")
    lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setContentView(R.layout.activity_list)

        //Adapter :
        // 1. Supplying data to view
        // 2. defines layout of each item
        /*
        listview,spinner, recycler view ->Adapter views
         */

        adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,langList)
        ListlangL.adapter=adapter//databinding

        ListlangL.setOnItemClickListener(this)

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedItem=langList[position]
        Toast.makeText(this,"Selected Item is $selectedItem",Toast.LENGTH_LONG).show()
        langList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}