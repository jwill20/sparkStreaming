import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.storage._

object ScalaWordCount 
{
     def main(args: Array[String])
     {
        val conf = new SparkConf().setMaster("local").setAppName("Scala word count")
        val sc = new SparkContext(conf)
        
        val input = sc.textFile("SOFTwitter.json")
        
        val words = input.flatMap(line => line.split(" "))
        
        val counts = words.map(word => (word,1)).reduceByKey{case (x,y) => x + y}
        //counts.saveAsTextFile("wordCountOutput")
        
        /**************************************************************/
        /* take() and foreach() example                               */
        /**************************************************************/
        counts.take(10).foreach(println)
        
        /**************************************************************/
        /* persist() allow specifying the storage level               */
        /* cache() takes the default                                  */
        /**************************************************************/
        val memCounts = counts.persist(StorageLevel.MEMORY_ONLY_SER)
        println("After persist() call * * * " + memCounts.count())
        println(memCounts.toDebugString)
        
        /**************************************************************/
        /* Filter example using braces for function. nothing vbl not  */
        /* used.                                                      */
        /**************************************************************/
        val filterCounts = input.filter
          {
            val nothing = 0
            line => line.contains("Scala")
          }
        println("Filtered count * * * " + filterCounts.count())
        
        
        /**************************************************************/
        /* Create a file using parallelize()                          */
        /**************************************************************/
        val listLines = sc.parallelize(List("kushlie", "lowly", "corduroy"))
        println("* * * " + listLines.count())
        println("here some the lines => ")
        listLines.collect().foreach(println)
        
     }   
  
}
