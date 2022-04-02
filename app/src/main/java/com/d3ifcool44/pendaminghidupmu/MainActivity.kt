package com.d3ifcool44.pendaminghidupmu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.CompoundButton
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.d3ifcool44.pendaminghidupmu.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTotal.setOnClickListener { hitungUang() }
    }

    private fun hitungUang() {
        val pemasukan = binding.uangMasuk.text.toString()
        if (TextUtils.isEmpty(pemasukan)) {
            Toast.makeText(this, "Harus Di isi", Toast.LENGTH_LONG).show()
            return
        }
        val pengeluaran = binding.uangKeluar.text.toString()
        if (TextUtils.isEmpty(pengeluaran)) {
            Toast.makeText(this, "Harus Di Isi", Toast.LENGTH_LONG).show()
            return


        }

    }
}

