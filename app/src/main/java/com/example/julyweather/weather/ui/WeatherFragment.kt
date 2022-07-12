package com.example.julyweather.weather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.julyweather.R
import com.example.julyweather.domain.model.WeatherModel
import com.example.julyweather.weather.presenter.WeatherPresenter
import kotlinx.android.synthetic.main.current_weather.output_group
import kotlinx.android.synthetic.main.current_weather.tv_error_message
import kotlinx.android.synthetic.main.layout_input_part.btn_view_weather
import kotlinx.android.synthetic.main.layout_sunrise_sunset.tv_sunrise_time
import kotlinx.android.synthetic.main.layout_sunrise_sunset.tv_sunset_time
import kotlinx.android.synthetic.main.layout_weather_additional_info.tv_humidity_value
import kotlinx.android.synthetic.main.layout_weather_additional_info.tv_pressure_value
import kotlinx.android.synthetic.main.layout_weather_basic_info.tv_city_country
import kotlinx.android.synthetic.main.layout_weather_basic_info.tv_date_time
import kotlinx.android.synthetic.main.layout_weather_basic_info.tv_temperature
import java.text.*
import java.util.*

class WeatherFragment : Fragment() , WeatherInterface{

  var presenter: WeatherPresenter? = null
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.current_weather, container, false)
    //return super.onCreateView(inflater, container, savedInstanceState)
  }

  fun convertLongToTime(time: Long): String {
    val calendar = Calendar.getInstance(Locale.getDefault())
    calendar.timeInMillis = time*1000
    val outputDateFormat = SimpleDateFormat("dd MMM, yyyy - hh:mm a", Locale.getDefault())
    outputDateFormat.timeZone = TimeZone.getDefault() // user's default time zone
    return outputDateFormat.format(calendar.time)

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
   // val weatherDataModel = WeatherModel()
    //displayUI(weatherDataModel)
    presenter = WeatherPresenter()
    presenter?.setView(this)
    presenter?.getWeatherInfo()
  }


  override fun displayUI(weatherDataModel: WeatherModel) {
    output_group.visibility = View.VISIBLE
    tv_error_message.visibility = View.GONE

    tv_date_time?.text = convertLongToTime(weatherDataModel.dt)
    tv_temperature?.text = weatherDataModel.temp?.toString()
    tv_city_country?.text = "Bangalore"
    tv_humidity_value?.text = weatherDataModel.humidity?.toString()
    tv_pressure_value?.text = weatherDataModel.pressure?.toString()
    tv_sunrise_time?.text = convertLongToTime(weatherDataModel.sunrise)
    tv_sunset_time?.text = convertLongToTime(weatherDataModel.sunset)
    btn_view_weather.setOnClickListener {
      presenter?.getWeatherInfo()
    }
  }

  override fun onStop() {
    presenter?.clear()
    super.onStop()
  }

}
