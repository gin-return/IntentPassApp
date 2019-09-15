package com.example.intentpassapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import kotlinx.android.synthetic.main.activity_get_intent.*
import kotlinx.android.synthetic.main.activity_get_intent.message
import kotlinx.android.synthetic.main.activity_intent__delivery_3.*
import java.io.StringReader
import java.lang.StringBuilder

class Intent_Delivery_Activity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent__delivery_3)

        val Messages = intent.getStringArrayExtra("Messages")
        val buffer = StringBuilder()
        Messages.forEach {
            buffer.append(it)
        }
        message.text = buffer.toString()

        back.setOnClickListener {
            val backintent = Intent(applicationContext,GetIntentActivity::class.java)
            backintent.putExtra("Message",componentName.className + "から戻ってきました")
            setResult(Activity.RESULT_OK,backintent)
            finish()
        }
    }
}
