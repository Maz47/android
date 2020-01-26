package com.maz.org.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [NewTodoItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewTodoItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_todo_item, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment.
         *
         * @return A new instance of fragment NewTodoItemFragment.
         */
        @JvmStatic
        fun newInstance() =NewTodoItemFragment()
    }
}
