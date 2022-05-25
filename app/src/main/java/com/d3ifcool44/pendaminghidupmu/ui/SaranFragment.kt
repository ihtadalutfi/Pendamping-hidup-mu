package com.d3ifcool44.pendaminghidupmu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.d3ifcool44.pendaminghidupmu.R
import com.d3ifcool44.pendaminghidupmu.databinding.FragmentSaranBinding
import com.d3ifcool44.pendaminghidupmu.model.KategoriPH

class SaranFragment : Fragment() {
    private lateinit var binding: FragmentSaranBinding
    private val args:SaranFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                         savedInstanceState: Bundle?): View {
        binding = FragmentSaranBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    private fun updateUI(kategori: KategoriPH) {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar
        when (kategori) {
            KategoriPH.HEMAT -> {
                actionBar?.title = getString(R.string.judul_hemat)
                binding.textView.text = getString(R.string.saran_kurus)
            }
            KategoriPH.BOROS -> {
                actionBar?.title = getString(R.string.judul_boros)
                binding.textView.text = getString(R.string.saran_kurus)
            }
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        updateUI(args.kategori)
    }
}

