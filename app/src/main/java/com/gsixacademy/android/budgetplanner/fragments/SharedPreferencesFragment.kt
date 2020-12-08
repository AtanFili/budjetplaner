package com.gsixacademy.android.budgetplanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.budgetplanner.R
import kotlinx.android.synthetic.main.shared_preferences_fragment.*

class SharedPreferencesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shared_preferences_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_save.setOnClickListener {
            if (edit_text_enter_name.text.isEmpty()) {
                Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()

            }else if (
                edit_text_enter_monthly_budget.text.isEmpty()){
                  Toast.makeText(context,"Enter your monthly budget here",Toast.LENGTH_SHORT).show()
                //nekako da se napravi da moze da se vnesuvaat samo brojki
            }
            else
            findNavController().navigate(R.id.action_sharedPreferencesFragment_to_listFragment)

        }
    }
}