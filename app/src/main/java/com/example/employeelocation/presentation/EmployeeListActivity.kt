package com.example.employeelocation.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.Observable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelocation.R
import com.example.employeelocation.base.presentation.BaseActivity
import com.example.employeelocation.databinding.ActivityEmployeeListBinding
import com.example.employeelocation.presentation.recyclerview.EmployeeAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class EmployeeListActivity: BaseActivity() {

    private lateinit var binding: ActivityEmployeeListBinding
    private val viewAdapter: EmployeeAdapter by lazy { EmployeeAdapter() }
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val viewModel: EmployeeListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_employee_list)
        binding.viewModel = viewModel

        binding.employeeListRv.layoutManager = LinearLayoutManager(this)
        binding.employeeListRv.adapter = viewAdapter

        viewManager = LinearLayoutManager(this)

        setupViewModelObservers(binding, viewModel)

        viewModel.loadData()
    }

    private fun setupViewModelObservers(binding: ActivityEmployeeListBinding?,
                                        viewModel: EmployeeListViewModel) {
        viewModel.employees
            .addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    viewAdapter.items = viewModel.employees.get()

                }
            })
    }

}