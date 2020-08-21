package BasicCorePrograms
object CountFlipCoin {

  def main(args: Array[String]): Unit = {

    try {
      println("Enter the number of times you want to flip")
      val numberOfFlips = scala.io.StdIn.readInt()
      if(numberOfFlips <= 0){
        throw new Exception("Enter a positive number")
      }
      var totalCount : Float = 0
      var countHead : Float = 0

      while(totalCount < numberOfFlips) {
        var flip = math.random()
        println(flip)
        if (flip > 0.5) {
          countHead += 1
        }
        totalCount += 1
      }

      println(countHead)
      println(totalCount)
      val countHeadPercentage : Float = (countHead / totalCount) * 100
      val countTailPercentage : Float = ((totalCount - countHead) / totalCount) * 100
      println("The Head count percentage is "+countHeadPercentage)
      println("The tail count percentage is "+countTailPercentage)
    }
    catch{
      case ex:Exception => println(ex)
    }
  }

}
