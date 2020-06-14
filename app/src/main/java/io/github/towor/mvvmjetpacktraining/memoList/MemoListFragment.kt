package io.github.towor.mvvmjetpacktraining.memoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

import io.github.towor.mvvmjetpacktraining.R
import io.github.towor.mvvmjetpacktraining.data.Memo
import kotlinx.android.synthetic.main.fragment_memo_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class MemoListFragment : Fragment() {

    private val memoViewModel: MemoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_memo_list, container, false)

        val rvMemos = view.rv_memos
        val memoListAdapter = MemoListAdapter(requireContext())
        rvMemos.adapter = memoListAdapter
        rvMemos.layoutManager = LinearLayoutManager(requireContext())

        memoViewModel.allMemos.observe(viewLifecycleOwner, Observer { memos ->
            memoListAdapter.setMemos(memos)
        })

        val fabAdd = view.findViewById<FloatingActionButton>(R.id.fab_add)
        fabAdd.setOnClickListener{
            findNavController().navigate(R.id.action_memoList_to_memoAdd)
        }

        setFragmentResultListener("request_key"){ _ , bundle ->
            val newMemo = bundle.getString("new_memo")
            if(newMemo == null){
                Toast.makeText(requireContext(), "エラー", Toast.LENGTH_SHORT).show()
            }
            else{
                if (newMemo == ""){
                    Toast.makeText(requireContext(), "未入力です", Toast.LENGTH_SHORT).show()
                }
                else{
                    memoViewModel.insert(Memo(id = 0, memo = newMemo))
                }
            }
        }

        return view
    }

}
