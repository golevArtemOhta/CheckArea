package com.example.checkarea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class ShapeViewModel : ViewModel() {

    val textResult = MutableLiveData<String>()


    fun request(x: Float, y: Float) {
        if (x in 2.5..5.0 && y in -0.5..2.0
            && ((x-2.5).pow(2) + (y-2).pow(2))<= (2.5).pow(2)){
            textResult.value = "Точка попадает в коордианты"
        }
        else{
            textResult.value = "Точка не попадает в коордианты"
        }
    }
}