
/**********************************************************************/
/* Mon May 4, 2015 - Getting first Spark program to run with Scala    */
/*                                                                    */
/* There are Scala libraries in the spark jar. This caused conflicts. */
/* There also appear to be org.apache.something in Scala but I could  */
/* them.                                                              */
/* Solution was to get rid of the Scala libs provided by Eclipse.     */
/* I had to change the project properties to a back level of Scala    */
/* to get this to work.                                               */
/* A better solution might be to take the Scala classes out of the    */
/* Spark jar.                                                         */
/**********************************************************************/
import scala.math.random
import org.apache.spark._; 

   object Kushlie 
   {
     def main(args: Array[String])
     {
       val conf = new SparkConf().setAppName("Spark Pi")
       conf.setMaster("local")
       
       val sparkCon = new SparkContext(conf)
       
       val slices = if (args.length > 0) args(0).toInt else 2
       
       val n = math.min(100000L * slices, Int.MaxValue).toInt // avoid overflow
       
       val count = sparkCon
          .parallelize(1 until n, slices)
          .map { i =>
             val x = random * 2 - 1
             val y = random * 2 - 1
             if (x*x + y*y < 1) 1 else 0 }
          .reduce(_ + _)
       
       println("Pi is roughly " + 4.0 * count / n)
       sparkCon.stop()  

     }
   }
