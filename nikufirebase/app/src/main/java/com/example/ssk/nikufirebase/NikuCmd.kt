package com.example.ssk.nikufirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class NikuCmd : AppCompatActivity() {
    lateinit var Nikubar:EditText

    lateinit var Nikubtn:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_niku_cmd)
    Nikubar = findViewById(R.id.line_cmd)
    Nikubtn = findViewById(R.id.Niku_Do)

        Nikubtn.setOnClickListener()
        {
            savetext()
        }
    }

    private fun savetext(){
        val name = Nikubar.text.toString().trim()
        if (name.isEmpty())
        {

            Nikubar.error = "Please enter a command"
            return
        }

        val ref = FirebaseDatabase.getInstance().reference
        ref.child("Text").push().key
        ref.child("Text").setValue(name).addOnCompleteListener{
            Toast.makeText(applicationContext,"Command sent",Toast.LENGTH_LONG)
        }


    }
}
