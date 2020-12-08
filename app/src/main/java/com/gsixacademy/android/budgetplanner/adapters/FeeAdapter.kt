package com.gsixacademy.android.budgetplanner.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.budgetplanner.R
import com.gsixacademy.android.budgetplanner.data.FeeData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_fragment.view.*

class FeeAdapter (
    val feeDatas:ArrayList<FeeData?>,
    val feeDatasClickEvent:(FeeDataClickEvent.FeeDataItemClicked)->Unit
):RecyclerView.Adapter<RecyclerView.ViewHolder>()

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_fragment,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return feeDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder=holder as MyViewHolder
        myViewHolder.bindData(feeDatas[position],position)
    }
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindData(feedata:FeeData?,position: Int){

        itemView.name_of_cost_TV.text=feedata?.name
        itemView.categoryTV.text=feedata?.category
        itemView.entervalue.text=feedata?.amount.toString()
        Picasso.get().load(feedata?.image).fit().into(itemView.list_IV)
//u picasoto treba da se setira so if za razlicni sliki spored kategorija!!!

    }
}
}