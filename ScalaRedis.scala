

/******************************************************/
/*                                                    */
/*                                                    */
/******************************************************/
import scredis._
import scala.util._
import scala._

object ScalaRedis
{
     def main(args: Array[String])
     { 
       println("Here we come, walking down the street.")
       
       //val rediss = Redis()
       val client = Client()
       
       //client.set("aconite", 6000)
       //client.set("bitter orange", 2000)
       //client.set("chaparral", 1000)       
       //client.set("colloidal", 8000)       
       //client.set("coltsfoot", 12000)       
       //client.set("comfrey", 3000)         
       //client.set("country mallow", 4000)  
       //client.set("germanium", 1000)       
       //client.set("kava", 10000)            
       //client.set("lobelia", 2000)         
       //client.set("yohimbe", 5000)  

       client.incr("aconite")
       client.incr("bitter orange")
       client.incr("chaparral")       
       client.incr("colloidal")       
       client.incr("coltsfoot")       
       client.incr("comfrey")         
       client.incr("country mallow")  
       client.incr("germanium")       
       client.incr("kava")            
       client.incr("lobelia")         
       client.incr("yohimbe")  

       client.incr("a")
       var value = client.get("a")
       //value =
       
       println("And the answer is..." + value)
       
       
     }

}     
