package com.gsixacademy.android.budgetplanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.budgetplanner.adapters.FeeAdapter
import com.gsixacademy.android.budgetplanner.MainActivity
import com.gsixacademy.android.budgetplanner.R
import com.gsixacademy.android.budgetplanner.adapters.FeeDataClickEvent
import com.gsixacademy.android.budgetplanner.data.FeeModel
import kotlinx.android.synthetic.main.recycler_fee.*

class ListFragment:Fragment() {
    var modelList:FeeModel?=null
    lateinit var feeAdapter: FeeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_fee,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        val feeSelected=arguments?.getString("feeSelected")
    }
    private fun initRecyclerView(){
        val feeModel = (activity as MainActivity).feeModel

       feeAdapter=
           FeeAdapter(feeModel?.fee!!) {
               if ( it is FeeDataClickEvent.FeeDataItemClicked){

                   var bundle=Bundle()
                   bundle.putString("feeImage",it.feeData?.image.toString())
                   bundle.putString("feeAmount",it.feeData?.amount.toString())
                   bundle.putString("feeCategory",it.feeData?.category.toString())
                   bundle.putString("feeName",it.feeData?.name.toString())




               }
           }

           fee_recycler.adapter=feeAdapter

    }
}