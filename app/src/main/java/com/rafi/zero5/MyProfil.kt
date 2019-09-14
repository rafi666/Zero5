package com.rafi.zero5

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_profil.*

class MyProfil : AppCompatActivity() {
    private val EDIT_REQUEST = 1
    var nama: String = ""
    var email: String = ""
    var telp: String = ""
    var gender: String = ""
    var alamat: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profil)

        val intent = Intent(this, MyProfil::class.java)
        startActivity(intent)

        ambilData()

        btnTelp.setOnClickListener { dialPhoneNumber(telp) }
        btnTelp.setOnClickListener { editProfile() }

    }

    private fun ambilData() {
        val bundle = intent.extras
        val nama   = bundle?.getString("nama")
        val gender = bundle?.getString("gender")
        val email  = bundle?.getString("email")
        val telp   = bundle?.getString("telp")
        val alamat = bundle?.getString("alamat")
        txtName.text    = nama
        txtGender.text  = gender
        txtEmail.text   = email
        txtTelp.text    = telp
        txtAddress.text = alamat
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply { data = Uri.parse("tel:$phoneNumber") }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)


        }

    }

    private fun editProfile(){
        val Intent = Intent(this,EditProfilActivity::class.java)

        intent.putExtra("nama",nama)
        intent.putExtra("telp",telp)
        intent.putExtra("email",email)

        startActivityForResult(intent,EDIT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == EDIT_REQUEST){
            if(resultCode == Activity.RESULT_OK){
                val namaEdit  = data?.getStringExtra("namaEdit")
                txtName.text  = namaEdit
                val telpEdit  = data?.getStringExtra("telpEdit")
                txtTelp.text  = telpEdit
                val emailEdit = data?.getStringExtra("emailEdit")
                txtEmail.text = emailEdit
            }
        }
    }

}

