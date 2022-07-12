package com.example.julyweather.weather.presenter


import com.example.julyweather.data.model.convertToDomainWrapper
import com.example.julyweather.data.repository.WeatherRepository
import com.example.julyweather.domain.model.WeatherModel
import com.example.julyweather.weather.ui.WeatherInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class WeatherPresenter {
  var weatherView: WeatherInterface? = null
  var weatherRepository: WeatherRepository = WeatherRepository()
  val disposables = CompositeDisposable()

  fun setView(weatherView: WeatherInterface) {
    this.weatherView = weatherView
  }

  fun getWeatherInfo() {
    val apiObservable = weatherRepository.getWeatherInfo()
    val dispose = apiObservable.subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread()).subscribe({
        weatherView?.displayUI(it.convertToDomainWrapper())
      }, { weatherView?.displayUI(WeatherModel()) })
    disposables.add(dispose)
    /*apiCall.enqueue(object : Callback<WeatherResponse> {
      override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
        Log.d("Data", "sucess")
        Log.d("Data", response.message())
        response?.body()?.temp?.toString()?.let { Log.d("Data", it) }
        weatherView?.displayUI(WeatherModel())
      }

      override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
        Log.d("Data", "error")
        weatherView?.displayUI(WeatherModel())
      }
    }
    )*/
  }

  fun clear() {
    disposables.dispose()
  }
}