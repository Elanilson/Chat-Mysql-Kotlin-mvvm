package com.bergburg.chatkotlinmvvm.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bergburg.chatkotlinmvvm.R
import com.bergburg.chatkotlinmvvm.databinding.ActivityEntradaBinding

class EntradaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEntradaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntradaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        binding.buttonIniciar.setOnClickListener { proximaTela() }
    }

    private fun proximaTela() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}