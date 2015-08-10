/******************************************************/
/* map to key/value format                            */
/* mapValues to concat with string                    */
/* rdd.keys returns RDD of just the keys              */
/* rdd.values returns RDD of just the values          */
/* rdd.sortByKey                                      */
/* rdd.lookup(x)                                      */
/******************************************************/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object PairMeUp 
{
     def main(args: Array[String])
     {
       val conf = new SparkConf().setMaster("local").setAppName("MapVsFlatmap")
       val sc = new SparkContext(conf)
       
       /******************************************************/
       /* map example - returns a pair RDD (key/value)       */
       /* mapValues and keys. keys doesn't like ()           */
       /* RDD of just values                                 */
       /******************************************************/
       
        val input = sc.textFile("dataToSort.txt")
        val words = input.map(x => (x.split(" ")(0),x))
        val concatWords = words.mapValues(x => x + " you big bimbo")
        val justKeys = concatWords.keys
        val justVals = concatWords.values
        val sorted = concatWords.sortByKey()
        val myLookup = words.lookup("keya") 
        val filtered = concatWords.filter
           {case (key, value) => 
              value.equals("keyj valuej valuej valuej valuej you big bimbo")}
        
        words.take(10).foreach {println}
        concatWords.take(10).foreach {println}
        justKeys.take(10).foreach {println}
        justVals.take(10).foreach {println}
        sorted.take(10).foreach {println}
        println("Here comes filtered")
        filtered.take(10).foreach {println}
        
        println("Here comes lookup")
        myLookup.iterator.foreach { println }

     }
}     
