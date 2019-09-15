package com.example.intentpassapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_get_intent.*

class GetIntentActivity : AppCompatActivity() {

    val Back_Acticity1:Int = 1
    val Back_Activity2:Int = 2
    val Back_Activity3:Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_intent)

        if(intent.getStringExtra("Message") != null) message.text = intent.getStringExtra("Message")

        //id:Intent_Delivery_Activity1のButtonをクリックした場合の処理
        Intent_Delivery_Activity1.setOnClickListener {
            val intent = Intent(this,com.example.intentpassapp.Intent_Delivery_Activity1::class.java)
            intent.putExtra("Message", componentName.className + "から遷移してきました")
            startActivityForResult(intent,Back_Acticity1)
        }

        //id:Intent_Delivery_Activity2のButtonをクリックした場合の処理
        Intent_Delivery_Activity2.setOnClickListener {
            val intent = Intent(applicationContext,com.example.intentpassapp.Intent_Delivery_Activity2::class.java)
            val random = 10 * Math.random()
            intent.putExtra("random",random)
            startActivityForResult(intent,Back_Activity2)
        }

        //id:Intent_Delivery_Activity3のButtonをクリックした場合の処理,(Intentに値を何も入れなかった場合)
        Intent_Delivery_Activity3.setOnClickListener {
            val intent = Intent(applicationContext,com.example.intentpassapp.Intent_Delivery_Activity3::class.java)
            intent.putExtra("Messages", arrayOf("前画面","GetIntent","から","遷移してきました","。"))
            startActivityForResult(intent,Back_Activity3)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //Intent_Delivery_Activity1から戻ってきた場合の処理
        if(requestCode == Back_Acticity1 && data != null && resultCode == Activity.RESULT_OK) {
            message.text = data.getStringExtra("Message")
        }
        else if(requestCode == Back_Acticity1 && resultCode == Activity.RESULT_CANCELED) {
            message.text = "Intent_Delivery_Activity1から不正な形で戻ってきました"
        }

        //Intent_Delivery_Activity2から戻ってきた場合の処理
        if(requestCode == Back_Activity2 && data != null && resultCode == Activity.RESULT_OK) {
            message.text = data.getStringExtra("Message")
        }
        else if(requestCode == Back_Activity2 && resultCode == Activity.RESULT_CANCELED)  {
            message.text == "Intent_Delivery_Activity2から不正な形で戻ってきました"
        }

        //Intent_Delivery_Activity3から戻ってきた場合の処理
        if(requestCode == Back_Activity3 && data != null && resultCode == Activity.RESULT_OK) {
            message.text = data.getStringExtra("Message")
        }
        else if(requestCode == Back_Activity3 && resultCode == Activity.RESULT_CANCELED)  {
            message.text == "Intent_Delivery_Activity3から不正な形で戻ってきました"
        }


    }
}
