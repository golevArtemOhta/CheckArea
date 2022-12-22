package com.example.checkarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.checkarea.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var x by Delegates.notNull<Float>()
    var y by Delegates.notNull<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            button.setOnClickListener {
                x = editTextX.text.toString().toFloat()
                y = editTextY.text.toString().toFloat()
                if (x <= 2.5 && x >= -2.5 && y <= 5 && y >= -2.5 ){
                    textResult.text = "Точка попадает в коордианты"
                }
                else{
                    textResult.text = "Точка не попадает в коордианты"
                }
            }
            buttonOpenTwoActivity.setOnClickListener {
                val k = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(k)
            }
        }




    }
}