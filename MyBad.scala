//
// How exceptions work in Scala
//
object MyBad 
{
     def main(args: Array[String])
     {
        var tryResult = 
        try 
        {
           //Integer.parseInt("88")
           Integer.parseInt("dog")
        } 
        catch
        {
            case e:java.io.IOException => // handle IO Exception
            case n:NullPointerException => // handle null pointer
            case g:NumberFormatException => println("my number bad") 
            case _ => println("all good")
        }
        
        println("try result = " + tryResult)
      
       // Match expression
       var sayMyName = "Heisenburg"
       
       var result = 
       sayMyName match 
       {
          case "David"      => 45 // the result is 45 if we match "David"
          case "Elwood"     => 77
          case "Heisenburg" => 100
          case _            => 0
        }
       println("The match result is " + result)
     
     }
}
