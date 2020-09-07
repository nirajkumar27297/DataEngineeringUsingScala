package SparkPackage

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Word Count").setMaster("local")
    val sc = new SparkContext(conf)
    val rawData = sc.textFile("file:///home/niraj/Documents/lines.txt")
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    print(wordsKv)
    val output = wordsKv.reduceByKey(_ + _)
    output.foreach(println(_))
    sc.stop()
  }
}
