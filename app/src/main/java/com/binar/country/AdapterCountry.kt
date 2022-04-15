package com.binar.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item.view.*

class AdapterCountry(private val listcountry : List<GetAllCountryItem>):RecyclerView.Adapter<AdapterCountry.ViewHolder>(){
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCountry.ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: AdapterCountry.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(listcountry[position].flags.png)
            .into(holder.itemView.gambar)

        val list = listcountry[position].currencies
        var txt = ""
        if (list!=null){
            for (i in list) {
                txt += i.name
            }
        }


        holder.itemView.text1.text = listcountry[position].name
        holder.itemView.text2.text = listcountry[position].capital
        holder.itemView.text3.text = txt
        holder.itemView.text4.text = listcountry[position].region
    }
    override fun getItemCount(): Int {
        return listcountry.size
    }


}
