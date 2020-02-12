package rational

object rationals {
  val r = new Rational(1, 2)
  val r2 = new Rational(3, 4)

  def addRationals(r1: Rational, r2: Rational): Rational = {
    val res = new Rational(r1.numer*r2.denom + r2.numer*r1.denom, r1.denom*r2.denom)
    res
  }

  def add(r1: Rational, r2: Rational): Rational = {
    val res = new Rational(r1.numer*r2.denom + r2.numer*r1.denom, r1.denom*r2.denom)
    res
  }

  def makeString(r: Rational): String = {
    val str = r.numer + "/" + r.denom
    str
  }

  def main(args: Array[String]): Unit = {
    println("Rational number is: " + r)
    println("Rational numerator is: " + r.numer)
    println("Rational denominator is: " + r.denom)
    println("Rational number for adding is: " + makeString(addRationals(r, r2)))
    println("Rational number for adding in class is: " + add(r, r2))
  }
}
class Rational(x: Int, y: Int) {
  def numer: Int = x
  def denom: Int = y

    // method
//  def add(that: Rational): Int =
//    new Rational(
//      numer*that.denom + that.numer*denom,
//      denom*that.denom).asInstanceOf[Int]

  // method
  // override def toString = ....
}
// def introduces new type Rational as a constructor

// should be in the worksheet sc and call in object, where it points to the class outside
