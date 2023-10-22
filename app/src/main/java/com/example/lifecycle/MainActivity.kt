package com.example.lifecycle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var btnRegister: Button
    lateinit var btnLinearLayout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnRegister = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener(this)
        btnLinearLayout = findViewById(R.id.btn_linear)
        btnLinearLayout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_register ->{
                var getTextFirstNameEditText = findViewById<EditText>(R.id.first_name_edit_text).text.toString()
                var getTextLastNameEditText = findViewById<EditText>(R.id.last_name_edit_text).text.toString()
                var getTextBirthdayEditText = findViewById<EditText>(R.id.birthday_edit_text).text.toString()
                var getTextAddressEditText = findViewById<EditText>(R.id.address_edit_text).text.toString()
                var getTextEmailEditText = findViewById<EditText>(R.id.email_edit_text).text.toString()
                var isCheckedTermsCheckBox = findViewById<CheckBox>(R.id.checkbox_terms).isChecked
                if (checkStrNull(getTextEmailEditText)
                    || checkStrNull(getTextAddressEditText)
                    || checkStrNull(getTextBirthdayEditText)
                    || checkStrNull(getTextFirstNameEditText)
                    || checkStrNull(getTextLastNameEditText)
                    || !isCheckedTermsCheckBox){
                    val toast = Toast.makeText(this, "Please enter all information in the form", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
            R.id.btn_linear ->{
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }
        }
    }

    private fun checkStrNull(str: String): Boolean = str == ""
}