package com.example.employeelocation.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeelocation.R
import com.example.employeelocation.base.delegate.observer
import com.example.employeelocation.domain.model.EmployeeDomainModel

class EmployeeAdapter: RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    var employees: List<EmployeeDomainModel> by observer(listOf()) {
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_item_employee, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(employees[position])
    }

    override fun getItemCount(): Int = employees.size

    inner class ViewHolder (
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        //private var

        fun bind(albumDomainModel: EmployeeDomainModel) {

        }

    }


}