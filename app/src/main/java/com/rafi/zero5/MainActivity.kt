package com.rafi.zero5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var namaInput: String = ""
    var emailInput: String = ""
    var telpInput: String = ""
    var alamatInput: String = ""
    var genderInput: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener() {
            validasiInput()
        }
        setDataSpinnerGender()

    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_list, android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }

    private fun validasiInput() {
        namaInput   = edtName.text.toString()
        emailInput  = edtEmail.text.toString()
        telpInput   = edtTelp.text.toString()
        alamatInput = edtAddress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()

        when {

            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin") -> Toast.makeText(
                this,
                "Jenis Kelamin harus diisi",
                Toast.LENGTH_SHORT
            ).show()
            emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosng"

            else -> {

                Toast.makeText(
                    this, "Navigasi ke halaman profil diri",
                    Toast.LENGTH_SHORT
                ).show()
                navigasiKeProfilDiri()
            }

        }
    }

    private fun navigasiKeProfilDiri() {

        val namaInput   = edtName.text.toString()
        val emailInput  = edtEmail.text.toString()
        val telpInput   = edtTelp.text.toString()
        val alamatInput = edtAddress.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()

        val intent = Intent(this, MyProfil::class.java)

        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)

        intent.putExtras(bundle)

        startActivity(intent)
    }
}
