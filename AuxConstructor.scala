/************************************************/
/* Auxiliary constructors                       */
/*                                              */
/* Default is 2 parameters                      */
/* Use "this" for other constructors            */
/* One takes no parms, another takes 1.         */
/************************************************/
class AuxBook (var title :String, var ISBN: Int) 
{
  def this(title: String) 
  {
     this(title, 2222)
     println("this - 2 parms")
  }

  def this() 
  {
    this("Beginning Erlang")
    this.ISBN = 1111
    println("this - 0 parms")
  }
  
  /************************************************/
  /* Method with two parms.                       */
  /************************************************/
  def f2(a: Int, b:Boolean):String = if (b) a.toString else "false"

  /************************************************/
  /* Method that takes any type T and returns a   */
  /* list of those things.                        */  
  /************************************************/
  def list[T](p:T):List[T] = p :: Nil  
  
  // Overriding the toString method
  override def toString = s"$title ISBN- $ISBN"

}


object AuxConstructor 
{
     def main(args: Array[String])
     {
       val ab1 = new AuxBook()
       println(ab1.toString())
       
       val ab2 = new AuxBook("My Life In Kenya")
       println(ab2.toString())
       
       val ab3 = new AuxBook("Hogans Heros", 3333)
       println(ab3.toString())
       
       println("Returned from f2 function call => " + ab3.f2(345, true))
       
       // Using the method that has varying parm types
       val myList = ab3.list("stringThings", "stringThings2")
       println(myList)
       val myList2 = ab3.list(1,2,3,4,5)
       println(myList2(0))
       
     }
}     
       
       
