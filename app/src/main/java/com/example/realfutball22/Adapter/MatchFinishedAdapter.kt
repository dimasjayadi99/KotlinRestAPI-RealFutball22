package com.example.realfutball22.Adapter

import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Model.Match.MatchesItem
import com.example.realfutball22.R
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.squareup.picasso.Picasso
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class MatchFinishedAdapter(val match: List<MatchesItem?>?) : RecyclerView.Adapter<MatchFinishedAdapter.MyViewHolder>() {
    class MyViewHolder (view : View) : RecyclerView.ViewHolder(view) {
        var homeTeam = view.findViewById<TextView>(R.id.txt_hometeam)
        var awayTeam = view.findViewById<TextView>(R.id.txt_awayteam)
        var competitionName = view.findViewById<TextView>(R.id.competitionname)
        var imgHomeTeam = view.findViewById<ImageView>(R.id.img_hometeam)
        var imgAwayTeam = view.findViewById<ImageView>(R.id.img_awayteam)
        var dateMatch = view.findViewById<TextView>(R.id.dateMatch)
        var homeScore = view.findViewById<TextView>(R.id.txt_homeScore)
        var awayScore = view.findViewById<TextView>(R.id.txt_awayScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match_finished,parent,false)
        return MyViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.homeTeam.text = match?.get(position)?.homeTeam?.name
        holder.awayTeam.text = match?.get(position)?.awayTeam?.name
        holder.competitionName.text = match?.get(position)?.competition?.name

        holder.homeScore.text = match?.get(position)?.score?.fullTime?.home
        holder.awayScore.text = match?.get(position)?.score?.fullTime?.away

       // date formatter
        val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formatDateApi = match?.get(position)?.utcDate
        val dateTime: OffsetDateTime = OffsetDateTime.parse(formatDateApi)
        val outPutDate: String = dateTime.format(dateFormat)
        holder.dateMatch.text = outPutDate

        // get image extension from api
        val getExthome = match?.get(position)?.homeTeam?.crest
        val typeExtHome = MimeTypeMap.getFileExtensionFromUrl(getExthome)
        val getExtaway = match?.get(position)?.awayTeam?.crest
        val typeExtAway = MimeTypeMap.getFileExtensionFromUrl(getExtaway)
        val homeTeamImageExt = match?.get(position)?.homeTeam?.crest
        val awayTeamImageExt = match?.get(position)?.awayTeam?.crest

        // if extension of image is svg
        if (typeExtHome.equals("svg")) {
            GlideToVectorYou.init().with(holder.itemView.context)
                .load(Uri.parse(homeTeamImageExt), holder.imgHomeTeam);
        }
        //
        else if (typeExtAway.equals("svg")) {
            GlideToVectorYou.init().with(holder.itemView.context)
                .load(Uri.parse(awayTeamImageExt), holder.imgAwayTeam);
        }
        // else draw image with Piccasso library
        else {
            Picasso.get().load(match?.get(position)?.homeTeam?.crest).into(holder.imgHomeTeam)
            Picasso.get().load(match?.get(position)?.awayTeam?.crest).into(holder.imgAwayTeam)
        }

    }

    override fun getItemCount(): Int {
        if (match != null){
            return match.size
        }
        return 0
    }
}