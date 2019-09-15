package com.example.intentpassapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent__delivery_2.*

class Intent_Delivery_Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent__delivery_2)

        val random = intent.getDoubleExtra("random",-1.0)

        if(random == -1.0) {
            Random.text = "うまくIntentから値を取り出せませんでした"
        }
        else if(random >= 5) {
            Random.text = "受け取った値は" + random + "で5以上です"
        }
        else {
            Random.text = "受け取った値は" + random + "で5以下です"
        }

        Back.setOnClickListener {
            val backintent = Intent(applicationContext,GetIntentActivity::class.java)
            backintent.putExtra("Message",componentName.className + "から戻ってきました")
            setResult(Activity.RESULT_OK,backintent)
            finish()
        }
    }
}
