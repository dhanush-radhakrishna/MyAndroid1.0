package com.example.myandroid10

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import java.util.*

class MyDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        lateinit var dlg: Dialog
        // my own designed layout
        val bundel=arguments
        val msg =bundel?.getString("msg")
        val b1=bundel?.getString("b1")
        val b2=bundel?.getString("b2")
        val type=bundel?.getInt("type")
        val parent= activity!!
        val builder =AlertDialog.Builder(parent)

        when(type){
            1->{
                //val v=layoutInflater.inflate(R.layout.activity_main,null)
                //AlertDialog

//                val builder =AlertDialog.Builder(parent)
                //builder.setView(R.layout.activity_main)
                builder.setTitle("Confirmation")
                builder.setMessage(msg)
                builder.setPositiveButton(b1,DialogInterface.OnClickListener{ dlg,i -> parent?.finish()
                })

                builder.setNegativeButton(b2, DialogInterface.OnClickListener{
                    dlg,i ->
                    dlg.cancel()


                })
                dlg=builder.create()
                builder.setCancelable(false)

            }
            2->{
                //time picker dialog
                dlg= TimePickerDialog(parent,parent as TimePickerDialog.OnTimeSetListener,
                        12,0,false)

            }
            3->{
                //date picker dialog
                val current= Calendar.getInstance()
                dlg= DatePickerDialog(parent,parent as DatePickerDialog.OnDateSetListener,
                        current.get(Calendar.YEAR),current.get(Calendar.MONTH),
                        current.get(Calendar.DAY_OF_MONTH))
            }
        }

        return dlg


    }
}