package com.ubaya.uts_anmp_160420009.model

data class Berita(
    val id:String,
    val gambarUrl:String,
    val judul:String,
    val pembuat:String,
    val deskripsi:String,
    val subJudul:String,
    val isi:ArrayList<String>
)