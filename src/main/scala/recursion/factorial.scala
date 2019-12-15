package recursion

object factorial {
  def myFactorial(n: Int): Int = {
    // factorial: (n: Int)Int, res0: Int = 24
    def loop(acc: Int, n: Int): Int =
      if (n == 0) acc
      else loop(acc*n, n-1)
     loop(1, n) // return statement
  }
  // representing static main class, can also put object factorial extends App
  def main(args: Array[String]) {
    println(factorial.myFactorial(4))
  }
}


