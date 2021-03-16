package com.example.crud_room_database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.crud_room_database.RecyclerView.ListActivity
import com.example.crud_room_database.UserDatabase.UserEntity
import kotlinx.android.synthetic.main.activity_insert_user.*

class IsertUserActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_user)


        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val saveButton = findViewById<Button>(R.id.bttn_save)

        saveButton.setOnClickListener {
           insertDataToDatabase()

        }
    }

    private fun insertDataToDatabase() {
        val name = et_name.text.toString()
        val surname = et_surname.text.toString()
        val gender = et_gender.text.toString()
        val age = et_age.text

        if (inputCheck(name, surname, gender, age)){
            val user = UserEntity(0 , name, surname, gender, Integer.parseInt(age.toString()))
            userViewModel.insertAll(user)
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, surname: String, gender: String, age: Editable):
            Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(surname)
                && TextUtils.isEmpty(gender) && age.isEmpty())
    }
}




