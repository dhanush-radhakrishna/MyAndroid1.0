package com.example.myandroid10

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var firstTimeUser = true
    val TAG = "MainActivity"

//    DatePickerDialog.OnDateSetListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnS.setOnClickListener(this)
        btnR.setOnClickListener(this)
        demo.setOnClickListener(this)
        if (!firstTimeUser) {
            btnR.visibility = View.GONE
        }
        registerForContextMenu(demo)
    }



    override fun onClick(v: View?) {
        val id = v!!.id
        // reaction to click event
        when (id) {
            R.id.btnR -> {
                val t = Toast.makeText(this, "REGISTER Button clicked", Toast.LENGTH_LONG)
                t.setGravity(Gravity.TOP, 10, 10)
                t.show()
                val i1 = Intent(this, Register_activity::class.java)
                startActivity(i1)
            }
            R.id.btnS -> {
                //val t = Toast.makeText(this, "SIGN IN Button clicked", Toast.LENGTH_LONG)
                //t.setGravity(Gravity.TOP, 10, 10)
                //t.show()
                Snackbar.make(parentl, "Signing in...",Snackbar.LENGTH_INDEFINITE).show()
                //launch AuthActivity
                val i = Intent(this, AuthActivity::class.java)
                startActivity(i)
            }
            R.id.demo -> {
                val i3 = Intent(this,DemoActivity::class.java)
                startActivity(i3)
            }

        }

    }
    val MENU_LOGIN = 1
    val MENU_REGISTER = 2
    val MENU_EXIT = 3
    val MENU_DATE = 4
    val MENU_PROGRESS = 5
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val loginItem = menu?.add(0, MENU_LOGIN,0 , "Login")
        loginItem?.setIcon(android.R.drawable.ic_dialog_info)
        loginItem?.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menu?.add(0, MENU_REGISTER,1, "Register")
        menu?.add(0, MENU_EXIT,2,"Exit")
        menu?.add(0,MENU_DATE,3,"Pick date")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            MENU_PROGRESS ->{
                progressBar.visibility = View.VISIBLE
            }
            MENU_LOGIN -> {
                val i1 = Intent(this, AuthActivity::class.java)
                startActivity(i1)
                return true
            }
            MENU_REGISTER -> {
                val i2= Intent(this, Register_activity::class.java)
                startActivity(i2)
                return true
            }
            MENU_EXIT ->{
                //finish()
                //displaying dialog box
                val dlg = MyDialog()
                dlg.show(supportFragmentManager, "xyz")
                return true
            }
//            MENU_DATE ->{
//                val dlg = MyDialog()
//                val dlg = DatePicker(parent, parent as DatePickerDialog.OnDateSetListener, 2021,3)
//            }
        }
        return super.onOptionsItemSelected(item)
    }
    val MENU_RB =1
    val MENU_CB =2
    val MENU_LV =3
    val MENU_SP =4
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(0,MENU_RB,0,"Radio Button Demo")
        menu?.add(0,MENU_CB,0,"Check box Demo")
        menu?.add(0, MENU_LV,0,"List view Demo")
        menu?.add(0, MENU_SP,0,"Spinner demo")
    }

}