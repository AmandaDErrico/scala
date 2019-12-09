
// to allow IntelliJ and Scala to connect to main program, must extends App
object Hello extends App {
  println("Hello World Amanda, testing!")

  // AND
  def and(x:Boolean, y: =>Boolean) = if(x) y else false
  val x = true
  val y = true
  println("Test result: " + and(x, y))

  // OR
  def or(x:Boolean, y: =>Boolean) = if(x) true else y
  val a = false
  val b = false
  println("Test result: " + and(a, b))
}
