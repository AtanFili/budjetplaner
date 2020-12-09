package com.gsixacademy.android.budgetplanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.budgetplanner.MainActivity
import com.gsixacademy.android.budgetplanner.R
import com.gsixacademy.android.budgetplanner.data.FeeModel
import kotlinx.android.synthetic.main.month_fragment.*

class MonthFragment:Fragment() {
    var feeList:FeeModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       return inflater.inflate(R.layout.month_fragment,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        feeList=(activity as MainActivity).feeModel

        val feeImage=arguments?.getString("feeImage")?:""
        val feeAmount=arguments?.getString("feeAmount")?:""
        val feeCategory=arguments?.getString("feeCategory")?:""
        val feeName=arguments?.getString("feeName")?:""

        fab_next_screen.setOnClickListener{
            var bundle=Bundle()
            findNavController().navigate(R.id.action_monthFragment_to_yearlyStatistic,bundle)
        }
    }
    //
}