package com.julie.myapplication

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class About : AppCompatActivity() {

//    Declare a tts variable.
//    5 usages

//    Lateinit to show that the variable will be declared later

   lateinit var tts: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textview=findViewById<TextView>(R.id.textview)
        val inputtext=findViewById<EditText>(R.id.inputText)
        val speakbutton=findViewById<Button>(R.id.speakButton)


//        Create a TTs object, check if tts is available and set Language
//        Starting the text to speech engine

        tts= TextToSpeech(this){
//        check if the speech is successful
            if (it== TextToSpeech.SUCCESS){
                tts.language= Locale.US
            }
        }


        speakbutton.setOnClickListener {
            val textt=inputtext.text.toString()
            tts.speak(textt, TextToSpeech.QUEUE_FLUSH,null,null)
        }

        fun onDestroy(){
            tts.stop()
            tts.shutdown()
            super.onDestroy()
            

        }

        }
        }



