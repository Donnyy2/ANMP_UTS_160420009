package com.ubaya.uts_anmp_160420009.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.uts_anmp_160420009.R
import com.ubaya.uts_anmp_160420009.databinding.FragmentDetailBinding
import com.ubaya.uts_anmp_160420009.model.Berita

class BeritaListAdapter(val beritaList:ArrayList<Berita>):RecyclerView.Adapter<BeritaListAdapter.BeritaViewHolder>() {
    class BeritaViewHolder(val binding:FragmentDetailBinding):RecyclerView.ViewHolder(binding.root)

    fun updateBeritaList(newBeritaList: List<Berita>){
        beritaList.clear()
        beritaList.addAll(newBeritaList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val binding = FragmentDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return BeritaViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        holder.binding.txtTitle.text = beritaList[position].judul
        holder.binding.txtCreator.text = beritaList[position].pembuat
        holder.binding.txtDesc.text = beritaList[position].deskripsi

        holder.binding.btnRead.setOnClickListener{
            val action = DetailFragmentDirections.actionRead()
            Navigation.findNavController(it).navigate(action)
        }
    }
}