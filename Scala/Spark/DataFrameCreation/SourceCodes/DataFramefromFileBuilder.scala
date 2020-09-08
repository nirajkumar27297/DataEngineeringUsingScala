package com.bridgelabz.spark

import org.apache.spark.sql.{DataFrame, Row, SparkSession}


class DataFramefromFileBuilder {
  val spark = SparkSession.builder().master("local[*]").appName("Builder").getOrCreate()


  def createCSVDataFrame(filepath: String):DataFrame = {
    try {
      val readDataFrame = spark.read.option("header", "true").option("inferSchema","true").csv(filepath)
      readDataFrame.describe().show(10)
      readDataFrame.show(10)
      return readDataFrame
    }
    catch {
      case ex:org.apache.spark.sql.AnalysisException => println(ex)
        spark.emptyDataFrame
    }
  }

  def createJSONDataFrame(filepath: String):DataFrame = {
    try {
      val readDataFrame = spark.read.json(filepath)
      readDataFrame.describe().show()
      readDataFrame.show(10)
      return readDataFrame
    }
    catch {
      case ex:org.apache.spark.sql.AnalysisException => println(ex)
        spark.emptyDataFrame
    }
  }

  def createParaquetDataFrame(filepath: String) = {
    try {
      val readDataFrame = spark.read.parquet(filepath)
      readDataFrame.describe().show()
      readDataFrame.show(10)
    }
    catch {
      case ex:org.apache.spark.sql.AnalysisException => println(ex)
    }
  }
  def createAvroDataFrame(filepath:String):Unit = {
    try {
      val readDataFrame = spark.read.format("avro").load(filepath)
      readDataFrame.describe().show()
      readDataFrame.show(10)
    }
    catch {
      case ex:org.apache.spark.sql.AnalysisException => println(ex)
    }
  }

  def createListDataFrame(inputArray:List[Any]):Unit = {

  }





}

