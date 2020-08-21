/*Given the
  temperature t (in Fahrenheit) and the wind speed v (in miles per hour), the
National Weather Service defines the effective temperature (the wind chill) to be:
  w = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * v^0.16
  */
package FunctionalPrograms
import scala.io.StdIn._
object WindChill{

  def main(args: Array[String]): Unit = {
    try {
      println("Enter the temperature")
      val temperature = readFloat()
      println("Enter the velocity")
      val velocity = readFloat()
      if((temperature > 50) || (velocity > 120 || velocity < 3)){
        throw new Exception("Temperature should be less than 50 and Velocity should between 3 and 50")
      }
      val windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * math.pow(velocity,0.16)
      println("The value of Wind Chill is %1.2f"format(windChill))
    }
    catch {
      case ex:Exception => println(ex)
    }
  }

}
