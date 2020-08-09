//Index Number: 18000118

import scala.math.pow
import scala.math.sqrt

object caseClass extends App{
	val p1 = Point(5,7)		//declaring point 1
	val p2 = Point(9,4)		//declaring point 2
	var dx: Int = 20		//declaring dx which is the distance to be moved along the x axis
	var dy: Int = 15		//declaring dy which is the distance to be moved along the y axis

	println("\nPoint 1: " + p1 + "\t\tPoint 2: " + p2)				//printing the two points declared
	println("\n1. Addition of " + p1 + " and " + p2 + " = " + p1.add(p2))		//printing the addition of the two points declared
	println("\n2. Moving " + p1 + " by (" + dx + ", " + dy + ") = " + p1.move(dx, dy))	//printing the point after moving it by the given distances dx and dy
	println("\n3. Distance between " + p1 + " and " + p2 + " = " + p1.distance(p2) + " units")	//printing the distance between two given points
	println("\n4. Inverting x and y coordinates of " + p2 + " = " + p2.invert)		//printning the point after switching its x coordinate with its y coordinate
}

case class Point(x: Int, y: Int){					//case class named "Point" with two integer parameters "x" and "y"
	def add(p: Point) = Point(this.x + p.x, this.y + p.y)		//method to add two given points which has an object of "Point" as its parameter
	def move(dx: Int, dy: Int) = Point(this.x + dx, this.y + dy)	//method to move a point by the given distances "dx" and "dy" giving these distances as its parameters
	//def move1(m: Point) = Point(this.x+m.x, this.y+m.y)		//another way that can be used to move a point passing an object of "Point" as its parameter
	
	def distance(p: Point): Double = {			//method to calculate the distance between two given points
		var d: Double = (sqrt(pow(this.x - p.x, 2) + pow(this.y - p.y, 2)) * 100).round / 100.toDouble	//calculating the distance between two given points
		return d
	}
	
	def invert() = Point(this.y, this.x)			//method to switch x coordinate of a given point with its y coordinate
}