package com.example.dagger2fourproject.presentation.ui.first

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2fourproject.R
import com.example.dagger2fourproject.databinding.FragmentRecipeBinding
import com.example.dagger2fourproject.domain.data.DataState
import com.example.dagger2fourproject.domain.data.Status
import com.example.dagger2fourproject.domain.model.Model
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RecipeFragment : Fragment() {

   private var binding: FragmentRecipeBinding? = null
    private val mBinding get() = binding!!
    private val viewModel: RecipeViewModel by viewModels()

    private lateinit var mAdapterRecipe: AdapterRecipe


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipeBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapterRecipe = AdapterRecipe()
        binding?.recyclerView?.adapter = mAdapterRecipe
        viewModel.jalgas("Token 9c8b06d329136da358c2d00e76946b0111ce2c48", 9)
        showViewModel()
    }




    fun showViewModel() {
        val mAdapterRecipe = AdapterRecipe()
        binding?.recyclerView?.adapter = mAdapterRecipe
        viewModel.live.observe(viewLifecycleOwner, Observer { datastate ->
            when (datastate.status) {
                Status.SUCCESS -> {
                    datastate._data.let {
                        mAdapterRecipe.model = it!!
                        Log.i("jalgas5", it.toString())
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


//Log.i("jalgas6",datastate.toString())