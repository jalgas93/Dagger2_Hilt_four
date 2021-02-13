package com.example.dagger2fourproject.presentation.ui.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.dagger2fourproject.R
import com.example.dagger2fourproject.domain.data.DataState
import com.example.dagger2fourproject.domain.data.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeFragment : Fragment() {

    private val viewModel:RecipeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //viewModel.c()
        viewModel.jalgas("Token 9c8b06d329136da358c2d00e76946b0111ce2c48",9)
        showViewModel()

    }

     fun showViewModel() {
        viewModel.live.observe(requireActivity(), Observer {datastate->

            Log.i("jalgas6",datastate.toString())
            when(datastate.status){
                Status.SUCCESS->{
                datastate._data?.let {
                    Log.i("jalgas5",it.toString())
                }
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    datastate.message?.let {
                        //context?.showToast(it)
                    }
                  //  binding.progressBar.gone()
                }

            }


        })
    }


}