/*
@author: Niraj Kumar
 Given N distinct Coupon Numbers, how many random numbers do you
need to generate distinct coupon number? This program simulates this random
process
 */
package LogicalPrograms
import scala.collection.mutable.ListBuffer
object CouponGenerator {
  def couponGenerator(couponLen:Int,numberOfCoupons:Int ): Unit = {
    println("Generated Coupon Number")
    var countCoupon = 0
    var countRandom = 0
    var couponList = new ListBuffer[String]()
    while (countCoupon < numberOfCoupons) {
      var cpnum: String = ""
      for (i <- 0 until couponLen) {
        var random = scala.util.Random
        var number = random.nextInt(9)
        cpnum += number
        countRandom += 1
      }
      if (!couponList.contains(cpnum)) {
        couponList.append(cpnum)
      }
      countCoupon += 1
    }
    printGeneratedCoupon(couponList)
  }
  def printGeneratedCoupon(couponList:ListBuffer[String]): Unit = {
    println("The generated coupon numbers are")
    couponList.foreach(println)
  }
  def main(args: Array[String]): Unit = {

    try {
      println("Enter the number of coupons you want to generate")
      val numberOfCoupons = scala.io.StdIn.readInt()
      if (numberOfCoupons <= 0) {
        throw new Exception("Enter number of coupons greater than zero")
      }
      println("Enter the coupon length")
      val couponLen = scala.io.StdIn.readInt()
      couponGenerator(couponLen,numberOfCoupons)
      }

    catch {
      case ex:Exception => println(ex)
    }

    }
  }
