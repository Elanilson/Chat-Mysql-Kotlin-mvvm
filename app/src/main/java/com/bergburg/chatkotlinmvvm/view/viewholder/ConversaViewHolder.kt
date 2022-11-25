package com.bergburg.chatkotlinmvvm.view.viewholder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmvvm.R
import com.bergburg.chatkotlinmvvm.interfaces.AcaoListener
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.model.entities.Conversa

import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ConversaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var imagem : CircleImageView
    private lateinit var nome : TextView
    private lateinit var status : TextView
    private lateinit var data : TextView
    private lateinit var layout : LinearLayout

    fun bind(conversa: Conversa, listener: AcaoListener<Conversa>){

        imagem = itemView.findViewById(R.id.profile_imageConversa)
        nome = itemView.findViewById(R.id.textViewNomeConversa)
        data = itemView.findViewById(R.id.textViewDataConversa)
        layout = itemView.findViewById(R.id.linearLayoutConversa)
       // status = itemView.findViewById(R.id.textViewStatusContato)

        Glide.with(itemView.context).load(conversa.imagemUsuario).into(imagem);
        nome.setText(conversa.nome)
        data.setText(conversa.data_create)
        layout.setOnClickListener { listener.onClick(conversa) }



    }
}