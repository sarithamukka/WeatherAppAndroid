package com.example.julyweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.julyweather.domain.model.WeatherModel
import com.example.julyweather.weather.ui.WeatherFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val fragTransaction = supportFragmentManager.beginTransaction()
    fragTransaction.replace(R.id.weather_container, WeatherFragment())
    fragTransaction.commit()
    val weatherDataModel = WeatherModel()
   // displayUI(weatherDataModel)
    //getWeatherInfo()
  }


}