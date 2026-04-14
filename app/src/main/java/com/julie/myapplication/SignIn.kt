package com.julie.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.loopj.android.http.RequestParams

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

//            https://julie.alwaysdata.net/api/addproducts
//            https://julie.alwaysdata.net/api/signin
//            https://julie.alwaysdata.net/api/signup
//            https://julie.alwaysdata.net/api/mpesa_payment
//            https://julie.alwaysdata.net/api/getproductdetails

        }

        val signin=findViewById<TextView>(R.id.signin_link)

        signin.setOnClickListener{
            val signInlink= Intent(applicationContext,SignUp::class.java)
            startActivity(signInlink)
        }

        val email=findViewById<EditText>(R.id.email)

        val password=findViewById<EditText>(R.id.password)

        val signIn=findViewById<Button>(R.id.signin)

        signIn.setOnClickListener {
            val api="https://julie.alwaysdata.net/api/signin"

//            RequestParams is the container used to collect the user details. It is like form data in js
            val data= RequestParams()

            data.put("email",email.text.toString().trim())
            data.put("password",password.text.toString().trim())

//            API helper-it delivers our data to the api

            val helper= ApiHelper(applicationContext)
            helper.post_login(api,data)
        }
    }
}