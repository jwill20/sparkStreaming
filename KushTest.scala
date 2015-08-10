

/**********************************************************/
/* Case class = Java POJO                                 */
/**********************************************************/
/**********************************************************/
case class Book(var title: String, var numberOfPages: Int)

/**********************************************************/
/* object class = singleton object  - no static classes   */
/**********************************************************/
object MakingThingsHappen 
{
   def greet() 
   {
      println("Making things happen")
   }
}

/**********************************************************/
/* object class = singleton object main                   */
/**********************************************************/
object KushTest 
{
     def main(args: Array[String])
     {
        // Variables and values (var = variable, val = final value)
        var x = 2
        val y = 362
        
        // Book collection 
        val bookList = List("able", "baker", "charlie", "dogman", "easy", "franklin")
        
        for (book <- bookList)
        {
          if (book.contains("easy") || book.contains("dogman"))
          {
            println(book)  
          }  
        }  
        
        // call to POJO
        var myBook = new Book("Big Boy", 324)
        println(myBook.title)
        
        // call to singleton        
        MakingThingsHappen.greet();
                
        
     }
}