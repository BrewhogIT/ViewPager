package com.example.viewpager.Fragments.blankFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewpager.App
import com.example.viewpager.Constants
import com.example.viewpager.Fragments.pagerFragment.PagerFragment
import com.example.viewpager.StartActivity
import com.example.viewpager.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    lateinit var binding: FragmentBlankBinding
    val ARG_COUNT_PARAM = "fragmentParam"
    val ARG_IS_LAST = "framentLastParam"
    var isLast = false
    var listNumber= 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentBlankBinding.inflate(inflater,container,false)
        arguments?.let {
            isLast = it.getBoolean(ARG_IS_LAST)
            listNumber = it.getInt(ARG_COUNT_PARAM)
            val buttonText = if (isLast){
                "Finish"
            }else{
                "Next"
            }

            binding.text.text = listNumber.toString()
            binding.button.text = buttonText
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            if (isLast){
                changeActivity()
            }else{
                nextFragment()
            }
        }
    }

    fun changeActivity(){
        App.editor.putBoolean(Constants.PREFERENCES_ACCEPT,false)
        App.editor.apply()

        val intent = Intent(activity,StartActivity::class.java)
        startActivity(intent)
    }

    fun nextFragment(){
        PagerFragment.viewPager.setCurrentItem(listNumber)
    }

    companion object{
        fun newInstance(page: Int, isLast: Boolean) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COUNT_PARAM,page)
                    putBoolean(ARG_IS_LAST, isLast)
                }
            }
    }

}