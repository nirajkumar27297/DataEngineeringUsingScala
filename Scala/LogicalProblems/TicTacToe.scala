/*
@author: Niraj Kumar
Write a Program to play a Cross Game or Tic-Tac-Toe Game. Player 1
is the Computer and the Player 2 is the user. Player 1 take Random Cell that is
the Column and Row.
 */
package LogicalPrograms

import scala.collection.mutable.ListBuffer
import scala.io.StdIn._
import scala.util.Random
import scala.util.control._

object TicTacToe {
  val GAMEDIMENSION = 3
  val MAXRANGE = 9
  val playerPosition = new ListBuffer[Int]()
  val computerPosition = new ListBuffer[Int]()
  val occupiedPosition = new ListBuffer[Int]()
  val COMPUTERSYMBOL = 'O'
  val PLAYERSYMBOL = 'X'
  var board = Array.ofDim[Char](GAMEDIMENSION,GAMEDIMENSION)

  def displayBoard() {
    for (row <- 0 until (GAMEDIMENSION)) {
      for (col <- 0 until (GAMEDIMENSION)) {
        print(board(row)(col)+"|")
      }
      println()
    }
  }

  //Checking computer position
  def checkComputerWinning(position: ListBuffer[Int]): Int = { //Storing all the wining Positions
    val winningPosition = Array(Array(0, 1, 2), Array(3, 4, 5), Array(6, 7, 8), Array(0, 3, 6), Array(1, 4, 7), Array(2, 5, 8), Array(0, 4, 8), Array(2, 4, 6))
    var k = 0
    val unMatchedPosition = new ListBuffer[Int]
    while ( k < winningPosition.length) {
      var countMatch = 0
      unMatchedPosition.clear()
      for (i <- 0 until winningPosition(k).length) {
        // if position array list contains winning positing incrementing by 1
        if (position.contains(winningPosition(k)(i))) {
          countMatch += 1
        }
        else {
          unMatchedPosition.append(winningPosition(k)(i))
        }
      }

      if (countMatch == 2 && unMatchedPosition.length == 1
        && board(unMatchedPosition(0) / GAMEDIMENSION )(unMatchedPosition(0) %  GAMEDIMENSION) == ' ') {
        return unMatchedPosition(0)
      }
      k += 1
    }
    -1
  }
   //if the space is already occupied then return False
  def moveValid(move:Int): Boolean = {
    if(board(move / GAMEDIMENSION)(move % GAMEDIMENSION) == ' ') {
      true
    }
    else{
      false
    }
  }

    //Computer play using random function
  def computerMovePlayRandom(): Int = {
      while(true){
        var random = Random
        var move = Random.nextInt(MAXRANGE)
        if(moveValid(move)) {
          return move
        }
      }
      -1
    }

  def computerMovePlay(): Int = {
    //Winning Position
    var move = checkComputerWinning(computerPosition)
    if (move != -1 && moveValid(move)) {
      board((move / GAMEDIMENSION))(move % GAMEDIMENSION) = COMPUTERSYMBOL
      computerPosition.append(move)
      return move
    }
    //Random Position
    return computerMovePlayRandom
  }

  def equals3(a:Char, b:Char, c:Char) = (a == b && b == c && a != ' ')

    def checkGameResult(board: Array[Array[Char]]):String = {
      var winner: String = "N"

      //horizontal
      for (row <- 0.until(GAMEDIMENSION);if (equals3(board(row)(0), board(row)(1), board(row)(2)))) {
          return board(row)(0).toString
        }
      //Vertical
      for (col <- 0.until(GAMEDIMENSION);if(equals3(board(0)(col), board(1)(col), board(2)(col)))) {
        return board(0)(col).toString
        }
      //Diagonal
      if (equals3(board(0)(0), board(1)(1), board(2)(2))) {
        return board(0)(0).toString
      }
      if (equals3(board(2)(0), board(1)(1), board(0)(2))) {
        return board(2)(0).toString
      }
      if (draw(board) && winner == "N") {
        "tie"
      }
      else {
        winner
      }
    }
    //checking for draw
  def draw(board :Array[Array[Char]]): Boolean ={
    for(row <- 0.until(GAMEDIMENSION); col <- 0.until(GAMEDIMENSION); if board(row)(col) == ' '){
      return false
    }
    true
  }

  def playPlayerMove():Int = {
    var playerMove = 0
    try {
      while (true) {
        println("Player Chance to Play")
        displayBoard()
        println("Enter the position")
        playerMove = readInt()
        playerMove -= 1
        if (playerMove >= MAXRANGE || playerMove < 0) {
          println("Invalid move Try one More time")
        } else if (!moveValid(playerMove)) {
          println("Move Already Occupied")
        }
        else {
          return playerMove
        }
      }
      -1
    }
    catch {
      case ex:NumberFormatException => println("Enter numbers only")
        playPlayerMove()

    }
  }
  def printResult() : Boolean = {
    var checkResult: String = checkGameResult(board)
    if (checkResult != "N") {
      if (checkResult == "X") {
        displayBoard()
        println("Winner is player")
        return true

      }
      else if (checkResult == "O") {
        displayBoard()
        println("Winner is Computer")
        return true
      }
      else if (checkResult == "tie") {
        displayBoard()
        println("Game is draw")
        return true
      }
    }
    false
  }

    def main(args: Array[String]): Unit = {
      //board initialization
      for(row <- 0.until(GAMEDIMENSION);col <-0.until(3)){
          board(row)(col) = ' '
      }
      /*
        1 - Player Turn
        0 -Computer Turn
      */
      var turn = 1
      val outer = new Breaks
      var playerMove = 0
      outer.breakable{
        while(true){
          if(turn == 1){
            playerMove = playPlayerMove()
            board(playerMove / GAMEDIMENSION)(playerMove % GAMEDIMENSION) = PLAYERSYMBOL
            playerPosition.append(playerMove)

            displayBoard()
          }
          else if(turn == 0){
            //Computer move
            println("Computer Chance to play")
            var computerMove = computerMovePlay()
            println("The computer's move is %d".format(computerMove +1))
            board(computerMove / GAMEDIMENSION)(computerMove % GAMEDIMENSION) = COMPUTERSYMBOL
            computerPosition.append(computerMove)
            displayBoard()
          }
          //Checking result
          var isEnd = printResult()
          if(isEnd) {
            outer.break
          }
          if(turn == 1){
            turn = 0
          }
          else{
            turn = 1
          }
        }
      }
    }
  }


