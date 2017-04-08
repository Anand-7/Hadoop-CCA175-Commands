/**
  * Created by varun on 08-04-2017.
  */
import java.sql.DriverManager
import java.sql.Connection

case class ProductRevised(product_id: Int,
                          product_name: String,
                          product_price: Float){
  override def toString(): String = {
    "product_id" + product_id + ";" + "product_name" + product_name
  }
}

object DiscountAmount {
  def main(args: Array[String]): Unit = {
    val driver = "com.mysql.jdbc.driver"
    val url = "jdbc:mysql://quickstart.cloudera:3306/retail_db"
    val username = "root"
    val password = "password"

    Class.forName(driver);
    val connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT product_id, product_name, product_price from products")

    while (resultSet.next()){
      ProductRevised(resultSet.getInt("product_id"),
      resultSet.getString("product_name"),
      resultSet.getFloat("product_price"))
    }
  }
}
