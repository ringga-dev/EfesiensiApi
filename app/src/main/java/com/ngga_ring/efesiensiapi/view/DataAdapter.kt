package com.ngga_ring.efesiensiapi.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ngga_ring.efesiensiapi.R
import com.ngga_ring.efesiensiapi.databinding.ItemViewBinding
import com.ngga_ring.efesiensiapi.models.DataModels

class DataAdapter(
    private var item: MutableList<DataModels>,
    private var context: Context
) : RecyclerView.Adapter<DataAdapter.PageHolder>() {

    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemViewBinding.bind(view)
    }

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        with(holder) {

            binding.run {
                block.text ="Block :${item[position].block}"
                ownerAddress.text ="Owner Address :${item[position].ownerAddress}"
                toAddress.text ="To Address :${item[position].toAddress}"
                contractType.text ="Contract Type :${item[position].contractType}"
                confirmed.text ="Confirmed :${item[position].confirmed}"
                revert.text ="Revert :${item[position].revert}"
                events.text ="Events :${item[position].Events}"
                contractRet.text ="Contract Ret :${item[position].contractRet}"
                amount.text ="Amount :${item[position].amount}"
                cost.text ="Cost ==>\n    fee: ${item[position].cost?.fee} \n    net fee: ${item[position].cost?.netFee}"
            }
        }
    }

    fun setNews(r: List<DataModels>) {
        item.clear()
        item.addAll(r)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder {
        return PageHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false)
        )
    }

    override fun getItemCount() = item.size
}