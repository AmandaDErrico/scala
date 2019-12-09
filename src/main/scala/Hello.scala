
// to allow IntelliJ and Scala to connect to main program, must extends App
object Hello extends App {
  println("Hello World!")
  // x CBV and y CBN
  def and(x:Boolean, y: =>Boolean) = if (x) y else false
  val x = true
  val y = true
  println("This is: " + and(x, y))
}

