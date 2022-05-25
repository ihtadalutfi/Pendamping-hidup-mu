package com.d3ifcool44.pendaminghidupmu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.d3ifcool44.pendaminghidupmu.model.HasilPH
import com.d3ifcool44.pendaminghidupmu.model.KategoriPH

class MainViewModel : ViewModel() {
    private val hasilPH = MutableLiveData<HasilPH?>()
    private val navigasi = MutableLiveData<KategoriPH?>()

    fun hitungUang(pemasukan: Float, pengeluaran: Float, hemat: Boolean) {
        val total = pemasukan / (pengeluaran * pengeluaran)
        val kategori = getKategori(total, hemat)
        hasilPH.value = HasilPH(total,kategori)

    }
        private fun getKategori(total: Float, hemat: Boolean) : KategoriPH {
            val kategori = if (hemat) {

                when {
                    total < 1000 -> KategoriPH.HEMAT
                    total >= 100000-> KategoriPH.BOROS
                    else -> KategoriPH.HEMAT }
            } else { when {
                total < 100 -> KategoriPH.HEMAT
                total >= 1000000-> KategoriPH.BOROS
                else -> KategoriPH.HEMAT }
            }
            return kategori }
    fun getHasilPH():LiveData<HasilPH?> = hasilPH

    fun mulaiNavigasi() {
        navigasi.value = hasilPH.value?.kategori
    }
    fun selesaiNavigasi() {
        navigasi.value = null
    }
    fun getNavigasi() : LiveData<KategoriPH?> = navigasi
}