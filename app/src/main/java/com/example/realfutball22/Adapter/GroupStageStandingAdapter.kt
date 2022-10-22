package com.example.realfutball22.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Model.Group.TableItem
import com.example.realfutball22.R

class GroupStageStandingAdapter(val group: List<TableItem?>?) :
    RecyclerView.Adapter<GroupStageStandingAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txt_pos = view.findViewById<TextView>(R.id.txt_pos)
        val txt_team = view.findViewById<TextView>(R.id.txt_team)
        val txt_win = view.findViewById<TextView>(R.id.txt_w)
        val txt_draw = view.findViewById<TextView>(R.id.txt_d)
        val txt_lost = view.findViewById<TextView>(R.id.txt_l)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_groupstage, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txt_pos.text = group?.get(position)?.position
        holder.txt_team.text = group?.get(position)?.team?.shortName
        holder.txt_win.text = group?.get(position)?.won
        holder.txt_draw.text = group?.get(position)?.draw
        holder.txt_lost.text = group?.get(position)?.lost
    }

    override fun getItemCount(): Int {
        if (group != null) {
            return group.size
        }
        return 0
    }
}