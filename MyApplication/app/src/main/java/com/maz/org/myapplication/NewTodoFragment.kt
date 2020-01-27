package com.maz.org.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_new_todo.*

/**
 * A simple [Fragment] subclass.
 * Use the [NewTodoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewTodoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Add new Todo"
        cancel_btn.setOnClickListener {view ->
            view.findNavController().navigate(R.id.action_newTodoFragment_to_todoListFragment2)
        }
        save_btn.setOnClickListener {view ->
            Toast.makeText(context, "Save!", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_newTodoFragment_to_todoListFragment2)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment.
         *
         * @return A new instance of fragment NewTodoFragment.
         */
        @JvmStatic
        fun newInstance() = NewTodoFragment()
    }
}
