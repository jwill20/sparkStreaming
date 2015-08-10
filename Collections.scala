object Collections 
{
     def main(args: Array[String])
     {

         var books = Array("Beginning Scala", "Beginning Java", "Beginning Groovy")
         println(books(2))
         
         val booksList: List[String] = List("Beginning Scala", "Beginning Groovy")
         println(booksList.head)
         println(booksList.tail)
         
         println("for loop")
         for (book<-booksList)
          println(book)
         
         // Tuples
         val myTuple = (1, false, "Scala")
         println(myTuple._2)
         
         val myTuple2 = "firstVal" -> "secondVal" -> "thirdVal" -> "fourthVal"
         println(myTuple2._2)
         
         // Filtering
         println("filtering")
         for(book<-booksList
            if book.contains("Scala")) 
            println(book)
            
         println("upper case")   
         for 
         {book <- books
            bookVal = book.toUpperCase()
         } 
         {  
           println(bookVal) 
           println("garbage")
         } 
             
         
     }
}
