package recursion

object recur {
  def myFactorial(n: Int): Int = {
    // factorial: (n: Int)Int, res0: Int = 24
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc*n, n-1)
     loop(1, n) // return statement
  }

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a+1, f(a) + acc)
    }
    // everything is applied to function x*x
    loop(a, 0)
  }

  // representing static main class, can also put object factorial extends App
  def main(args: Array[String]) {
    println(recur.myFactorial(4))
    println(sum(x => x * x, 3, 5)) // res1 = 50
  }
}


