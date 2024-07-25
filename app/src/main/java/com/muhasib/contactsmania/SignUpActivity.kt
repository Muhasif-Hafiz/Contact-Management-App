package com.muhasib.contactsmania

import User
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)



        val signButton= findViewById<Button>(R.id.btnSign)
        val etName=findViewById<TextInputEditText>(R.id.etName)
        val etEmail= findViewById<TextInputEditText >(R.id.etMail)
        val contactNumber= findViewById<TextInputEditText>(R.id.etUser)
        val etPassword= findViewById<TextInputEditText>(R.id.etPassword)





        signButton.setOnClickListener {

            var name = etName.text.toString()
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()
            var number = contactNumber.text.toString()


            var user = User(name, email, number, password)


                database = FirebaseDatabase.getInstance().getReference("Users")




                database.child(number).setValue(user).addOnSuccessListener {

                    etName.text?.clear()
                    etEmail.text?.clear()
                    etPassword.text?.clear()
                    contactNumber.text?.clear()

                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed to register!", Toast.LENGTH_SHORT).show()
                }
            }

        val registered= findViewById<TextView>(R.id.tvAlreadyRegistered)

        registered.setOnClickListener{

            val  intent2= Intent(this, LogInActivity::class.java)
            startActivity(intent2)
        }
        }
    override fun onPause() {
        super.onPause()
        finish()
    }
}