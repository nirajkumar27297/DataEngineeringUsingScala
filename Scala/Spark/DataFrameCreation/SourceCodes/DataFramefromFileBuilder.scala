package com.bridgelabz.spark

import org.apache.spark.sql.{DataFrame, Row, SparkSession}


class DataFramefromFileBuilder {
  val spark = SparkSession.builder().master("local[*]").appName("Builder").getOrCreate()

  def showDataFrame(readDataFrame: DataFrame):Unit  = {
    readDataFrame.describe()
    readDataFrame.show(10)
  }

  def createDataFrame(choice:Int, filepath:String):DataFrame = {
    try {
        val readDataFrame = choice match {
        case 1 => spark.read.option("header", "true").option("inferSchema","true").csv(filepath)
        case 2 => spark.read.json(filepath)
        case 3 => spark.read.parquet(filepath)
        case 4 => spark.read.format("avro").load(filepath)
      }
      showDataFrame(readDataFrame)
      readDataFrame
    }
    catch {
      case ex:org.apache.spark.sql.AnalysisException => println(ex)
        spark.emptyDataFrame
      case ex:org.apache.avro.AvroRuntimeException => println(ex)
        spark.emptyDataFrame
      case ex:Exception => println(ex)
        spark.emptyDataFrame
    }
  }


  def createCSVDataFrame(filepath: String):DataFrame = {
    createDataFrame(1,filepath)
  }

  def createJSONDataFrame(filepath: String):DataFrame = {
    createDataFrame(2,filepath)
  }

  def createParaquetDataFrame(filepath: String):DataFrame = {
    createDataFrame(3,filepath)
  }
  def createAvroDataFrame(filepath:String):DataFrame = {
    createDataFrame(4,filepath)
  }

  def createListDataFrame(inputArray:List[Any]):Unit = {

  }





}

