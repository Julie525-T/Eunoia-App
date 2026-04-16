package com.julie.myapplication

import android.os.Bundle
import android.view.PixelCopy
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.loopj.android.http.RequestParams

class Payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Receive/retrieve Extras data the product_name and the product_cost
//        This data is passed via intent

        val productname=intent.getStringExtra("product_name")
        val productcost=intent.getIntExtra("product_cost",0)
        val productphoto=intent.getStringExtra("product_photo")



//        Find views by their id
        val productimage=findViewById<ImageView>(R.id.productimage)
        val name=findViewById<TextView>(R.id.productname)
        val ksh=findViewById<TextView>(R.id.ksh)
        val phone=findViewById<EditText>(R.id.phone)
        val paymentbutton=findViewById<Button>(R.id.paymentbutton)

//        Sudo chown -R $USER:$USER .
//        Update TextViews with values passed via intent

        name.text=productname
        ksh.text="Ksh $productcost"

        Glide.with(this)
            .load(productphoto)
            .circleCrop()
            .into(productimage)

        paymentbutton.setOnClickListener {
            val api=" https://julie.alwaysdata.net/api/mpesa_payment"

            val data= RequestParams()
            data.put("amount",productcost)
            data.put("phone",phone.text.toString())

            val helper= ApiHelper(applicationContext)
            helper.post(api, data)
        }

    }

}