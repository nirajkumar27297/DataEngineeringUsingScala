package WordCountQuestion

import DateTimeGenerator.GenerateDateTime
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.{explode, split}
import org.apache.spark.SparkContext

class WordCount {

  private def getDateTime():String = {
    val generatedateTimeObj = new GenerateDateTime()
    val currentTime = generatedateTimeObj.generateTimeDDMMYYFormat()
    currentTime
  }


  def countWordsRDD(sparkContext: SparkContext,inputFile:String,outputPath:String):Map[String, Int] =  {

    val rawData = sparkContext.textFile(inputFile)
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val outputRDD = wordsKv.reduceByKey(_ + _)
    println(outputRDD.collect().toMap)
    val currentTime = getDateTime()
    outputRDD.saveAsTextFile(outputPath+currentTime)
    outputRDD.collect().toMap
  }

  def countWordsDataFrame(spark:SparkSession,inputFile:String,outputPath:String):DataFrame = {
    val textDf = spark.read.text(inputFile)
    val wordsDf = textDf.select(explode(split(textDf("value")," ")).alias("word"))
    val countDf = wordsDf.groupBy("word").count()
    countDf.show(10)
    val currentDateTime = getDateTime()
    countDf.write.csv(outputPath+currentDateTime)
    countDf
  }
}





