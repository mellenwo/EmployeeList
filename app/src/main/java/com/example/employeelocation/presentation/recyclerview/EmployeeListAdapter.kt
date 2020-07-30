package com.example.employeelocation.presentation.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelocation.R
import com.example.employeelocation.base.delegate.observer
import com.example.employeelocation.databinding.RvListItemEmployeeBinding
import com.example.employeelocation.domain.model.EmployeeDomainModel

class EmployeeListAdapter: RecyclerView.Adapter<EmployeeListAdapter.ViewHolder>() {

    var items: List<EmployeeDomainModel> by observer(listOf()) {
        notifyDataSetChanged()
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RvListItemEmployeeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.rv_list_item_employee, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder (
        private val binding: RvListItemEmployeeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(employeeDomainModel: EmployeeDomainModel) {
            // setting employee object
            binding.employee = employeeDomainModel
        }

    }
}