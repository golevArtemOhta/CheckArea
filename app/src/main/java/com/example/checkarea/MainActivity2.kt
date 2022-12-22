package com.example.checkarea

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.checkarea.databinding.ActivityMain2Binding
import kotlin.math.pow
import kotlin.properties.Delegates


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    var x by Delegates.notNull<Float>()
    var y by Delegates.notNull<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            button.setOnClickListener {
                x = editTextX.text.toString().toFloat()
                y = editTextY.text.toString().toFloat()
                if (x in 2.5..5.0 && y in -0.5..2.0 && ((x-2.5).pow(2) + (y-2).pow(2))<= (2.5).pow(2)){
                    textResult.text = "Точка попадает в коордианты"
                }
                else{
                    textResult.text = "Точка не попадает в коордианты"
                }
            }

            buttonOpenTwoActivity.setOnClickListener {
                val k = Intent(this@MainActivity2, MainActivity::class.java)
                startActivity(k)
            }
        }


    }
}