import scala.annotation.tailrec
//Index Number: 18000118

object Assignment3 extends App{
  println("----- Determining if the given number is a prime number -----")

  @tailrec
  def prime(num: Int, i: Int): Boolean = {
    if(num<=1)
      false

    else if(i==1)
      true

    else{
      if(num%i==0)
        false
      else
        prime(num,i-1)
    }
  }

  printf("Enter a number: ")
  val a = scala.io.StdIn.readInt()
  println(prime(a,a/2))


  println("\n----------------------------------------------------------------------------")
  println("----- Printing all prime numbers less than a given number -----")

  @tailrec
  def primeList(num: Int): Int = {
    if(num==2)
      return num

    @tailrec
    def prime(num: Int, i: Int): Boolean = {
      if(num<=1)
        false

      else if(i==1)
        true

      else{
        if(num%i==0)
          false
        else
          prime(num,i-1)
      }
    }
    if(prime(num, num/2))
      printf(s"$num ")
    primeList(num-1)
  }

  printf("Enter a number: ")
  val b = scala.io.StdIn.readInt()
  printf(s"Prime numbers less than $b: ")
  println(primeList(b))


  println("\n----------------------------------------------------------------------------")
  println("----- Calculating sum of 1 to n numbers -----")

  def sum(n: Int): Int = {
    if(n==1)
      n
    else
      n+sum(n-1)
  }

  printf("Enter a number: ")
  val c = scala.io.StdIn.readInt()
  println(s"Sum of numbers from 1 to $c = " + sum(c))


  println("\n----------------------------------------------------------------------------")
  println("----- Determining if the given number is odd or even -----")

  @tailrec
  def oddEven(n: Int): Boolean = {
    if(n==0)
      true
    else if(n==1)
      false
    else
      oddEven(n-2)
  }

  printf("Enter a number: ")
  val d = scala.io.StdIn.readInt()

  if(oddEven(d))
    println(s"$d is even.")
  else
    println(s"$d is odd.")


  println("\n----------------------------------------------------------------------------")
  println("----- Calculating sum of all even numbers less than the given number -----")

  var sum: Int = 0

  @tailrec
  def sumEven(n: Int): Int = {
    if(n==2)
      return n + sum

    @tailrec
    def oddEven(n: Int): Boolean = {
      if(n==0)
        true
      else if(n==1)
        false
      else
        oddEven(n-2)
    }
    if(oddEven(n))
      sum = sum + n
    sumEven(n-1)
  }

  printf("Enter a number: ")
  val e = scala.io.StdIn.readInt()

  if(oddEven(e))
    println(s"Sum of all even numbers less than $e = " + sumEven(e-1))
  else
    println(s"Sum of all even numbers less than $e = " + sumEven(e))


  println("\n----------------------------------------------------------------------------")
  println("----- Printing first Fibonacci numbers for a given number -----")

  def fib(n: Int): Int = {
    if(n<=1)
      return n
    fib(n-1) + fib(n-2)
  }

  printf("Enter a number: ")
  val f = scala.io.StdIn.readInt()

  printf(s"First $f Fibonacci numbers: ")
  for(i <- 0 until f)
    printf(fib(i) + " ")
  printf("\n")
}
