package com.bergburg.chatkotlinmvvm.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bergburg.chatkotlinmvvm.R
import com.bergburg.chatkotlinmvvm.databinding.ActivityChatBinding
import com.bergburg.chatkotlinmvvm.model.entities.Mensagem
import com.bergburg.chatkotlinmvvm.view.adapter.MensagemAdapter
import com.bergburg.chatkotlinmvvm.viewModel.ChatViewModel
import java.util.*

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private lateinit var viewModel : ChatViewModel
    private  var adapter = MensagemAdapter()
    private var idUsuario  : Long  = 1L
    private var idRemetente  : Long  = 1L
    private  var idConversa : Long = 0
    private lateinit var texto : String
    private lateinit var runnable : Runnable
    private var ticker  : Boolean = false
    private var handle = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ChatViewModel::class.java)

        binding.imageButtonEnviar.setOnClickListener {
            texto = binding.editTextMensagem.text.toString()
            viewModel.enviarMensagem(idRemetente,idConversa,texto)
            binding.editTextMensagem.setText("")
        }

        observe()
        configurarRecycleview()
    }

    private fun observe() {
        viewModel.mensagens.observe(this){
            adapter.attackMensagens(it)
        }
        viewModel.mensagem.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun  configurarRecycleview(){
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewChat.adapter = adapter

    }
    private fun startClock(){
        var calendar = Calendar.getInstance()
        runnable = Runnable {
            kotlin.run {
                if(!ticker){
                    return@run
                }

                viewModel.exibirConversas(idUsuario)

                var now = SystemClock.uptimeMillis()
                var next = now + (1000 - (now % 1000))
                println(now)
                handle.postAtTime(runnable,next)
            }
        }
        runnable.run()

    }



    override fun onResume() {
        super.onResume()

        val bundle = intent.extras
        if(bundle != null){
            idUsuario =  bundle.getLong("idUsuario")
            idConversa =  bundle.getLong("idConversa")
            viewModel.exibirConversas(idUsuario)
            ticker = true
            startClock()
        }
    }

    override fun onStop() {
        super.onStop()
        ticker = false
    }
}