package OOPS

class Person(name:String,choice:Int) {
  private val nameOfPerson = name
  private val choiceTaken = choice
  private var totalAmount:Double = 0

  private def deposit(amount:Double) {
    totalAmount += amount
    println("Your Total Amount is " + totalAmount)
  }
  private def withdraw(amount:Double): Unit = {
    if(totalAmount - amount < 0) {
      println("Amount greater than Balance")
      return
    }
    totalAmount -= amount
    println("Your Total Amount is "+totalAmount)
  }

  def workChoice(): Unit = {
    choiceTaken match {
      case 1 =>
        println("Enter the amount you want to Deposit")
        val amount = scala.io.StdIn.readDouble()
        deposit(amount)
      case 2 =>
        println("Enter the amount you want to Withdraw")
        val amount = scala.io.StdIn.readDouble()
        withdraw(amount)
      case _ => println("Invalid Choice")
  }
  }
  def getName() = nameOfPerson
  }

class Queue {
  var head:Node = null
  var rear:Node = null

  class Node(name:String,choice:Int) {
    val person = new Person(name:String,choice:Int)
    var next:Node = null
  }

  def enqueue(name:String,choice:Int): Unit = {
    val newNode =new Node(name,choice)
    if(head == null && rear == null){
      head = newNode
    }
    else {
      rear.next = newNode
    }
    rear = newNode
  }

  def dequeue() = {
    if(head == null){
      println("Queue Empty")
    }
    var temp = head
    while(temp != null){
      println(temp.person.getName()+"'s Turn")
      temp.person.workChoice()
      temp = temp.next
      if(temp == null){
        println("No more Customer")
      }
    }
  }

  def display(): Unit ={
    if(head == null){
      println("Queue Empty")
    }
    var temp = head
    while(temp != null){
      println(temp.person.getName())
      temp = temp.next
    }
  }
}

object BankingSystem {
  def main(args: Array[String]): Unit = {
    var ch = 'y'
    var customerQueue = new Queue()
    try {
      while (ch.equals('y')) {
        println("Enter your name")
        var name = scala.io.StdIn.readLine()
        println("\n1.Deposit\n2.Withdraw")
        var choice = scala.io.StdIn.readInt()
        if (choice == 1 || choice == 2) {
          customerQueue.enqueue(name, choice)
        }
        else {
          throw new Exception("Choice should be 1 or 2!!! Try Again")
        }
        println("Want to enter more If yes Press Y or y else anything")
        ch = scala.io.StdIn.readChar()
      }
      println("The Total List of Persons are")
      customerQueue.display()
      customerQueue.dequeue()
    }
    catch {
      case ex:NumberFormatException => println("Choice should be 1 or 2!!! Try Again")
        main(args)
      case ex:Exception => println(ex)
        main(args)
    }
  }
}
