package com.ashish.esoftwarica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class loginActivity : AppCompatActivity() {
    private lateinit var edusername : EditText
    private lateinit var edpassword : EditText
    private lateinit var btnlogin : Button

    val username = "softwarica"
    val password = "coventry"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edusername = findViewById(R.id.edusername)
        edpassword = findViewById(R.id.edpassword)
        btnlogin = findViewById(R.id.btnlogin)

        btnlogin.setOnClickListener {
            var inputname = edusername.text.toString()
            var inputpassword = edpassword.text.toString()
            val intent = Intent(this,NavigationBarActivity::class.java)
            if(inputname.isEmpty() || inputpassword.isEmpty()) {
                Toast.makeText(this,"Fields can't be empty..", Toast.LENGTH_SHORT).show()
            }else{
                if (inputname.equals(username)&& inputpassword.equals(password))
                    startActivity(intent)
                else{
                    Toast.makeText(this,"Log in Fail", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}