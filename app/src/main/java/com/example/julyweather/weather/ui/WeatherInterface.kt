package com.example.julyweather.weather.ui

import com.example.julyweather.domain.model.WeatherModel

interface WeatherInterface {

  fun displayUI( weatherModel : WeatherModel)
}