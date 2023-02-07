package com.example.realfutball22.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Model.TableItem
import com.example.realfutball22.R

class StandingAdapter(val data: List<TableItem?>?) :
    RecyclerView.Adapter<StandingAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var positions = view.findViewById<TextView>(R.id.txt_pos)
        var names = view.findViewById<TextView>(R.id.txt_name)
        var win = view.findViewById<TextView>(R.id.txt_w)
        var draw = view.findViewById<TextView>(R.id.txt_d)
        var lost = view.findViewById<TextView>(R.id.txt_l)
        var tablerow = view.findViewById<TableRow>(R.id.tablerow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_standing, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.positions.text = data?.get(position)?.position?.toString()
        holder.names.text = data?.get(position)?.team?.shortName
        holder.win.text = data?.get(position)?.won?.toString()
        holder.draw.text = data?.get(position)?.draw?.toString()
        holder.lost.text = data?.get(position)?.lost?.toString()

        val teamname = data?.get(position)?.team?.shortName

        if (teamname.equals("Real Madrid")) {
            holder.tablerow.setBackgroundColor(Color.parseColor("#F8F8F8"))
        } else {
            holder.tablerow.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }


    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data.size
        }
        return 0
    }
}