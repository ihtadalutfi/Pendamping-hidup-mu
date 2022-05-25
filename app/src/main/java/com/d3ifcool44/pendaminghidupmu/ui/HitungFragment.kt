package com.d3ifcool44.pendaminghidupmu.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.d3ifcool44.pendaminghidupmu.MainViewModel
import com.d3ifcool44.pendaminghidupmu.R
import com.d3ifcool44.pendaminghidupmu.databinding.FragmentHitungBinding
import com.d3ifcool44.pendaminghidupmu.model.HasilPH
import com.d3ifcool44.pendaminghidupmu.model.KategoriPH

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            binding.buttonTotal.setOnClickListener { hitungUang() }
            binding.saranButton.setOnClickListener { viewModel.mulaiNavigasi() }
            viewModel.getHasilPH().observe(requireActivity(), { showResult(it) })
            viewModel.getNavigasi().observe(viewLifecycleOwner,{
                if (it == null ) return@observe
                findNavController().navigate(HitungFragmentDirections.actionHitungFragmentToSaranFragment2(it))
                viewModel.selesaiNavigasi()
            })
        }

    private fun hitungUang() {
        val pemasukan = binding.uangMasuk.text.toString().toFloat()
        if (TextUtils.isEmpty(pemasukan.toString())) {
            Toast.makeText(context, "Harus Di isi", Toast.LENGTH_LONG).show()
            return
        }
        val pengeluaran = binding.uangKeluar.text.toString().toFloat()
        if (TextUtils.isEmpty(pengeluaran.toString())) {
            Toast.makeText(context, "Harus Di Isi", Toast.LENGTH_LONG).show()
        }
        val hemat = binding.totalUangText.text.toString().toBoolean()

        viewModel.hitungUang(
            pemasukan.toFloat(),
            pengeluaran.toFloat(),
        )

        }

    private fun showResult(result: HasilPH?){
        if(result == null) return
        binding.totalUangText.text = getString(R.string.kategori_x,getKategoriLabel(result.kategori))
        binding.saranButton.visibility = View.VISIBLE
    }

    private fun getKategoriLabel (kategori:KategoriPH): String{
        val stringRes = when (kategori){
            KategoriPH.HEMAT -> R.string.hemat
            KategoriPH.BOROS -> R.string.boros
        }
        return getString(stringRes)
    }

}

private fun MainViewModel.hitungUang(pemasukan: Float, pengeluaran: Float) {

}


