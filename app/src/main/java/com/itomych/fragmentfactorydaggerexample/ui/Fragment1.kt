package com.itomych.fragmentfactorydaggerexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.itomych.fragmentfactorydaggerexample.R
import com.itomych.fragmentfactorydaggerexample.dependency.Dependency1
import kotlinx.android.synthetic.main.activity_main.container
import kotlinx.android.synthetic.main.fragment_one.fragment_one_arguments_tv
import kotlinx.android.synthetic.main.fragment_one.fragment_one_name_tv
import kotlinx.android.synthetic.main.fragment_one.next_btn
import javax.inject.Inject

private const val ARG_FRAGMENT_1 = "ARG_FRAGMENT_1"

class Fragment1 @Inject constructor(private val dependency1: Dependency1) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_one_name_tv.text = dependency1.getDependencyName()
        next_btn.setOnClickListener {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(requireActivity().container.id, Fragment2::class.java, Fragment2.getBundle())
                .addToBackStack(null)
                .commit()
        }
        fragment_one_arguments_tv.text = arguments?.getString(ARG_FRAGMENT_1)
    }

    companion object {
        fun getBundle() = bundleOf(ARG_FRAGMENT_1 to "This is argument for fragment 1")
    }
}