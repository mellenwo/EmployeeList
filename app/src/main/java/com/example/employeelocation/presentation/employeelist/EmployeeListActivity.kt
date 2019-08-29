package com.example.employeelocation.presentation.employeelist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.employeelocation.R
import com.example.employeelocation.databinding.ActivityEmployeeListBinding

class EmployeeListActivity: AppCompatActivity() {

    private lateinit var binding: ActivityEmployeeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_employee_list)
    }

}