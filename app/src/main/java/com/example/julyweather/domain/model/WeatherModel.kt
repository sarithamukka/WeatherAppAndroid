package com.example.julyweather.domain.model


/*"dt": 1646318698,
"sunrise": 1646306882,
"sunset": 1646347929,
"temp": 282.21,
"feels_like": 278.41,
"pressure": 1014,
"humidity": 65,
"dew_point": 275.99,
"uvi": 2.55,
"clouds": 40,
"visibility": 10000,
"wind_speed": 8.75,
"wind_deg": 360,
"wind_gust": 13.89,*/
data class WeatherModel(
  //unix time
  var dt: Long = 1646318698,
  var sunrise: Long = 1646306882,
  var sunset: Long = 1646347929,
  var temp: Double = 36.0,
  var humidity: Long = 65,
  var pressure: Long = 1014
)
