package com.ubaya.uts_anmp_160420009.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ubaya.uts_anmp_160420009.databinding.FragmentReadBinding
import com.ubaya.uts_anmp_160420009.model.Berita
import com.ubaya.uts_anmp_160420009.util.loadImage
import com.ubaya.uts_anmp_160420009.viewmodel.ListViewModel


class ReadFragment : Fragment() {
    private lateinit var binding: FragmentReadBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            viewModel = ViewModelProvider(this)[ListViewModel::class.java]
            viewModel.refresh()
        }
    }
}