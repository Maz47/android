package com.maz.org.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.maz.org.myapplication.utilities.ViewAnimator
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [TodoListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TodoListFragment : Fragment() {

//    var isRotated = false
//    var rotation = 0f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        ViewAnimator().init(my_second_fab)
//        ViewAnimator().init(my_third_fab)

//        my_fab.setOnClickListener {v ->
//            if (isRotated) rotation = 0f
//            if (!isRotated) rotation = 135f
//            isRotated = !isRotated
//            ViewAnimator().rotateFab(v, rotation)
//            if (isRotated) {
//                ViewAnimator().showAdditionalFabs(my_second_fab)
//                ViewAnimator().showAdditionalFabs(my_third_fab)
//            }
//            if (!isRotated) {
//                ViewAnimator().hideAdditionalFabs(my_second_fab)
//                ViewAnimator().hideAdditionalFabs(my_third_fab)
//            }
//        }
//
//        my_second_fab.setOnClickListener {
//            Toast.makeText(activity, "Event", Toast.LENGTH_LONG).show()
//            ViewAnimator().rotateFab(my_fab, 0f)
//            ViewAnimator().hideAdditionalFabs(my_second_fab)
//            ViewAnimator().hideAdditionalFabs(my_third_fab)
//            isRotated = false
//        }
//        my_third_fab.setOnClickListener {
//            Toast.makeText(activity, "Song", Toast.LENGTH_LONG).show()
//            ViewAnimator().rotateFab(my_fab, 0f)
//            ViewAnimator().hideAdditionalFabs(my_second_fab)
//            ViewAnimator().hideAdditionalFabs(my_third_fab)
//            isRotated = false
//        }

        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment.
         *
         * @return A new instance of fragment TodoListFragment.
         */
        @JvmStatic
        fun newInstance() = TodoListFragment()
    }
}
