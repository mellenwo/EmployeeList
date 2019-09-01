package com.example.employeelocation.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelocation.R
import com.example.employeelocation.base.presentation.BaseActivity
import com.example.employeelocation.databinding.ActivityEmployeeListBinding
import com.example.employeelocation.presentation.recyclerview.EmployeeAdapter

class EmployeeListActivity: BaseActivity() {

    private lateinit var binding: ActivityEmployeeListBinding
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_employee_list)

        viewManager = LinearLayoutManager(this)
        viewAdapter = EmployeeAdapter()
    }

}