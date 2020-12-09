package com.gsixacademy.android.budgetplanner.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.gsixacademy.android.budgetplanner.R
import kotlinx.android.synthetic.main.botom_navigation.view.*

class CustomBotomNavigation:FrameLayout {
    internal lateinit var mInflater: LayoutInflater

    constructor(context:Context):super(context){
        init(context)

    }
    constructor(context: Context, attr:AttributeSet?, style:Int):super(context,attr,style){
        init(context)
    }
    constructor(context: Context,attr: AttributeSet?):super(context,attr){
        init(context)
    }
    fun init(context: Context){
        mInflater= LayoutInflater.from(context)
        mInflater.inflate(R.layout.botom_navigation,this,true)
    }
    fun setSelectedTab(tabToSelect:Int){
        money_left.isSelected=tabToSelect==1
        statistics.isSelected=tabToSelect==2
    }
}