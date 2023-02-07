package com.example.realfutball22.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Adapter.GroupStageHeaderAdapter
import com.example.realfutball22.Api.GroupStage.ApiConfigGroupStage
import com.example.realfutball22.Model.Group.ResponseGroupStage
import com.example.realfutball22.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChampionsFragment : Fragment() {

    lateinit var progressbar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_champions, container, false)

        val rv_groupstanding = view.findViewById<RecyclerView>(R.id.rv_groupstanding)
        progressbar = view.findViewById(R.id.progressbar)

        ApiConfigGroupStage.getService().getGroupStage("your-key-api")
            .enqueue(object : Callback<ResponseGroupStage> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<ResponseGroupStage>,
                    response: Response<ResponseGroupStage>
                ) {
                    if (response.isSuccessful) {
                        progressbar.visibility = View.GONE
                        val responsebody = response.body()
                        val responselist = responsebody?.standings
                        val setDoaAdapter = GroupStageHeaderAdapter(responselist)
                        rv_groupstanding.apply {
                            layoutManager = LinearLayoutManager(view.context)
                            setHasFixedSize(true)
                            setDoaAdapter.notifyDataSetChanged()
                            adapter = setDoaAdapter
                        }
                    } else {
                        progressbar.visibility = View.VISIBLE
                        Toast.makeText(
                            view.context,
                            "Mohon tunggu sedang mengambil data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseGroupStage>, t: Throwable) {
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