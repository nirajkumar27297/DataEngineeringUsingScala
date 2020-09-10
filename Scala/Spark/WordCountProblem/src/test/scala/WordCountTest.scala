import WordCountQuestion.WordCount.countWords
import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.FunSuite

class WordCoutTest extends FunSuite {

  val conf = new SparkConf().setAppName("Word Count").setMaster("local[*]")
  val sc = new SparkContext(conf)

  test("test_InputSameTextFiles_MatchCountOfWords_ReturnTrue") {
    val rawData = sc.textFile("./src/test/resources/lines.txt")
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val output = wordsKv.reduceByKey(_ + _)
    val testMap = output.collect().toMap
    val outputMap = countWords(sc,"./src/test/resources/lines.txt")._2
    assert(testMap.equals(outputMap) == true)
  }

  test("test_InputDifferentTextFiles_MatchCountOfWords_ReturnFalse") {
    val rawData = sc.textFile("./src/test/resources/lines.txt")
    val words = rawData.flatMap(line => line.split(" "))
    val wordsKv = words.map(word => (word, 1))
    val output = wordsKv.reduceByKey(_ + _)
    val testMap = output.collect().toMap
    val outputMap = countWords(sc,"./src/test/resources/linesWrong.txt")._2
    sc.stop()
    assert(testMap.equals(outputMap) == false)
  }
}
