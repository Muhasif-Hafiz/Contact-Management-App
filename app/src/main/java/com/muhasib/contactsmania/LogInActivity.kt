package com.muhasib.contactsmania

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LogInActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference

    companion object {
        const val Key: String = "com.muhasib.contactsmania.Key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)

        val contactNumber = findViewById<TextInputEditText>(R.id.logNumber)
        val loginPassword = findViewById<TextInputEditText>(R.id.logPassword)  // Updated ID
        val signIn = findViewById<Button>(R.id.btnLogin)

        signIn.setOnClickListener {
            val number = contactNumber.text.toString()

            if (number.isNotEmpty()) {
                readData(number)
            } else {
                Toast.makeText(this, "Please Enter Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(number: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")

        database.child(number).get().addOnSuccessListener {
            if (it.exists()) {
                val myName = it.child("name").value
                val num = it.child("contactNumber").value
                val intent1 = Intent(this, contactsScreen::class.java)

                intent1.putExtra(Key, myName.toString())
                intent1.putExtra("number", number)  // Corrected to pass the entered number
                startActivity(intent1)
            } else {
                Toast.makeText(this, "No user found!", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to read data", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
