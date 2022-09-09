package com.example.practiceactivity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class Splash: AppCompatActivity() {

    private var keepLogin: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        val sharedPreferences = getSharedPreferences("My_Preferences", Context.MODE_PRIVATE)
        keepLogin = sharedPreferences.getBoolean(KEEP_ME_LOGIN, false)

        object : CountDownTimer(5000,1000){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                if (!keepLogin){
                    val intent = Intent(this@Splash,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                } else{
                    val intent = Intent(this@Splash,MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        }
    }
}