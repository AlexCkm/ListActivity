package com.example.customlvconimagenes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.customlvconimagenes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var lista = mutableMapOf<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        }
    fun addItem (view: View){
        if (binding.etTitulo.text.isNotEmpty() and binding.etDescripcion.text.isNotEmpty()){
            lista.put(binding.etTitulo.text.toString(), binding.etDescripcion.text.toString())
            binding.etTitulo.text.clear()
            binding.etDescripcion.text.clear()
//              msj(lista.toString())
        } else {
            msj("Todos los campos son obligatorios")
        }
    }
    fun nextActivity(view:View){
        val myIntent = Intent(this@MainActivity, ListActivity::class.java)
        lista.forEach { k,v ->
            myIntent.putExtra(k,v) //k de key y v de valor
        }
        startActivity(myIntent)
    }

    fun msj (str:String){
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }
}