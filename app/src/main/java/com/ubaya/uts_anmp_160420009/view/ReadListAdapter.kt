package com.ubaya.uts_anmp_160420009.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_anmp_160420009.databinding.FragmentDetailBinding
import com.ubaya.uts_anmp_160420009.databinding.FragmentReadBinding
import com.ubaya.uts_anmp_160420009.model.Berita

class ReadListAdapter(val beritaList:ArrayList<Berita>) {
    class ReadViewHolder(var binding:FragmentReadBinding)

    fun updateBeritaList(newBeritaList:List<Berita>){
        beritaList.clear()
        beritaList.addAll(newBeritaList)
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadViewHolder{
        val binding = FragmentReadBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ReadViewHolder(binding)
    }

    fun getItemCount(): Int{
        return beritaList.size
    }

    fun onBindViewHolder(holder: ReadListAdapter.ReadViewHolder, position: Int) {
        holder.binding.txtJudul.text = beritaList[position].judul
        holder.binding.txtPembuat.text = beritaList[position].pembuat
        holder.binding.txtSubJudul.text = beritaList[position].subJudul
        holder.binding.txtIsi.text = beritaList[position].isi

        holder.binding.btnNext.setOnClickListener{
            val action = HomeFragmentDirections.actionDetail()
            Navigation.findNavController(it).navigate(action)
        }
        holder.binding.btnPrev.setOnClickListener{
            val action = HomeFragmentDirections.actionDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }
}