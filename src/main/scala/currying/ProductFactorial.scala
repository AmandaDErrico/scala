package currying

object ProductFactorial {
  // product
  def product(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1
    else f(a) * product(f)(a+1, b)

  // move above where it is called
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1)(a, b)

  //factorial in terns of product
  def fact(n: Int) = product(x => x)(1, n)




  def main(args: Array[String]) {
    println("Product is: " + product(x => x*x)(3, 4))
    // f(3) * product(f)(4, 4)
    // f(3) * (f(4) * product(f)(5, 4))
    // f(3) * (f(4) * 1)
    // 3^2 * 4^2 * 1
    // 9 * 16
    // 144
    println("Factorial is: " + fact(5))
    // product(x => x)(1, 5)
    // f(1) * product(f)(2, 5)
    // f(1) * (f(2) * product(f)(3, 5))
    // f(1) * (f(2) * (f(3) * product(f)(4, 5)))
    // f(1) * (f(2) * (f(3) * (f(4) * product(f)(5, 5))))
    // f(1) * (f(2) * (f(3) * (f(4) * (f(5) * product(f)(6, 5)))))
    // f(1) * (f(2) * (f(3) * (f(4) * (f(5) * 1))))
    // 1 * 2 * 3 * 4 * 5 * 1
    // 120
    println("MapReduce is: " + product2(x => x)(1, 5))
    // combine(f(1), mapReduce(f, combine, zero)(2, 5))
    // combine(f(1), combine(f(2), mapReduce(f, combine, zero)(3, 5)))
    // combine(f(1), combine(f(2), combine(f(3), mapReduce(f, combine, zero)(4, 5))))
    // combine(f(1), combine(f(2), combine(f(3), combine(f(4), mapReduce(f, combine, zero)(5, 5)))))
    // combine(f(1), combine(f(2), combine(f(3), combine(f(4), combine(f(5), mapReduce(f, combine, zero)(6, 5))))))
    // combine(f(1), combine(f(2), combine(f(3), combine(f(4), combine(f(5), 1)))))
    // combine(1, combine(2, combine(3, combine(4, combine(5, 1))))) // shouldnt replace values at this point but doing it for shorter computation
    // combine(1, combine(2, combine(3, combine(4, 5))))
    // combine(1, combine(2, combine(3, 4*5)))
    // combine(1, combine(2, 3*4*5))
    // combine(1, 2*3*4*5)
    // 1*2*3*4*5
    // 120
  }
}
