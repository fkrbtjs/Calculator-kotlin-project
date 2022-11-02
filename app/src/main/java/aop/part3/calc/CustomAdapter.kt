package aop.part3.calc

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import aop.part3.calc.databinding.ItemCalcresultBinding


class CustomAdapter(val dataList:MutableList<DataVO>, val parentContext: Context): RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemCalcresultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, position: Int) {
        val binding = customViewHolder.binding
        val data = dataList.get(position)
        binding.tvCalculate.text = data.value
        binding.tvRes.text=data.result
        customViewHolder.itemView.setOnLongClickListener {
            val dataVO:DataVO = dataList.get(position)
            (parentContext as MainActivity).refreshRecyclerViewDrop(dataVO)
            true
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class  CustomViewHolder(val binding: ItemCalcresultBinding): RecyclerView.ViewHolder(binding.root)
}