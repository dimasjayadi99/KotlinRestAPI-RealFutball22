package com.example.realfutball22.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Model.Group.StandingsItem
import com.example.realfutball22.R

class GroupStageHeaderAdapter(val header: List<StandingsItem?>?) :
    RecyclerView.Adapter<GroupStageHeaderAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_header = view.findViewById<TextView>(R.id.txt_header)
        val rv_itemgroupstage = view.findViewById<RecyclerView>(R.id.rv_itemgroupstage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header_groupstage, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_header.text = header?.get(position)?.group?.replace("_", " ")
        val standingTeamAdapter = GroupStageStandingAdapter(header?.get(position)?.table)
//        holder.rv_itemgroupstage.adapter = standingTeamAdapter
        holder.rv_itemgroupstage.apply {
            layoutManager = LinearLayoutManager(holder.itemView.context)
            setHasFixedSize(true)
            standingTeamAdapter.notifyDataSetChanged()
            adapter = standingTeamAdapter
        }
    }

    override fun getItemCount(): Int {
        if (header != null) {
            return header.size
        }
        return 0
    }
}