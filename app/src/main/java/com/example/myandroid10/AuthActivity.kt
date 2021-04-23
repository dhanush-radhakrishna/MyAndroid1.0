package com.example.myandroid10

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_auth.*
class AuthActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

    }

    override fun onResume() {
        super.onResume()
        val nManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        nManager.cancel(1)
    }

    var dataIsEntered = false
    //submit.setOnClickListener()
    fun cancelClick(view: View){
        Toast.makeText(this, "cancel clicked",Toast.LENGTH_LONG).show()
        val i = Intent(this,MainActivity::class.java)
        startActivity(i)

    }
    fun submitClick(view:View)
    {
        Toast.makeText(this,"submitted",Toast.LENGTH_LONG).show()
    }
//    override fun onClick(v: View?) {
//        val id= v?.id
//        when(id){
//            R.id.CancelButtonAuth->{
//                Toast.makeText(this,"redirecting back to log-in",Toast.LENGTH_LONG).show()
////                Thread.sleep(100)
////                val i= Intent(this, MainActivity::class.java)
////                startActivity(i)
//                finish()
//            }
//            R.id.SigninButton->{
//                val userid=userIDE.text.toString()
//                val password=passwordE.text.toString()
//
//
//
//                //validation
//                if(userid.isNullOrEmpty()){
//                    userIDE.setError("User name cannot be Empty")
//                }
//                else if ( password.isNullOrEmpty()||password.length<7 ){
//                    passwordE.setError("password length error")
//                }
//                else if(userid.isNotEmpty() && password.isNotEmpty() && userid.endsWith(".com")&& userid.contains('@') &&password.length>7)
//                {   Toast.makeText(this,"Submitted!",Toast.LENGTH_LONG).show()
//                }
//                else
//                    Toast.makeText(this,"please enter valid info",Toast.LENGTH_LONG).show()
//            }
//
//        }
//
//    }
//}
    override fun onPause(){
        super.onPause()
        if(!dataIsEntered){
            sendNotification()
        }
}

    private fun sendNotification() {
        //1. get reference to notification manager
        val nManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //2. create notification
        lateinit var nBuilder : Notification.Builder
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("test","AndroidUI",NotificationManager.IMPORTANCE_DEFAULT)
            nManager.createNotificationChannel(channel)
            nBuilder = Notification.Builder(this,"test")
        }
        else{
            nBuilder = Notification.Builder(this)
        }
        nBuilder.setSmallIcon(R.drawable.ic_launcher_foreground)
        nBuilder.setContentTitle("Authentication")
        nBuilder.setContentText("Complete SIGN-UP")
        nBuilder.setAutoCancel(true)

        val tryIntent = Intent(this, MainActivity::class.java)
        val resumeIntent = PendingIntent.getService(this, 0, tryIntent, 0)
        val resumeAction = Notification.Action.Builder(android.R.drawable.ic_dialog_info,"Try again",
                resumeIntent).build()
        nBuilder.addAction(resumeAction)
        val myNotification = nBuilder.build()
        //action on notification
        val i = Intent(this,AuthActivity::class.java)
        val pi = PendingIntent.getActivity(this,0,i,0)
        //setting the intent to the builder
        nBuilder.setContentIntent(pi)
        //3. send the notification
        nManager.notify(1,myNotification)
    }
}