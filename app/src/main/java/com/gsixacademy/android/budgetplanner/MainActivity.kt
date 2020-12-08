package com.gsixacademy.android.budgetplanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.gsixacademy.android.budgetplanner.data.FeeData
import com.gsixacademy.android.budgetplanner.data.FeeModel

class MainActivity : AppCompatActivity() {
    lateinit var database: DatabaseReference
    var feeModel:FeeModel?= FeeModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database= FirebaseDatabase.getInstance().reference

        initaliaseFireBaseDatabase()
    }
    private fun initaliaseFireBaseDatabase(){
        val postListener=object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.d("error",error.message)
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                for (objSnapshot in snapshot.getChildren()){
                    val myClass=objSnapshot.getValue(FeeData::class.java)
                    feeModel?.fee?.add(myClass)
                }
            }
        }
        database.addValueEventListener(postListener)
    }


}
