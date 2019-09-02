package com.example.employeelocation.presentation

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.Observable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.employeelocation.R
import com.example.employeelocation.base.presentation.BaseActivity
import com.example.employeelocation.databinding.ActivityEmployeeListBinding
import com.example.employeelocation.presentation.recyclerview.EmployeeAdapter
import kotlinx.android.synthetic.main.activity_employee_list.*
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
        val itemDecor = DividerItemDecoration(this, VERTICAL)
        binding.employeeListRv.addItemDecoration(itemDecor)

        viewManager = LinearLayoutManager(this)

        setupViewModelObservers(viewModel)

        viewModel.loadData()
    }

    private fun initEmployeeLocationsSpinner() {
        val employeeLocations = viewModel.buildEmployeeLocationsList(viewModel.locations)

        val spinnerAdapter = ArrayAdapter(this, R.layout.employee_locations_spinner_item, employeeLocations)
        employee_locations_spinner.adapter = spinnerAdapter

    }

    private fun setupViewModelObservers(viewModel: EmployeeListViewModel) {
        viewModel.employees
            .addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback() {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    viewAdapter.items = viewModel.employees.get()
                }
            })

        viewModel.locationsList
            .addOnPropertyChangedCallback(object: Observable.OnPropertyChangedCallback()  {
                override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                    initEmployeeLocationsSpinner()
                }
            }
            )
    }

}