package com.tugasuas.tugasuas.katalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tugasuas.tugasuas.database.Makanan
import androidx.recyclerview.widget.RecyclerView
import com.ahmad.tugasuas.R

class katalogAdapter(private var dataMakanan: List<Makanan>)
    : RecyclerView.Adapter<katalogAdapter.MakananViewHolder>(){

    var onItemClick: ((Makanan) -> Unit)? = null

    class MakananViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val ivMhs: ImageView = row.findViewById(R.id.ivGambar)
        val tvJudul: TextView = row.findViewById(R.id.tvJudul)
        val tvJenis: TextView = row.findViewById(R.id.tvJenis)
        val tvWaktu: TextView = row.findViewById(R.id.tvWaktu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.data_makanan, parent, false)
        return MakananViewHolder(layout)
    }

    // untuk membatasi jumlah data yang akan di tampilkan
    override fun getItemCount(): Int {
        return dataMakanan.size
    }

    //  data yang akan di tampilkan
    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val makanan = dataMakanan[position]
        holder.ivMhs.setImageResource(makanan.gambar)
        holder.tvJudul.text = makanan.judul
        holder.tvJenis.text = makanan.jenis.toString()
        holder.tvWaktu.text = makanan.waktu

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(makanan)
        }
    }
}