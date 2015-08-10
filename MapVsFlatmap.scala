/******************************************************/
/* map, flatmap, distinct, filter                     */
/*                                                    */
/******************************************************/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object MapVsFlatmap 
{
     def main(args: Array[String])
     {
       val conf = new SparkConf().setMaster("local").setAppName("MapVsFlatmap")
       val sc = new SparkContext(conf)
       
       /******************************************************/
       /* map example - returns an RDD of an array of        */
       /* strings.  Not sure how to print it or iterate.     */
       /******************************************************/
       val wordInput = sc.parallelize(List("welcome home", "you", "glad to see you", "you you you you"))
       val mappedInput = wordInput.map(line => line.split(" "))
       
       /******************************************************/
       /* flatMap example - returns an RDD of strings        */
       /******************************************************/
       val flatMappedInput = wordInput.flatMap(line => line.split(" "))
       
       // Distinct
       val distinctInput = flatMappedInput.distinct()
       
       // Another filter
       val filteredInput = distinctInput.filter { x => x != "welcome" }
       
       println("Here comes distinct input => ")
       distinctInput.foreach{println}
       
       println("Here comes filtered input => ")
       filteredInput.foreach{println}
       
       
       println("Here comes flatMapped input => ")
       
       flatMappedInput.foreach{println}
       flatMappedInput.collect().foreach { println }
       println(flatMappedInput.first())
       
     }

}



