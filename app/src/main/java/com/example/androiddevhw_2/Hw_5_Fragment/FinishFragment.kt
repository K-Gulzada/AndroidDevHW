package com.example.androiddevhw_2.Hw_5_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androiddevhw_2.databinding.FragmentFinishBinding



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/*
class FinishFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    override fun onStart() {
        super.onStart()
        view?.findViewById<TextView>(R.id.title)?.setText(param1 + param2)

        this.view?.findViewById<Button>(R.id.finish_fragment_btn)?.setOnClickListener {
            (activity as? FragmentActivity)?.showCFragment()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FinishFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}*/

// Navigation

class FinishFragment : Fragment() {

    val args: FinishFragmentArgs by navArgs()
    private lateinit var binding: FragmentFinishBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinishBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.title.text = args.title
        binding.subtitle.text = args.subtitle ?: "B Fragment subtitle"

        binding.finishFragmentBtn.setOnClickListener{
            val action = FinishFragmentDirections.actionFinishFragmentToCFragment("C Fragment", null)
            findNavController().navigate(action)
        }

    }
}
