package com.muhasib.contactsmania

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class contactsScreen : AppCompatActivity() {

    lateinit var databaseRef: DatabaseReference
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contacts_screen)

        val userName = intent.getStringExtra(LogInActivity.Key)
        val userNumber = intent.getStringExtra("number")

        val owner = findViewById<TextView>(R.id.tvOwner)
        owner.text = "Welcome $userName"

        val contactName = findViewById<TextInputEditText>(R.id.addName)
        val contactNumber = findViewById<TextInputEditText>(R.id.addNumber)
        val addContact = findViewById<Button>(R.id.addButton)

        addContact.setOnClickListener {
            val contactNameText = contactName.text.toString()
            val contactNumberText = contactNumber.text.toString()

            if (contactNameText.isEmpty() || contactNumberText.isEmpty()) {
                Toast.makeText(applicationContext, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val contactInfo = contactNumberDataClass(contactNameText, contactNumberText)

            // Ensure userNumber is not null before proceeding
            if (userNumber != null) {
                databaseRef = FirebaseDatabase.getInstance().getReference("Users/$userNumber/contactNumber/numberList")
                databaseRef.child(contactNameText).setValue(contactInfo).addOnSuccessListener {
                    dialog = Dialog(this)
                    dialog.setContentView(R.layout.dialoglayout)
                    dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.shapedialog))

                    val buttonSaved = dialog.findViewById<Button>(R.id.buttonDismiss)
                    buttonSaved.setOnClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()

                    Toast.makeText(applicationContext, "Contact saved successfully", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(applicationContext, "Failed to save contact", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "User number is not available", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onPause() {
        super.onPause()
        finish()
    }
}
