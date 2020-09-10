package WordCountQuestion

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  val conf = new SparkConf().setAppName("Word Count").setMaster("local[*]")
  val hadoopConf = new Configuration()
  val fs = org.apache.hadoop.fs.FileSystem.get(hadoopConf)

  private def dirExists(hdfsDirectory:String):Boolean = {
    fs.exists(new Path(hdfsDirectory)) && fs.isDirectory(new Path(hdfsDirectory))
  }

  def countWords(sc: SparkContext,inputFile:String):(RDD[(String, Int)], Map[String, Int]) =  {
    val rawData = sc.textFile(inputFile)
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val output = wordsKv.reduceByKey(_ + _)
    println(output.collect().toMap)
    (output,output.collect().toMap)
  }

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(conf)
    val outputRDDTuple = countWords(sc,args(0))
    if(dirExists(args(1)) == true) {
      println("Directory Exists!!!")
      fs.delete(new Path(args(1)),true)
    }
    outputRDDTuple._1.saveAsTextFile(args(1))
    sc.stop()
  }
}



