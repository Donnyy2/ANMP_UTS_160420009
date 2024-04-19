package com.ubaya.uts_anmp_160420009.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ubaya.uts_anmp_160420009.model.Berita

class ListViewModel:ViewModel() {
    val beritasLD = MutableLiveData<ArrayList<Berita>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingDoneLD = MutableLiveData<Boolean>()

    private val TAG ="volleyTag"
    //private var queue:RequestQueue ?= null

    fun refresh(){

        val berita1 = Berita("http://dummyimage.com/100x75.png/cc0000/ffffff","I Hate Mondays, (Nie lubie poniedzialku)","Wileen","Occup of 3-whl mv injured in clsn w hv veh nontraf, subs","Sprain infraspinatus","Infraspinatus (muscle) (tendon) sprain")
        val berita2 = Berita("http://dummyimage.com/100x75.png/dddddd/000000","BloodRayne","Rodd","Strain musc and tendons at ank/ft level, unsp foot, sequela","Lymphoid mal NEC axilla","Other and unspecified malignant neoplasms of lymphoid and histiocytic tissue, lymph nodes of axilla and upper limb")
        val berita3 = Berita("http://dummyimage.com/100x75.png/5fa2dd/ffffff","Grateful Dawg","Osborne","Toxic effect of tobacco and nicotine, accidental, init","One eye-moderate/oth-sev","Better eye: moderate vision impairment; lesser eye: severe vision impairment")

        beritasLD.value = arrayListOf<Berita>(berita1, berita2, berita3)
        loadingErrorLD.value = false
        loadingDoneLD.value = true

    }
}