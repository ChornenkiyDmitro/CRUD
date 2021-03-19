package com.example.crud.presentation.update

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crud.CRUDApplication
import com.example.crud.R
import com.example.crud.database.entity.UserEntity
import com.example.crud.presentation.list.ListActivity
import kotlinx.android.synthetic.main.activity_main.etAge
import kotlinx.android.synthetic.main.activity_main.etGender
import kotlinx.android.synthetic.main.activity_main.etName
import kotlinx.android.synthetic.main.activity_main.etSurname
import kotlinx.android.synthetic.main.activity_update_user.*


class UpdateUserActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        val idUser: Int = intent.getSerializableExtra("user") as Int
        val user = getUserById(idUser)
        title = user?.name

        buttonUpdate.setOnClickListener {
            user?.id?.let { updateUser(it)}
        }

    }

    private fun getUserById(idUser: Int): UserEntity? = (application as CRUDApplication)
            .getDataBase()?.userDao()?.findById(idUser)



    private fun updateUser(idUser: Int) {
        val name = etName.text.toString()
        val surname = etSurname.text.toString()
        val gender = etGender.text.toString()
        val age = etAge.text

        if (inputCheck(name, surname, gender, age)) {
            val userUpdate = UserEntity(idUser, name, surname, gender, Integer.parseInt(age.toString()))
            (application as CRUDApplication).getDataBase()?.userDao()?.updateUser(userUpdate)
            Toast.makeText(this, "Success change", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, surname: String, gender: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(name)
                && TextUtils.isEmpty(surname)
                && TextUtils.isEmpty(gender)
                && age.isEmpty())

    }

}