package com.example.weatherviews.adapter

import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherviews.data.WeatherData

import com.example.weatherviews.databinding.WeatherHourBinding

// Code with ❤️
//┌──────────────────────────┐
//│ Created by Enes SELÇUK │
//│ ──────────────────────── │
//│ enesselcuk@gmail.com      │            
//│ ──────────────────────── │
//│ 2.09.2021                │
//└──────────────────────────┘

class DaysAdapter(private val WeatherList :ArrayList<WeatherData>,private val onClickListener:weatherclickListener) : RecyclerView.Adapter<DaysAdapter.RowHolder>() {

   inner class RowHolder(val binding: WeatherHourBinding):RecyclerView.ViewHolder(binding.root)


    class weatherclickListener(val clickListener: (weather :WeatherData) -> Unit) {
        fun onClick(weather: WeatherData) = clickListener(weather)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(WeatherHourBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return WeatherList.size
    }

    override fun onBindViewHolder(holder: DaysAdapter.RowHolder, position: Int) {
        with(holder) {
            with(WeatherList[position]) {
                binding.fragmentHours.setOnClickListener {
                    onClickListener.onClick(this)
                }
                binding.textViewDegree.text = degree.toString()
                binding.ImageViewWeather.setImageResource(state)
                binding.textviewHour.text = hour
            }

        }


    }
}



