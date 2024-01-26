package com.example.gastoviagem

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.buttonCalculate.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            if (view.id == R.id.button_calculate){
                calculate()
            }
        }

        private fun isValid():Boolean{
            return (binding.editDistance.text.toString() != ""
                    && binding.editPrice.text.toString() != ""
                    && binding.editAutonomy.text.toString() !=""
                    && binding.editAutonomy.text.toString().toFloat() != 0f)
        }

        private fun calculate(){
            var distance = 0f
            if(binding.editDistance.text.toString() !=""){
                distance = binding.editDistance.text.toString().toFloat()

            }


            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

           // Toast.makeText(this, totalValueStr,Toast.LENGTH_SHORT).show()
        }
}

