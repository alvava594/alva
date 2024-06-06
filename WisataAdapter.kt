package com.example.listpariwisata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class WisataAdapter(private val wisataList: String, s: String) : RecyclerView.Adapter<WisataAdapter.ViewHolder>() {

    var onItemClick : ((WisataModel) -> Unit)? = null

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val wisataName = itemView.findViewById<TextView>(R.id.nama_wisata_tv)
        val wisataImage = itemView.findViewById<CircleImageView>(R.id.gambar_wisata_iv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wisata,parent, false))
    }

    override fun onBindViewHolder(holder: WisataAdapter.ViewHolder, position: Int) {
        val wisata = wisataList[position]

        holder.wisataName.text = wisata.wisataName
        holder.wisataImage.setImageResource(wisata.wisataImage)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(wisata)
        }
    }

    override fun getItemCount(): Int {
        return wisataList.size
    }

}