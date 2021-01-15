package com.ashish.esoftwarica.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ashish.esoftwarica.NavigationBarActivity
import com.ashish.esoftwarica.R
import com.ashish.esoftwarica.studentadapter

class HomeFragment : Fragment() {

    private lateinit var studentlayout : RecyclerView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        studentlayout= view.findViewById(R.id.recyclerview)
        studentlayout.layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        studentlayout.adapter= studentadapter((activity as NavigationBarActivity).lstStudent,requireContext())

        return view
    }
}