package com.julie.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//Sign In intent

        val signin=findViewById<Button>(R.id.signin)

        signin.setOnClickListener {
            val signinIntent= Intent(applicationContext, SignIn::class.java)
            startActivity(signinIntent)


        }

//        Sign Up intent

        val signup=findViewById<Button>(R.id.signup)

        signup.setOnClickListener {
            val signupIntent= Intent(applicationContext,SignUp::class.java)
            startActivity(signupIntent)
        }
    }
}