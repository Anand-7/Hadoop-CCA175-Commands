/**
  * Created by varun on 09-04-2017.
  */
import java.sql.DriverManager
import com.typesafe.config._

case class EmployeesCommission(first_name: String,
                               last_name: String,
                               salary: Double,
                               commission_pct: Double) {
  override def toString(): String = {
    s"first_name: " + first_name + ";" +"last_name: " + last_name +
      ";" + "commission_amount: " + getCommissionAmount()
  }

  def getCommissionAmount(): Any = {
    if(commission_pct == null) {
      "Not Eligible"
    } else salary*commission_pct
  }
}

object CommissionAmount {
  def main(args: Array[String]): Unit = {
    val props = ConfigFactory.load()
    val driver = "com.mysql.jdbc.Driver"
    val host = props.getConfig(args(0)).getString("host")
    val port = props.getConfig(args(0)).getString("port")
    val db = props.getConfig(args(0)).getString("db")

    val url = "jdbc:mysql://" + host + ":" + port + "/" + db
    val username = props.getConfig(args(0)).getString("user")
    val password = props.getConfig(args(0)).getString("pw")

    Class.forName(driver);
    val connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT first_name, last_name, " +
        "salary, commission_pct FROM employees")

    while (resultSet.next()) {
      val e = EmployeesCommission(resultSet.getString("first_name"),
      resultSet.getString("last_name"),
      resultSet.getDouble("salary"),
      resultSet.getDouble("commission_pct"))
      println(e)
    }
  }
}
