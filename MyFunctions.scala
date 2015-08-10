import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object MyFunctions 
{
     def main(args: Array[String])
     {
       val conf = new SparkConf().setMaster("local").setAppName("Scala word count")
       val sc = new SparkContext(conf)
       
       /******************************************************/
       /* map example                                        */
       /******************************************************/
       val inputNumbers = sc.parallelize(List(10,20,30,40,50))
       val result = inputNumbers.map(x => x * x)
       
       val inputStrings = sc.parallelize(List("a","b","c","d"))
       println("Here comes treble => ")
       
       println(inputStrings.collect().mkString(","))
       println(inputNumbers.collect().mkString(","))
       println(result.collect().mkString("=="))
        
     }

}



