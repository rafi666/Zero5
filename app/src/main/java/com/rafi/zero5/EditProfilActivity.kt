package com.rafi.zero5

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class EditProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        ambilData()

        btnSave.setOnClickListener { simpanData() }
    }

    private fun simpanData(){
        val namaEdit = edtName.text.toString()
        val telpEdit = edtTelp.text.toString()
        val emailEdit= edtEmail.text.toString()
        val intent = Intent()
        intent.putExtra("namaEdit",namaEdit)
        intent.putExtra("telpEdit",telpEdit)
        intent.putExtra("emailEdit",emailEdit)
        setResult(Activity.RESULT_OK,intent)

    }

    private fun ambilData(){

        val nama = intent.getStringExtra("nama")
        edtName.setText(nama)
        val telp = intent.getStringExtra("telp")
        edtTelp.setText(telp)
        val email = intent.getStringExtra("email")
        edtEmail.setText(email)
    }
}
