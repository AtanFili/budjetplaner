package com.gsixacademy.android.budgetplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.firebase.database.*
import com.gsixacademy.android.budgetplanner.data.FeeData
import com.gsixacademy.android.budgetplanner.data.FeeModel
import kotlinx.android.synthetic.main.botom_navigation.*

class MainActivity : AppCompatActivity() {


    lateinit var database: DatabaseReference
    var feeModel: FeeModel? = FeeModel()
    lateinit var navControler: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = FirebaseDatabase.getInstance().reference
        navControler= Navigation.findNavController(this,R.id.navigation_host_fragment)
        initaliaseFireBaseDatabase()
    }

    private fun initaliaseFireBaseDatabase() {
        val postListener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.d("error", error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (objSnapshot in snapshot.getChildren()) {
                    val myClass = objSnapshot.getValue(FeeData::class.java)
                    feeModel?.fee?.add(myClass)
                }
            }
        }
        database.addValueEventListener(postListener)



        money_left.setOnClickListener { 
            findNavController().navigate(R.id.action_monthFragment_to_yearlyStatistic)
        }
        statistics.setOnClickListener {
            findNavController().navigate(R.id.action_monthFragment_to_yearlyStatistic)
        }
    }

    private fun findNavController(): NavController {

    }


}
