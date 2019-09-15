package com.example.intentpassapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Intent_pass_Button.setOnClickListener {
            val intent = Intent(this,GetIntentActivity::class.java)
            intent.putExtra("Message","MainActivityからデータを受け取りました。")
            startActivity(intent)
        }

    }

}
