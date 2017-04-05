class Time(hours: Int, minutes: Int, seconds: Int) {
   require(hours >= 0 && hours <= 24, "Invaid Time")
   require(minutes >= 0 && minutes <= 60, "Invaid Time")
   require(seconds >= 0 && seconds <= 60, "Invaid Time")

   def minutesOfDay: Int = {
     hours*60 + minutes
   }
   println(hours + ":" + minutes + ":" + seconds)
   println(minutesOfDay)
 }