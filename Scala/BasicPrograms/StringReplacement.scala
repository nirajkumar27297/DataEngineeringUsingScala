package BasicCorePrograms

object StringReplacement {

  def main(args: Array[String]): Unit = {

    try {
      val template = "Hello <<UserName>> How are you"
      println("Enter the username")
      val userName:String = scala.io.StdIn.readLine()
      if(userName.length < 3){
        throw new Exception("The length should be atleast 3")
      }
      val newTemplate = template.replace("<<UserName>>",userName)
      println(newTemplate)
    }
    catch{
      case ex:Exception => println(ex)
    }
  }

}
