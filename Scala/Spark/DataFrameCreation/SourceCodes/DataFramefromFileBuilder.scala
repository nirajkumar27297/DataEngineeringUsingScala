package com.bridgelabz.spark

import org.apache.spark.sql.SparkSession

class DataFramefromFileBuilder {
  val spark = SparkSession.builder().master("local[*]").appName("Builder").getOrCreate()


  def createCSVDataFrame(filepath: String) = {
    try {
      val readDataFrame = spark.read.option("header", "true").csv(filepath)
      readDataFrame.describe().show(10)
      readDataFrame.show(10)
    }
    catch {
      case ex:org.apache.spark.sql.AnalysisException => println(ex)
    }
  }
}

