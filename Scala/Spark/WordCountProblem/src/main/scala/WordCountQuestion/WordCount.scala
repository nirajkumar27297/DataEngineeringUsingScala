package WordCountQuestion

import java.text.SimpleDateFormat
import java.util.Calendar

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{explode, split}
import org.apache.spark.{SparkConf, SparkContext}

class WordCount {

  private def generateTime(): String = {
    val today = Calendar.getInstance().getTime()
    val form = new SimpleDateFormat("dd / MM / yy")
    val hr24 = new SimpleDateFormat("HH")
    val formhr24 = hr24.format(today.getTime)
    val min = new SimpleDateFormat("mm")
    val formmin = min.format(today.getTime)
    val sec = new SimpleDateFormat("ss")
    val formsec = sec.format(today.getTime)
    val time  = (form.format(today)+","+formhr24+" : "+formmin+" : "+formsec).toString
    time
  }

  def countWordsRDD(sparkContext: SparkContext,inputFile:String,outputPath:String):Map[String, Int] =  {

    val rawData = sparkContext.textFile(inputFile)
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val outputRDD = wordsKv.reduceByKey(_ + _)
    println(outputRDD.collect().toMap)
    val currentTime = generateTime()
    println(outputPath+currentTime.trim)
    outputRDD.saveAsTextFile(outputPath+currentTime)
    println(outputRDD.collect().toMap)
    outputRDD.collect().toMap
  }

  def countWordsDataFrame(spark:SparkSession,inputFile:String):DataFrame = {
    val textDf = spark.read.text(inputFile)
    val wordsDf = textDf.select(explode(split(textDf("value")," ")).alias("word"))
    val countDf = wordsDf.groupBy("word").count()
    countDf.show(10)
    countDf
  }
}





