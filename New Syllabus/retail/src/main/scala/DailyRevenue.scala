/**
  * Created by varun on 23-04-2017.
  */
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

object DailyRevenue {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Daily Revenue").setMaster("local")
    val sc = new SparkContext(conf)

    val inputBaseDir = args(0)
    val outputPath = args(1)

    val fs = FileSystem.get(sc.hadoopConfiguration)
    if(!fs.exists(new Path(inputBaseDir))){
      println("Base Dir does not exists")
      return
    }

    val op = new Path(outputPath)
    if(fs.exists(op))
      fs.delete(op, true)

    val orders = sc.textFile(inputBaseDir + "\\orders.txt")
    val ordersFiltered = orders.filter(rec => rec.split(",")(3) == "COMPLETE" || rec.split(",")(3) == "CLOSED")
    val ordersMap = ordersFiltered.map(rec => (rec.split(",")(0).toInt, rec.split(",")(1)))
    val orderItemsMap = sc.textFile(inputBaseDir + "\\order_items.txt").
      map(rec => (rec.split(",")(1).toInt, rec.split(",")(4).toDouble))
    val ordersJoin = ordersMap.join(orderItemsMap)
    val ordersJoinMap = ordersJoin.map(_._2)
    val ordersJoinMapRBK = ordersJoinMap.reduceByKey((agg,value) => agg + value)

    ordersJoinMapRBK.saveAsTextFile(outputPath)
  }
}
