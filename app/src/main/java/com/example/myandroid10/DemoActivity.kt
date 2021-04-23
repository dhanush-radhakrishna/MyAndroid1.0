package com.example.myandroid10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)
    }
    fun listButtonClick(view: View){
        Toast.makeText(this,"selected list box",Toast.LENGTH_LONG).show()
        val i = Intent(this,ListActivity::class.java)
        startActivity(i)
    }
    fun radioButtonClick(view: View){
        Toast.makeText(this,"selected radio button",Toast.LENGTH_LONG).show()
    }
    fun checkboxButtonClick(view: View){
        Toast.makeText(this,"selected check box",Toast.LENGTH_LONG).show()
    }
    fun fabClicked(view: View)
    {
        val i4 = Intent(this,webViewActivity::class.java)
        startActivity(i4)
    }
}