package com.example.employeelocation.presentation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.Observable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        title = "Employee Directory"

        initRecyclerView()

        setupViewModelObservers(viewModel)

        viewModel.loadData()
    }

    private fun initRecyclerView() {
        binding.employeeListRv.layoutManager = LinearLayoutManager(this)
        binding.employeeListRv.adapter = viewAdapter
        viewManager = LinearLayoutManager(this)
    }

    private fun initEmployeeLocationsSpinner() {
        val employeeLocations = viewModel.buildEmployeeLocationsList(viewModel.locations)

        val spinnerAdapter = ArrayAdapter(this, R.layout.employee_locations_spinner_item, employeeLocations)
        employee_locations_spinner.adapter = spinnerAdapter

        employee_locations_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.filterByLocation(employeeLocations[position])
            }

        }
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
            })
    }

}