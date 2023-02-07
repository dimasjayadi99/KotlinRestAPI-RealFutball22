package com.example.realfutball22.Fragment.Matches

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realfutball22.Adapter.MatchScheduledAdapter
import com.example.realfutball22.Api.Match.ApiConfigMatch
import com.example.realfutball22.Model.Match.ResponseAllMatch
import com.example.realfutball22.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScheduledFragment : Fragment() {
    lateinit var rv_scheduled: RecyclerView
    lateinit var progressbar: ProgressBar
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = LayoutInflater.from(context?.applicationContext)
            .inflate(R.layout.fragment_scheduled, container, false)

        rv_scheduled = view.findViewById(R.id.rc_match_scheduled)
        progressbar = view.findViewById(R.id.progressbar)

        val spinner_filter = view.findViewById<Spinner>(R.id.sp_filter)
        spinner_filter.adapter = ArrayAdapter.createFromResource(
            view.context,
            R.array.item_filter,
            android.R.layout.simple_spinner_item
        )
        spinner_filter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val item = p0?.getItemAtPosition(p2).toString()

                when (item) {
                    "All Competitions" -> getAllCompetitionsResponse()
                    "Primera Division" -> getPDResponse()
                    "Champions League" -> getClResponse()
                }

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        return view
    }

    private fun getAllCompetitionsResponse() {
        ApiConfigMatch.getService()
            .getMatchScheduled(86, "SCHEDULED", "your-key-api")
            .enqueue(object : Callback<ResponseAllMatch> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<ResponseAllMatch>,
                    response: Response<ResponseAllMatch>
                ) {
                    if (response.isSuccessful) {
                        progressbar.visibility = View.GONE
                        val responsebody = response.body()
                        val responselist = responsebody?.matches
                        val setMatchScheduledAdapter = MatchScheduledAdapter(responselist)
                        rv_scheduled.apply {
                            layoutManager = LinearLayoutManager(view?.context)
                            setHasFixedSize(true)
                            setMatchScheduledAdapter.notifyDataSetChanged()
                            adapter = setMatchScheduledAdapter
                        }
                    } else {
                        progressbar.visibility = View.VISIBLE
                        Toast.makeText(
                            view?.context,
                            "Mohon tunggu sedang mengambil data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseAllMatch>, t: Throwable) {
                    Toast.makeText(view?.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun getPDResponse() {
        ApiConfigMatch.getService()
            .getMatchScheduledPDorCL(86, "SCHEDULED", "PD", "your-key-api")
            .enqueue(object : Callback<ResponseAllMatch> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<ResponseAllMatch>,
                    response: Response<ResponseAllMatch>
                ) {
                    if (response.isSuccessful) {
                        progressbar.visibility = View.GONE
                        val responsebody = response.body()
                        val responselist = responsebody?.matches
                        val setMatchScheduledAdapter = MatchScheduledAdapter(responselist)
                        rv_scheduled.apply {
                            layoutManager = LinearLayoutManager(view?.context)
                            setHasFixedSize(true)
                            setMatchScheduledAdapter.notifyDataSetChanged()
                            adapter = setMatchScheduledAdapter
                        }
                    } else {
                        progressbar.visibility = View.VISIBLE
                        Toast.makeText(
                            view?.context,
                            "Mohon tunggu sedang mengambil data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseAllMatch>, t: Throwable) {
                    Toast.makeText(view?.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
    }

    private fun getClResponse() {
        ApiConfigMatch.getService()
            .getMatchScheduledPDorCL(86, "SCHEDULED", "CL", "your-key-api")
            .enqueue(object : Callback<ResponseAllMatch> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(
                    call: Call<ResponseAllMatch>,
                    response: Response<ResponseAllMatch>
                ) {
                    if (response.isSuccessful) {
                        progressbar.visibility = View.GONE
                        val responsebody = response.body()
                        val responselist = responsebody?.matches
                        val setMatchScheduledAdapter = MatchScheduledAdapter(responselist)
                        rv_scheduled.apply {
                            layoutManager = LinearLayoutManager(view?.context)
                            setHasFixedSize(true)
                            setMatchScheduledAdapter.notifyDataSetChanged()
                            adapter = setMatchScheduledAdapter
                        }
                    } else {
                        progressbar.visibility = View.VISIBLE
                        Toast.makeText(
                            view?.context,
                            "Mohon tunggu sedang mengambil data",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<ResponseAllMatch>, t: Throwable) {
                    Toast.makeText(view?.context, t.localizedMessage, Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onStart() {
        super.onStart()
        progressbar.visibility = View.VISIBLE
    }

    override fun onStop() {
        super.onStop()
        progressbar.visibility = View.GONE
    }

}