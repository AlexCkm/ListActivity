package com.example.customlvconimagenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customlvconimagenes.databinding.ActivityList2Binding
import com.example.customlvconimagenes.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityList2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityList2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.tvLista.text = "LISTA\n\n"
        var total = 0.0 // Creamos una variable var
        val myExtras = intent.extras
        if (myExtras != null){
            val keys = myExtras.keySet() //Solo te devuelve las key, ya que estan todas ahi
            for (key in keys){
                binding.tvLista.text = binding.tvLista.text.toString()
                    .plus("$key:\t\t\t${myExtras.get(key)}\n")
                total += myExtras.get(key).toString().toDouble() //simplicar una operacion, += es igual que decia a = a + 5 =
            }
            binding.tvLista.text = binding.tvLista.text.toString()
                .plus("\n\nTotal:$total") //Esta es la operacion total
        }
        binding.btnVolver.setOnClickListener {
            onBackPressed()
        }

    }
    fun msj (str:String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}
