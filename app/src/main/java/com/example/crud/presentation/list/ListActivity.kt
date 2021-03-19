package com.example.crud.presentation.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crud.CRUDApplication
import com.example.crud.R
import com.example.crud.database.entity.UserEntity
import com.example.crud.presentation.list.listadapter.ListAdapter
import com.example.crud.presentation.list.listadapter.ListItemListener
import com.example.crud.presentation.main.MainActivity
import com.example.crud.presentation.update.UpdateUserActivity
import kotlinx.android.synthetic.main.activity_list.*
import java.security.CryptoPrimitive

class ListActivity : AppCompatActivity(), ListItemListener {

    val adapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        userRecyclerView.adapter = adapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)

        val data = (application as CRUDApplication).getDataBase()?.userDao()?.getAll()
        Log.d("ListActivity", "data = $data")
        data?.let { adapter.setData(it) }

    }

    override fun onUserClick(user: UserEntity) {
        val intent = Intent(this, UpdateUserActivity::class.java)
        intent.putExtra("user", user.id)
        startActivity(intent)
    }

    override fun onUserLongClick(user: UserEntity, position: Int) {
        AlertDialog.Builder(this)
            .setTitle(R.string.dialog_title_delete_user_by_id)
            .setMessage(R.string.dialog_message_delete_user_by_id)
            .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                deleteUserById(user.id, position)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.dialog_negative_button) { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun deleteUserById(id: Int, position: Int) {
        (application as CRUDApplication).getDataBase()?.userDao()?.deleteById(id)
        adapter.deleteItem(position)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(R.string.menu_delete_all_users)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        AlertDialog.Builder(this)
            .setTitle(R.string.dialog_title_delete_all_users)
            .setMessage(R.string.dialog_message_delete_all_users)
            .setPositiveButton(R.string.dialog_positive_button) { dialog, _ ->
                deleteAllUsers()
                dialog.dismiss()
                startMainActivity()
            }
            .setNegativeButton(R.string.dialog_negative_button) { dialog, _ -> dialog.dismiss() }
            .show()
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() =
        (application as CRUDApplication).getDataBase()?.userDao()?.deleteAll()

    private fun startMainActivity(){
        var intent = Intent(this, MainActivity::class.java)
        finishAffinity()
        startActivity(intent)
    }
}






