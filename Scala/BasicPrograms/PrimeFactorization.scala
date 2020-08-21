package BasicCorePrograms

object PrimeFactorization {

  def main(args: Array[String]): Unit = {
    try {
      println("Enter the number for which you want to find factors")
      var number = scala.io.StdIn.readInt()
      if(number <= 0){
        throw new Exception("Please enter a positive number")
      }
      //Dividing the number by 2 and getting all the factors of 2
      while(number % 2 == 0) {
        print(2+" ")
        number = number / 2
      }
      val lastRange = math.sqrt(number).asInstanceOf[Int]
      for( i <- 3 to lastRange){
        while(number % i == 0){
          print(i+" ")
          number = number / i
        }
      }
      if(number > 2){
        print(number)
      }
    }
    catch{
      case e:Exception => println()
    }
  }

}
