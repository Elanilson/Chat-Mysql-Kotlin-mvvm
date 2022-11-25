package com.bergburg.chatkotlinmvvm.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmvvm.model.entities.Contato
import com.bergburg.chatkotlinmvvm.R

import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ContatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private lateinit var imagem : CircleImageView
    private lateinit var nome : TextView
    private lateinit var status : TextView

    fun bind(contato: Contato){

        imagem = itemView.findViewById(R.id.profile_imageContato)
        nome = itemView.findViewById(R.id.textViewNomeContato)
       // status = itemView.findViewById(R.id.textViewStatusContato)

        Glide.with(itemView.context).load(contato.imagem).into(imagem);
        nome.setText(contato.nome)



    }
}