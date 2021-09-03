package com.example.weatherviews.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherviews.adapter.DaysAdapter
import com.example.weatherviews.data.WeatherData
import com.example.weatherviews.data.weatherDataList
import com.example.weatherviews.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = weatherDataList()

        weatherDatas(list.datas[0])
        binding.RView.adapter = DaysAdapter(list.datas,DaysAdapter.weatherclickListener{
            weatherDatas(it)
        })



    }


    private fun weatherDatas(weatherData: WeatherData) {
        binding.fragmentDegree.text = weatherData.degree.toString()
        binding.fragmentState.text = weatherData.NowDay
        binding.fragmentImagView.setImageResource(weatherData.state)


    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}