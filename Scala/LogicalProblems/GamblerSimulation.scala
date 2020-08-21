package LogicalPrograms

import scala.io.StdIn._
import scala.util.control._
import scala.collection.mutable.ListBuffer

class InvalidGoalAmount(msg:String) extends Exception(msg) {}
class CheckGoalAmount{
  @throws(classOf[InvalidGoalAmount])
  def validate(goalAmount:Float,stakeAmount:Float) {
    if( goalAmount < stakeAmount){
      throw new InvalidGoalAmount("Wanna loose Money....Enter goal amount greater than stake amount")
    }
    else{
      println("Good to go")
    }
  }
}
object GamblerSimulation {
  var winningList = new ListBuffer[Float]()
  var losingList = new ListBuffer[Float]()

  def startPlay(stakeAmount: Float, betAmount: Float, goalAmount: Float,numberofDays : Int): Unit = {
    for(day <- 0.until(numberofDays)) {
      var countWin: Float = 0
      var countLose: Float = 0
      var playStakeAmount = stakeAmount
      val inner = new Breaks
      inner.breakable {
        while (true) {
          var random = scala.util.Random
          var play = random.nextInt(2)
          /*
          0 - Lose
          1 - Win
           */
          if (play == 1) {
            println("Hurray!!!You Won")
            playStakeAmount += betAmount
            countWin += 1
          }
          else {
            println("Oops!!! You Lose")
            playStakeAmount -= betAmount
            countLose += 1
          }
          println("Your stake Amount is " + playStakeAmount)
          if (playStakeAmount >= goalAmount) {
            println("Hurray!!! You reached your goal Amount")
            println("You Won by %f".format(playStakeAmount-stakeAmount))
            inner.break
          }
          if (playStakeAmount <=  0.5 * stakeAmount) {
            println("Oops You lost all your money")
            println("You lost by %f".format(stakeAmount - playStakeAmount))
            inner.break
          }
        }
      }
      printCalculatedPercentage(countLose, countWin)

    }
    findLuckiestDay()
    findUnLuckiestDay()

  }

  def printCalculatedPercentage(countLose: Float, countWin: Float) {
    val winPercentage: Float = (countWin / (countWin + countLose)) * 100
    val losePercentage: Float = (countLose / (countWin + countLose)) * 100
    println("The winning percentage is %1.2f".format(winPercentage))
    println("The losing percentage is %1.2f".format(losePercentage))
    winningList.append(winPercentage)
    losingList.append(losePercentage)
  }

  def findLuckiestDay(): Unit = {
    val maxWinPercentages = winningList.max
    println("The LuckiestDay is "+winningList.indexOf(maxWinPercentages))
  }
  def findUnLuckiestDay(): Unit = {
    val maxWinPercentages = losingList.max
    println("The UnluckiestDay is "+losingList.indexOf(maxWinPercentages))
  }

  def main(args: Array[String]): Unit = {
    var choice = 'y'
    var month = 1
    val numberofDays = 30
    while (choice == 'y' || choice == 'Y') {
      try {
        var e = new CheckGoalAmount()
        println("For the month "+month)
        println("Enter the stake Amount")
        var stakeAmount = readFloat()
        println("Enter the Bet Amount")
        val betAmount = readFloat()
        println("Enter the Goal Amount")
        val goalAmount = readFloat()
        e.validate(goalAmount,stakeAmount)
        startPlay(stakeAmount,betAmount,goalAmount,numberofDays)

        println("Do you want to play more if yes press y or Y else anything")
        choice = readChar()
        month += 1
      }
      catch {
        case ex:NumberFormatException => println("Enter decimal numbers only")
        case ex:InvalidGoalAmount =>println(ex)
      }
    }
  }
}


