package io.github.towor.mvvmjetpacktraining.memoAdd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController

import io.github.towor.mvvmjetpacktraining.R
import kotlinx.android.synthetic.main.fragment_memo_add.view.*

/**
 * A simple [Fragment] subclass.
 */
class MemoAddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_memo_add, container, false)

        val btSave = view.findViewById<Button>(R.id.bt_save)
        btSave.setOnClickListener {
            setFragmentResult("request_key", bundleOf(
                "new_memo" to view.et_new_memo.text.toString()
            ))
            findNavController().navigate(R.id.action_memoAdd_to_memoList)
        }

        return view
    }

}
