package com.example.realfutball22.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Adapter.StandingAdapter
import com.example.realfutball22.Api.Standing.ApiConfigStanding
import com.example.realfutball22.Model.ResponseStanding
import com.example.realfutball22.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var progressbar : ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(container?.context).inflate(R.layout.fragment_home, container, false)

        val rv_standing = view.findViewById<RecyclerView>(R.id.rv_standing)
        progressbar = view.findViewById(R.id.progressbar)

        ApiConfigStanding.getService().getStanding("your-key-api").enqueue(object : Callback<ResponseStanding>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ResponseStanding>, response: Response<ResponseStanding>) {
                if (response.isSuccessful) {
                    progressbar.visibility = View.GONE
                    val responsebody = response.body()
                    val responselist = responsebody?.standings?.get(0)?.table
                    val setDoaAdapter = StandingAdapter(responselist)
                    rv_standing.apply {
                        layoutManager = LinearLayoutManager(view.context)
                        setHasFixedSize(true)
                        setDoaAdapter.notifyDataSetChanged()
                        adapter = setDoaAdapter
                    }
                }
                else{
                    progressbar.visibility = View.VISIBLE
                    Toast.makeText(view.context, "Mohon tunggu sedang mengambil data", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponseStanding>, t: Throwable) {
                Toast.makeText(view.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })

        return view
    }

    override fun onStart() {
        super.onStart()
        progressbar.visibility = View.GONE
    }

    override fun onStop() {
        super.onStop()
        progressbar.visibility = View.GONE
    }

}