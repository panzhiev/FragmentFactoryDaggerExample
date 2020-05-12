package com.itomych.fragmentfactorydaggerexample.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.itomych.fragmentfactorydaggerexample.R
import com.itomych.fragmentfactorydaggerexample.dependency.Dependency2
import kotlinx.android.synthetic.main.fragment_two.fragment_two_arguments_tv
import kotlinx.android.synthetic.main.fragment_two.fragment_two_name_tv
import javax.inject.Inject

private const val ARG_FRAGMENT_2 = "ARG_FRAGMENT_1"

class Fragment2 @Inject constructor(private val dependency2: Dependency2) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_two, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_two_name_tv.text = dependency2.getDependencyName()
        fragment_two_arguments_tv.text = arguments?.getString(ARG_FRAGMENT_2)
    }

    companion object {
        fun getBundle() = bundleOf(ARG_FRAGMENT_2 to "This is argument for fragment 2")
    }
}