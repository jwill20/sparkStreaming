object Funky 
{
     def main(args: Array[String])
     {
       /************************************************/
       /* Function definition and use                  */
       /************************************************/
       val square = (i: Int) => { i * i}
       println(square(4))
       
       /************************************************/
       /* for loop                                     */
       /************************************************/
       // for loop
       for { i <- 1 to 10} print(i)
       println()
       
       /************************************************/
       /* Function definition and call                 */
       /************************************************/
       def goodTimesFunction() = {"Good times"}
       println(goodTimesFunction)
       
       // Function definition with parameters and call
       def goodTimesFunction2(s:String, t:Int) = {"Good times" + " " + s + " " + t}
       println(goodTimesFunction2("charlie", 32))
       
       if (!true)
       {
         println("told you it was true")
       }
       {
         println("it cannot be true")
       }
       
       /************************************************/
       /* Function coming into method as parameter     */
       /************************************************/
       def operation(functionparam:(Int, Int) => Int) 
       {
          println("here we go...")
          println(functionparam(4,4))
       }
       // The add function gets passed to operation
       val add = (x: Int, y:Int) => { x + y }
       val mul = (x: Int, y:Int) => { x * y }
       operation(add)
       operation(mul)

       /************************************************/
       /* Returning a function from a method           */
       /************************************************/
       def greeting() = (name: String) => {"hello" + " " + name}
    
       // greeting() returns the function above
       val greet= greeting()
       println(greet("Reader"))
       
     }
     
}


















