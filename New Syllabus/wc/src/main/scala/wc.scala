/**
  * Created by varun on 17-04-2017.
  */
import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object wc {
  def main(args: Array[String]): Unit = {
    val props = ConfigFactory.load()
    val conf = new SparkConf().
      setMaster(props.getConfig("dev").getString("executionMode")).
      setAppName("word count")
    val sc = new SparkContext(conf)

    val randomtext = sc.textFile("file:///D:\\Non Github\\wordcount.txt")
    randomtext.flatMap(rec => rec.split(" ")).
      map(rec => (rec, 1)).
      reduceByKey((agg, value) => agg + value).
      map(_.productIterator.mkString("\t")).
      saveAsTextFile("file:///D:\\Non Github\\wcout")
  }
}
