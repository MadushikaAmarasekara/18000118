import scala.math.Pi

object Assignment1 extends App{
  println("----- Converting Celsius into Fahrenheit -----")
  def cToF(c: Int): Double = c * 1.8 + 32
  println("35 degrees Celsius = " + (cToF(35) * 100).round / 100.toDouble + " degrees Fahrenheit\n")

  println("--------------------------------------------------------")
  println("----- Calculating the volume of a sphere -----")
  def sphereVol(r: Int): Double = Pi * r * r * r * 4 / 3
  println("Volume of a sphere of radius 5 = " + (sphereVol(5) * 1000).round / 1000.toDouble + " cubic units\n")

  println("--------------------------------------------------------")
  println("----- Calculating the total wholesale cost -----")
  val coverPrice: Double = 24.95
  def firstFifty(n: Int): Double = coverPrice * 0.6 * n + 3
  def cost(n: Int): Double = if (n>50) firstFifty(n) + (n-50) * 0.75 else firstFifty(n)
  println("Total wholesale cost for 60 copies = Rs. " + (cost(60) * 100).round / 100.toDouble)
}
