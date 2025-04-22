package com.example.androidpractice.ModuleofTabAndBottomAndDrwable

import Fragment.first
import Fragment.second
import Fragment.third
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TablayoutAdapter(fragmentmanger:FragmentManager,lifecycle: Lifecycle):FragmentStateAdapter(fragmentmanger,lifecycle) {
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
     return when(position){
         0->{first()}
         1->{second()}
         2->{third()}
         else->{Fragment()}
     }
    }
}