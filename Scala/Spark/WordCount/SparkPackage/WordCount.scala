package WordCountQuestion

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("Word Count")
    val sc = new SparkContext(conf)
    val rawData = sc.textFile(args(0))
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val output = wordsKv.groupByKey()
    output.foreach(println(_))
    output.saveAsTextFile(args(1))
    sc.stop()
  }
}