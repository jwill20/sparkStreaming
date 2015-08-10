/******************************************************/
/* Spark accumulators in Scala                        */
/*                                                    */
/*                                                    */
/******************************************************/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.storage._
import org.apache.spark.HashPartitioner

object Accumulators
{
     def main(args: Array[String])
     {
        val conf = new SparkConf().setMaster("local").setAppName("Spark accumulators in Scala")
        
        val sc = new SparkContext(conf)
        
        val input = sc.textFile("dataToSortLinesMissing.txt")
        
        // Two accumulators
        val blankLines = sc.accumulator(0)
        val notBlankLines = sc.accumulator(0)
        
        val goodLines = input.flatMap 
        { line => 
          {
            if (line == "")
            {
              blankLines += 1
            }
            {
              // First line had to be first.  I think because that is the line
              // that returns what is needed.
              notBlankLines += 1
              line.split(" ")
            }  
          }
        }

        goodLines.count()
        println("Blank Lines => " + blankLines.value)
        println("Not Blank Lines => " + notBlankLines.value)
        
     }
}     
