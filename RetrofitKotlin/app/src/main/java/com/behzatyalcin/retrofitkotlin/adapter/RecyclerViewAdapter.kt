package com.behzatyalcin.retrofitkotlin.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.behzatyalcin.retrofitkotlin.databinding.RowLayoutBinding
import com.behzatyalcin.retrofitkotlin.model.CryptoModel

class RecyclerViewAdapter(val cryptoList :ArrayList<CryptoModel>,private val listener: Listener):RecyclerView.Adapter<RecyclerViewAdapter.CryptoHolder>() {

      interface Listener{
          fun onItemClick(cryptoModel: CryptoModel)
      }


    private val colors:Array<String> = arrayOf("#0000ff","#1A66FF","#0d60ac","#212280","#6d6ee7","#3133eb","#3f40b5","#01026a",
        "#2527da","#0977dd")



    class CryptoHolder(private val binding: RowLayoutBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(cryptoModel: CryptoModel, colors:Array<String>, position: Int, listener: Listener){

            itemView.setOnClickListener{
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            binding.textname.text=cryptoModel.currency
            binding.textprice.text=cryptoModel.price

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoHolder {
        val binding=RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CryptoHolder(binding)
    }

    override fun getItemCount(): Int {
       return cryptoList.size
    }

    override fun onBindViewHolder(holder: CryptoHolder, position: Int) {
          holder.bind(cryptoList[position],colors,position,listener)
    }
}