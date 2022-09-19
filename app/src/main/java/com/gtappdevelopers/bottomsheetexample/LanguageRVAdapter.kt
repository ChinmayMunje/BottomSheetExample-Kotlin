package com.gtappdevelopers.bottomsheetexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageRVAdapter(
    private val languageRVList: List<LanguageRVModal>,
    val languageClickListner: onLanguageClickListner
) :
    RecyclerView.Adapter<LanguageRVAdapter.LanguageViewHolder>() {
    class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lngIV: ImageView = itemView.findViewById(R.id.idIVLanguage)
        val lngNameTV: TextView = itemView.findViewById(R.id.idTVLanguage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_rv_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        val lngRVItem = languageRVList[position]
        holder.lngNameTV.text = lngRVItem.languageName
        holder.lngIV.setImageResource(lngRVItem.lngImg)
        holder.itemView.setOnClickListener {
            languageClickListner.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return languageRVList.size
    }
}

interface onLanguageClickListner {
    fun onClick(position: Int)
}