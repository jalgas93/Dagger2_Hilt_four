package com.example.dagger2fourproject.presentation.ui.first

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger2fourproject.R
import com.example.dagger2fourproject.cache.model.RoomModel
import com.example.dagger2fourproject.databinding.FragmentRecipeBinding
import com.example.dagger2fourproject.databinding.ItemRecipeBinding
import com.example.dagger2fourproject.domain.model.Model
import java.util.zip.Inflater


class AdapterRecipe : RecyclerView.Adapter<AdapterRecipe.RecipeViewHolder>() {

    var model: List<Model> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        var binding =
            ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(model[position])
    }

  inner  class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

      var a = binding.ivRecipe
      var b = binding.tvRecipe

        fun bind(item: Model) {

            b.text = item.title
            Log.i("jalgas10",item.title.toString())
           Glide.with(itemView.context).load(item.featured_image).into(binding.ivRecipe)
        }


    }

    override fun getItemCount(): Int = model.size
}

class AdapterRecipeDiff : DiffUtil.ItemCallback<RoomModel>() {


    override fun areItemsTheSame(oldItem: RoomModel, newItem: RoomModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RoomModel, newItem: RoomModel): Boolean {
        return oldItem == newItem
    }
}