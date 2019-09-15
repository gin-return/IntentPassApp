package com.example.intentpassapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_intent.message
import kotlinx.android.synthetic.main.activity_intent__delivery_1.*

class Intent_Delivery_Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent__delivery_1)

        message.text = intent.getStringExtra("Message")

        Back.setOnClickListener {
            val backintent = Intent(applicationContext,GetIntentActivity::class.java)
            backintent.putExtra("Message",componentName.className + "から戻ってきました")
            setResult(Activity.RESULT_OK,backintent)
            finish()
        }

    }
}
