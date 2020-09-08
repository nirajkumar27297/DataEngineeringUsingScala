import com.bridgelabz.spark.{DataFramefromFileBuilder, FrameComparison}
import org.apache.spark.sql.SparkSession
import org.scalatest.FunSuite


class DataFrameCreationTest extends FunSuite{
  val spark = SparkSession.builder().master("local[*]").appName("Builder").getOrCreate()

  test("test_InputCSVFile_CreatingDataFrames_ReturnEqual") {
    val objCreation = new DataFramefromFileBuilder()
    val filepath = "file:///home/niraj/inputFiles/Churn.csv"
    val firstDataFrame = objCreation.createCSVDataFrame(filepath)
    val secondDataFrame = spark.read.option("header", "true").option("inferSchema","true").csv(filepath)
    val frameCompareObj = new FrameComparison()
    assert(frameCompareObj.frameComparison(firstDataFrame,secondDataFrame) == true)
  }

  test("test_InputCSVFile_CreatingDataFrames_ReturnUnequal") {
    val objCreation = new DataFramefromFileBuilder()
    val filepath = "file:///home/niraj/inputFiles/Churn_New.csv"
    val firstDataFrame = objCreation.createCSVDataFrame("file:///home/niraj/inputFiles/Churn.csv")
    val secondDataFrame = spark.read.option("header", "true").option("inferSchema","true").csv(filepath)
    val frameCompareObj = new FrameComparison()
    assert(frameCompareObj.frameComparison(firstDataFrame,secondDataFrame) == false)
  }

  test("test_InputJsonFile_CreatingDataFrames_ReturnEqual") {
    val objCreation = new DataFramefromFileBuilder()
    val filepath = "file:///home/niraj/inputFiles/iris.json"
    val firstDataFrame = objCreation.createJSONDataFrame(filepath)
    val secondDataFrame = spark.read.json(filepath)
    val frameCompareObj = new FrameComparison()
    assert(frameCompareObj.frameComparison(firstDataFrame,secondDataFrame) == true)
  }

  test("test_InputJsonFile_CreatingDataFrames_ReturnUnequal") {
    val objCreation = new DataFramefromFileBuilder()
    val filepath = "file:///home/niraj/inputFiles/iris.json"
    val firstDataFrame = objCreation.createJSONDataFrame(filepath)
    val secondDataFrame = spark.read.json("file:///home/niraj/inputFiles/iris_New.json")
    val frameCompareObj = new FrameComparison()
    assert(frameCompareObj.frameComparison(firstDataFrame,secondDataFrame) == false)
  }
}
