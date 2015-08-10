/******************************************************/
/* Another word count with countByValue               */
/* Also using for to iterate over results.            */
/******************************************************/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.storage._

object BetterWordCount 
{
     def main(args: Array[String])
     {
        val conf = new SparkConf().setMaster("local").setAppName("Scala word count")
        val sc = new SparkContext(conf)
        
        val input = sc.textFile("dataToSort.txt")
        
        val words = input.flatMap(x => x.split(" ")).countByValue
        
        for (book <- words)
        {
          if (book._1.contains("keyd") || book._1.contains("valuef")) 
          {
            println(book)
          } 
        }    
     }
}     
