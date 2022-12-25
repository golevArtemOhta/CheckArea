package com.example.checkarea

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RectangleViewModel: ViewModel() {

    val textResult = MutableLiveData<String>()


    fun request(x: Float, y: Float) {
        if (x <= 2.5 && x >= -2.5 && y <= 5 && y >= -2.5 ){
            textResult.value = "Точка попадает в коордианты"
        }
        else{
            textResult.value = "Точка не попадает в коордианты"
        }
    }
}