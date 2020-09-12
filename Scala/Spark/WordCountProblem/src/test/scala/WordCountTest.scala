
import WordCountQuestion.WordCount
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{explode, split}
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.FunSuite

class WordCoutTest extends FunSuite {

  val conf = new SparkConf().setAppName("Word Count").setMaster("local[*]")
  
  test("test_InputSameTextFiles_MatchCountOfWordsUsingRDD_ReturnTrue") {
    val sc = new SparkContext(conf)
    val rawData = sc.textFile("./src/test/resources/lines.txt")
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val output = wordsKv.reduceByKey(_ + _)
    val testMap = output.collect().toMap
    val outputMap = new WordCount().countWordsRDD(sc,"./src/test/resources/lines.txt","file:///home/niraj/IdeaProjects/WordCountProblem/output")
    assert(testMap.equals(outputMap) == true)
    sc.stop()
  }

  test("test_InputDifferentTextFiles_MatchCountOfWords_ReturnFalse") {
    val sc = new SparkContext(conf)
    val rawData = sc.textFile("./src/test/resources/lines.txt")
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val output = wordsKv.reduceByKey(_ + _)
    val testMap = output.collect().toMap
    val outputMap = new WordCount().countWordsRDD(sc,"./src/test/resources/linesWrong.txt","file:///home/niraj/IdeaProjects/WordCountProblem/output")
    assert(testMap.equals(outputMap) == false)
    sc.stop()
  }

  test("test_InputSameTextFiles_MatchCountOfWordsUsingDataFrame_ReturnZero") {
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val textDf = spark.read.text("./src/test/resources/lines.txt")
    val wordsDf = textDf.select(explode(split(textDf("value")," ")).alias("word"))
    val countDfTest = wordsDf.groupBy("word").count()
    val outputCountDF = new WordCount().countWordsDataFrame(spark,"./src/test/resources/lines.txt","file:///home/niraj/IdeaProjects/WordCountProblem/output")
    assert(outputCountDF.except(countDfTest).count() == 0)
  }

  test("test_InputSameTextFiles_MatchCountOfWordsUsingDataFrame_ReturnNonZero") {
    val spark = SparkSession.builder().config(conf).getOrCreate()
    val textDf = spark.read.text("./src/test/resources/lines.txt")
    val wordsDf = textDf.select(explode(split(textDf("value")," ")).alias("word"))
    val countDfTest = wordsDf.groupBy("word").count()
    val outputCountDF = new WordCount().countWordsDataFrame(spark,"./src/test/resources/linesWrong.txt","file:///home/niraj/IdeaProjects/WordCountProblem/output")
    assert(outputCountDF.except(countDfTest).count() != 0)
  }

  test("test_InputSameTextFiles_MatchCountOfWordsUsingDataSet_ReturnZero") {
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val textDataSet = spark.read.text("./src/test/resources/lines.txt").as[String]
    val wordsDataset = textDataSet.flatMap(_.split(" ")).withColumnRenamed("value","words")
    val countDfTest = wordsDataset.groupBy("words").count()
    val outputCountDF = new WordCount().countWordsDataset(spark,"./src/test/resources/lines.txt","file:///home/niraj/IdeaProjects/WordCountProblem/output")
    assert(outputCountDF.except(countDfTest).count() == 0)
  }

  test("test_InputSameTextFiles_MatchCountOfWordsUsingDataSet_ReturnNonZero") {
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    val textDataSet = spark.read.text("./src/test/resources/lines.txt").as[String]
    val wordsDataset = textDataSet.flatMap(_.split(" ")).withColumnRenamed("value","words")
    val countDfTest = wordsDataset.groupBy("words").count()
    val outputCountDF = new WordCount().countWordsDataset(spark,"./src/test/resources/linesWrong.txt","file:///home/niraj/IdeaProjects/WordCountProblem/output")
    assert(outputCountDF.except(countDfTest).count() != 0)
  }

}
