/******************************************************/
/* Utility functions                                  */
/* partitions.size                                    */
/* partitionBy() doesn't work on RDDs of Strings      */
/******************************************************/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.storage._
import org.apache.spark.HashPartitioner

object Utilities
{
     def main(args: Array[String])
     {
        val conf = new SparkConf().setMaster("local").setAppName("Scala word count")
        val sc = new SparkContext(conf)
        
        //val input = sc.textFile("dataToSort.txt").partitionBy(new HashPartitioner(100))
        val input = sc.textFile("dataToSort.txt")
        
        val pairs = sc.parallelize(List((1,1), (2,2), (3,3)))
        println(pairs.partitioner)
        
        // Separate executor for each key/partition
        val partitioned = pairs.partitionBy(new HashPartitioner(3))
        println(partitioned.partitioner)
        println(partitioned.partitions.size)
        
        val justKeys = partitioned.keys
        justKeys.foreach { println }
        
        
        // Shows the number of partitions
        println(input.partitions.size)
          
     }
}
