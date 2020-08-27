package OOPS

class Node(data:Char) {
    var element = data
    var next:Node = null
}
class Stack {
  var top:Node = null

  def isEmpty() = top == null

  def push(data:Char): Unit = {
    var newNode = new Node(data)
    if(top == null){
      top = new Node(data)
    }
    else {
      val newNode = new Node(data)
      newNode.next = top
      top = newNode
    }
  }

  def pop():Char = {
    if(isEmpty()) {
      return ' '
    }
    val data = top.element
    top = top.next
    data
 }
  def display(): Unit = {
    var temp = top
    while(temp != null){
      println(temp.element)
      temp = temp.next
    }
  }

}

object BalancedBrackets {
  var stack = new Stack()
  def validExpression(expression:String): Boolean = {
    expression.foreach { (bracket) =>
      if (bracket == '{' || bracket == '(' || bracket == '[') {
        stack.push(bracket)
      }
      else if (bracket == ')') {
        if (stack.isEmpty() || stack.pop() != '(') {
          return false
        }
      }
      else if (bracket == '}') {
        if (stack.isEmpty() || stack.pop() != '{') {
          return false
        }
      }
      else if (bracket == ']') {
        if (stack.isEmpty() || stack.pop() != '[') {
          return false
        }
      }
    }
      if(stack.isEmpty()){
        return true
      }
      false
    }

  def main(args: Array[String]): Unit = {
    println("Enter the expression")
    val expression = scala.io.StdIn.readLine()
    if(validExpression(expression)) {
      println("Expression is Valid")
    }
    else {
      println("Expression is Invalid")
    }
  }
}
