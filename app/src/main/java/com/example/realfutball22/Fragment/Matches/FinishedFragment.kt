package com.example.realfutball22.Fragment.Matches

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Adapter.MatchFinishedAdapter
import com.example.realfutball22.Api.Match.ApiConfigMatch
import com.example.realfutball22.Model.Match.ResponseAllMatch
import com.example.realfutball22.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinishedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(context?.applicationContext).inflate(R.layout.fragment_finished,container,false)
        val rv_finished = view.findViewById<RecyclerView>(R.id.rc_match_finished)

        ApiConfigMatch.getService().getMatchFinished(86,"FINISHED","your-key-api").enqueue(object : Callback<ResponseAllMatch>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<ResponseAllMatch>,
                response: Response<ResponseAllMatch>
            ) {
                val responsebody = response.body()
                val responselist = responsebody?.matches
                val setMatchScheduledAdapter = MatchFinishedAdapter(responselist)
                rv_finished.apply {
                    layoutManager = LinearLayoutManager(view.context)
                    setHasFixedSize(true)
                    setMatchScheduledAdapter.notifyDataSetChanged()
                    adapter = setMatchScheduledAdapter
                }
            }

            override fun onFailure(call: Call<ResponseAllMatch>, t: Throwable) {
                Toast.makeText(view.context, t.localizedMessage, Toast.LENGTH_SHORT).show()

            }

        })

        return view
    }
}