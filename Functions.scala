//Index Number: 18000118

object Functions extends App{
	//beginning of 1st and 2nd questions in assignment
	val x = new Rational(3, 4)	//first object of class Rational
	val y = new Rational(5,8)	//second object of class Rational
	val z = new Rational(2,7)	//third object of class Rational
	val res = x.sub(y).sub(z)	//result of x-y-z is stored in "res"	
	
	println("\n----- Rational Numbers -----\n")
	println("1. Negative of (" + x.a + ", " + x.b + "): " + x.neg)	//printing negative value of x
	println("2. Subtraction (x-y-z): " + res + "\n\n---------------------------------------------------------------------------------------\n")	//printing result of x-y-z

	println("3. Money transfer between two accounts")	//beginning of 3rd question in assignment
	val m = new Account("1010V", 101, 10000)	//first object of class Account
	val n = new Account("1011V", 110, 10000)	//second object of class Account
	m.transfer(n, 1000)				//transfering money of amount Rs. 1000 from m to n
	println("---------------------------------------------------------------------------------------\n")
	
	println("4. Bank")	//beginning of 4th question
	val p = new Account("123V", 123, 10000)		//an object of class Account
	val q = new Account("234V", 234, 10000)		//an object of class Account
	val r = new Account("345V", 345, -10000)		//an object of class Account
	var bank: List[Account] = List(p, q, r)		//list of accounts in bank

	println("\nList of all accounts: \n\t" + bank + "\n")	//printing the list of all accounts in bank
	val negBalance = bank.filter(x => x.balance<0)	//list of accounts with a negative balance
	val totBalance  = bank.reduce((x, y) => x.add(y))	//calculating sum of all account balances in bank list
	
	val posBalance = bank.filter(x => x.balance>0)	//list of accounts with a positive balance
	val interest1 = negBalance.map(x => x.mul1)	//calculating interests of accounts with a negative balance
	val interest2 = posBalance.map(x => x.mul2)	//calculating interests of accounts with a positive balance
	bank = List.concat(interest1, interest2)		//concatenating two list of accounts after applying interest
	
	println("4.1 List of accounts with a negative balance: \n\t" + negBalance)		
	println("\n4.2 Sum of all account balances: " + (totBalance.balance * 100).round / 100.toDouble)
	println("\n4.3 Final Balances of all accounts after applying interest: \n\t" + bank)
}

class Rational(n1: Int, n2: Int){
	require (n2>0, "Denominator must be greater than 0")		//checking if denominator is greater than 0
	val a = n1/gcd(Math.abs(n1), n2)	//simplifying both numerator and denominator of n1
	val b = n2/gcd(Math.abs(n1), n2)	//simplifying both numerator and denominator of n2
	def this(n1: Int) = this(n1,1)		//denominator becomes 1 when class "Rational" is called with only one parameter

	private def gcd(i: Int, j: Int): Int = if(j==0) i else gcd(j, i%j)	//gcd method to simplify both numerator and denominator
	def neg = new Rational(-this.a, this.b)			//finding negative value of a given rational number
	def sub(r: Rational) = new Rational(this.a * r.b - r.a * this.b, this.b * r.b)	//method to find subtraction of two rational numbers

	override def toString = s"$a/$b"	//override function to print rational numbers in the form x/y
}

class Account(a: String, b: Int, c: Double){
	val nic = a		//substituting parameters to new variables
	val acc = b
	var balance = c

	def withdraw(amt: Double): Boolean ={	//withdraw method which returns a boolena value
		if(this.balance<amt)		//checking if the balance is sufficient to withdraw money
			false
		else{			//balance is sufficient to withdraw money
			this.balance -= amt	//subtracting the withdrawal amount from the balance
			true
		}
	}

	def deposit(amt: Double): Unit ={	//deposit method
		this.balance += amt		//adding deposit amount to the balance
		println("\nTransfer Successful!\n")
			
	}

	def transfer(i: Account, j: Double) = {	//transfer method to transfer money between two accounts
		if(j>0){			//checking if the transfer amount is greater than 0
			if(this.withdraw(j)==true)	//checking if the withdrawal was successful
				i.deposit(j)	//calling deposit method giving the receiving account and the transfer amount
			
			else		//if the withdrawal was not successful
				println("\nInsufficient Balance! Transfer Unsuccessful!\n")
		}
		else	//if the tranfer amount is less than 0
			println("\nAmount should be greater than 0. Transfer Unsuccessful!\n")
	}

	def add(r: Account) = new Account(this.nic, this.acc, this.balance + r.balance)	//add method to add balances of two accounts
	def mul1 = new Account(this.nic, this.acc, this.balance + this.balance * 0.1)	//mul1 method to calculate the interset (10%) of accounts with a negative balance
	def mul2 = new Account(this.nic, this.acc, this.balance + this.balance * 0.05)	//mul2 method to calculate the interset (5%) of accounts with a positive balance

	override def toString = s"($nic, $acc, $balance)"	//override function to print the list in the format (nic, acc, balance)
}