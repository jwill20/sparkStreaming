/******************************************************/
/* Spark Streaming with Scala                         */
/* Listening on 5678 for data from Java server        */
/******************************************************/
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.storage._
import org.apache.spark.HashPartitioner
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.StreamingContext._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.Duration
import scredis._
import scala.util._
import scala._

object TweetProcessor
{
     val oneSecond   = 1000;
     val fiveSeconds = 5000;
     
     def main(args: Array[String])
     {
        val conf = new SparkConf().setMaster("local[4]").setAppName("Tweet Processing")
        val ssc = new StreamingContext(conf, new Duration(oneSecond))
        
        val lines = ssc.socketTextStream("localhost", 5678)
        
        val negativeSentiment = lines.filter 
            {
               line => line.contains("caused my liver to be damaged")        || 
                       line.contains("caused liver damage")                  ||
                       line.contains("caused my liver damage")               ||
                       line.contains("caused breathing problems")            ||
                       line.contains("have breathing problems")              ||
                       line.contains("have breathing trouble")               ||
                       line.contains("have kidney problems")                 ||
                       line.contains("trouble breathing")                    ||
                       line.contains("breathing problems")                   ||
                       line.contains("heart palpitations")                   ||
                       line.contains("irregular heart beat")                 ||
                       line.contains("I have kidney problems")               ||
                       line.contains("I have kidney damage")                 ||
                       line.contains("caused kidney problems")               ||
                       line.contains("caused kidney damage")                 ||
                       line.contains("caused cancer")                        ||
                       line.contains("have cancer")                          ||
                       line.contains("now has cancer")                       ||
                       line.contains("developed cancer")                     ||
                       line.contains("had a stroke")                         ||
                       line.contains("caused a stroke")                      ||
                       line.contains("caused neurological problems")         ||
                       line.contains("developed neurological problems")      ||
                       line.contains("now I have neurological problems")     ||
                       line.contains("I have really low blood pressure")     ||
                       line.contains("I have really high blood pressure")    ||
                       line.contains("I now have low blood pressure")        ||
                       line.contains("I now have high blood pressure")       ||
                       line.contains("caused my blood pressure")             ||
                       line.contains("made my blood pressure")               ||
                       line.contains("blood pressure went through the roof") ||
                       line.contains("vomit")                                ||
                       line.contains("died from taking")                     ||
                       line.contains("died after taking")
            }
        
        val negativeSentimentNoKidding = negativeSentiment.filter 
            {
               line => ! line.contains("kidding")                     && 
                       ! line.contains("I kid you")                   &&
                       ! line.contains("psych")                       &&
                       ! line.contains("joking")                      &&
                       ! line.contains("jest")                        &&
                       ! line.contains("josh")                        &&
                       ! line.contains("trick")                       &&
                       ! line.contains("spoof")                       &&
                       ! line.contains("dupe")                        &&
                       ! line.contains("hoax")                        &&
                       ! line.contains("tease")                       &&
                       ! line.contains("joke")
            }
        
        val aconiteFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("aconite") 
        }
        val bitterOrangeFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("bitter orange") 
        }
        val chaparralFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("chaparral") 
        }
        val colloidalFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("colloidal") 
        }
        val coltsfootFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("coltsfoot") 
        }
        val comfreyFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("comfrey") 
        }
        val countryMallowFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("country mallow") 
        }
        val germaniumFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("germanium") 
        }
        val kavaFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("kava") 
        }
        val lobeliaFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("lobelia") 
        }
        val yohimbeFilter = negativeSentimentNoKidding.filter 
        {
           line => line.contains("yohimbe") 
        }
        
        aconiteFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("aconite") } 
          }
        }

        bitterOrangeFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("bitter orange") } 
          }
        }

        chaparralFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("chaparral") } 
          }
        }

        colloidalFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("colloidal") } 
          }
        }
        coltsfootFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("coltsfoot") } 
          }
        }

        comfreyFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("comfrey") } 
          }
        }

        countryMallowFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("country mallow") } 
          }
        }
        
        germaniumFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("germanium") } 
          }
        }
        
        kavaFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("kava") } 
          }
        }
        
        lobeliaFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("lobelia") } 
          }
        }

        yohimbeFilter.foreachRDD
        { rdd => rdd.foreachPartition 
          { partition => 
            val client = Client()
            partition.foreach { item => client.incr("yohimbe") } 
          }
        }


        ssc.start()
        
        ssc.awaitTermination()
        
     }
}    
