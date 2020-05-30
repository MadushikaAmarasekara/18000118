//Index Number: 18000118

object Assignment2 extends App{
  println("----- Calculating the take home salary of an employee -----")

  val normal = 150
  val ot = 75
  def salary(normalHours: Int, otHours: Int): Double = (normal * normalHours + ot * otHours) * 0.9

  println("\nTake home salary of an employee per week = Rs. " + salary(40,20) + "\n")

  println("-------------------------------------------------------------------")
  println("----- Movie Theater -----")

  def numAttendees(ticket: Int): Int = 120 + (15 - ticket) / 5 * 20
  def profit(ticket: Int): Double = numAttendees(ticket) * ticket - (500 + 3 * numAttendees(ticket))

  var i: Int = 5
  var price: Int = i
  while(i<=50){
    if(profit(i)>profit(price))
      price=i
    i=i+5
  }

  println("\nThe ticket price at which he can make the highest profit = Rs. " + price + "\nThe profit = Rs. " + profit(price))
}
