package com.gsixacademy.android.budgetplanner.adapters

import com.gsixacademy.android.budgetplanner.data.FeeData

open class FeeDataClickEvent {
    data class FeeDataItemClicked(val feeData:FeeData?):FeeDataClickEvent()
}