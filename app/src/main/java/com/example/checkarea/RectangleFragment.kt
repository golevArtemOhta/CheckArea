package com.example.checkarea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.checkarea.databinding.FragmentRectangleBinding
import kotlin.properties.Delegates


class RectangleFragment : Fragment() {
    lateinit var binding: FragmentRectangleBinding
    lateinit var rectangleViewModel: RectangleViewModel
    lateinit var textResult: String

    var x by Delegates.notNull<Float>()
    var y by Delegates.notNull<Float>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rectangleViewModel = ViewModelProvider(requireActivity()).get(RectangleViewModel::class.java)
        binding = FragmentRectangleBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            try {
                x = binding.editTextX.text.toString().toFloat()
                y = binding.editTextY.text.toString().toFloat()
                rectangleViewModel.request(x, y)
            }
            catch (e: java.lang.NumberFormatException){
                Toast.makeText(activity,
                    "Please, enter the coordinates!", Toast.LENGTH_LONG).show()
            }
        }

        binding.buttonOpenTwoActivity.setOnClickListener {
            openFragment(ShapeFragment.newInstance(), R.id.fragment)
        }
    }

    override fun onStart() {
        super.onStart()
        rectangleViewModel.textResult.observe(activity as LifecycleOwner, Observer {
            textResult = it
            binding.textResult.text = textResult
        })
    }


    private fun openFragment(fragment: Fragment, idHolder: Int) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(idHolder, fragment)
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RectangleFragment()
    }
}