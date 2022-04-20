package com.example.odoomobile

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        val nextButton = findViewById<Button>(R.id.button_yes)
        val backButton = findViewById<Button>(R.id.button_back)

        backButton.setOnClickListener {
            this.finishAffinity()
        }

        nextButton.setOnClickListener {
            val message_swsu_info = "https://info.swsu.ru/index.php?action=auth"

            Log.e("TAG",message_swsu_info)

                var intent = Intent(this,WebSite::class.java )
                intent.putExtra("swsu",message_swsu_info)
                startActivity(intent)

        }
        backButton.setOnClickListener {
            val message_swsu_do = "https://do.swsu.ru/login/index.php"
            var intent = Intent(this,WebSite::class.java )
            intent.putExtra("swsu",message_swsu_do)
            startActivity(intent)
        }
    }
}