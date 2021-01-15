package com.ashish.esoftwarica.ui.addstudent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ashish.esoftwarica.NavigationBarActivity
import com.ashish.esoftwarica.R
import com.ashish.esoftwarica.student

class AddStudentFragment : Fragment() {
    private lateinit var uname: EditText
    private lateinit var uaddress: EditText
    private lateinit var uage: EditText
    private lateinit var imageurl:EditText
    private lateinit var rbmale: RadioButton
    private lateinit var rbfemale: RadioButton
    private lateinit var btnsubmit: Button
    private lateinit var radiogroupp: RadioGroup
    var gender=""


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_addstudent, container, false)
        uname = view.findViewById(R.id.uname)
        uaddress = view.findViewById(R.id.uaddress)
        uage = view.findViewById(R.id.uage)
        imageurl=view.findViewById(R.id.imageurl)
        rbmale = view.findViewById(R.id.rbmale)
        rbfemale = view.findViewById(R.id.rbfemale)
        btnsubmit = view.findViewById(R.id.btnsubmit)
        radiogroupp = view.findViewById(R.id.radiogroupp)

        radiogroupp?.setOnCheckedChangeListener { group, checkedId ->
            gender = if (R.id.rbmale == checkedId) "male" else "female"
        }
        radiogroupp.check(R.id.rbmale)
        btnsubmit.setOnClickListener {
            if (!uname.text.isNullOrEmpty() && !uage.text.isNullOrEmpty()){
                (activity as NavigationBarActivity).lstStudent.add(
                    student(0,uname.text.toString(),uaddress.text.toString(),uage.text.toString(),imageurl.text.toString(),gender)
                )
                Toast.makeText(context,"Student added succesfully",Toast.LENGTH_SHORT).show()
                clearfields()
            }
        }
        return view
    }

    private fun clearfields() {
        uname.text=null
        uaddress.text=null
        uage.text=null
        imageurl.text=null

    }
}