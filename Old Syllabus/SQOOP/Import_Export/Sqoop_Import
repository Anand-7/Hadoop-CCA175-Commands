# List MYSQL Databases using SQOOP Command where TRAINING is the database

sqoop list-databases --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" --username retail_dba --password cloudera

# List MYSQL tables in a database using SQOOP Command

sqoop list-tables --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db/retail_db" --username retail_dba --password cloudera

# Using EVAL in SQOOP to run a SQL Query

sqoop eval --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" --username retail_dba --password cloudera --query "SELECT * FROM customers"

### PART 1 OF CERTIFICATION: SQOOP IMPORT

# SQOOP IMPORT Commands

-- Reference: http://www.cloudera.com/content/cloudera/en/developers/home/developer-admin-resources/get-started-with-hadoop-tutorial/exercise-1.html

-- For importing as AVRO file
sqoop import-all-tables -m 12 --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" --username retail_dba --password cloudera --as-avrodatafile --warehouse-dir=/user/cloudera/sqoop_import/training_certi.db

-- For importing as normal text file(DEFAULT)
sqoop import-all-tables -m 12 --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" --username retail_dba --password cloudera --warehouse-dir=/user/cloudera/sqoop_import 

# Import all tables from mysql to hive in DEFAULT database using sqoop in compressed format (A CODEC would be specified)
sqoop import-all-tables \
  --num-mappers 1 \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --hive-import \
  --hive-overwrite \
  --create-hive-table \
  --compress \
  --compression-codec org.apache.hadoop.io.compress.SnappyCodec \
  --outdir java_files

# Import all tables from mysql to hive in DEFAULT database using sqoop in normal format
sqoop import-all-tables \
  --num-mappers 1 \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --hive-import \
  --hive-overwrite \
  --create-hive-table 

# Import all tables from mysql to hive in a SPECIFIC database using sqoop in normal format (VERY NEW COMMAND. NOT WORKING IN UDACITY TRAINING VM)
sqoop import-all-tables \
  --num-mappers 1 \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --hive-import \
  --hive-overwrite \
  --create-hive-table \
  --hive-database sqoop_import

# Command to know the space of a table in hive
dfs -du -s -h <Path for table>

# Basic import: Importing a sql table into a directory using sqoop with number of splits specified as m (DEFAULT is 4)
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/cloudera/customers \
  --m 2

# Import with BOUNDARY QUERY: Importing a sql table into a directory using sqoop with number of splits specified as m (DEFAULT is 4)
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/cloudera/customers \
  --m 2 \
  --boundary-query "SELECT MIN(id),MAX(id) FROM customers WHERE id<151"

# Import with BOUNDARY QUERY: ANOTHER IMPLEMENTATION
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/cloudera/customers \
  --m 2 \
  --boundary-query "SELECT -1, 150 FROM customers limit 1"

# Import with BOUNDARY QUERY: WITH SELECTED COLUMNS
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/cloudera/customers \
  --m 2 \
  --boundary-query "SELECT -1, 150 FROM customers limit 1" \
  --columns id,code

# Using SPLIT BY in case of importing a table with no primary key
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers_pk \
  --target-dir /user/cloudera/customers_pk \
  --split-by id

# QUERY and SPLIT BY 
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --query="select * from customers join customers_small on customers.id=customers_small.S_ID where \$CONDITIONS" \
  --target-dir /user/cloudera/customers_join \
  --split-by id \
  --num-mappers 4


# WHERE in SQOOP IMPORT
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/cloudera/customers \
  --where "id>0 and id<15" 

# WHERE in SQOOP IMPORT with APPEND Command
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/cloudera/customers \
  --append \
  --fields-terminated-by '|' \
  --lines-terminated-by '\n' \
  --split-by id \
  --where "id > 14" \
  --outdir java_files

# HIVE IMPORTS
# Overwrite existing data associated with hive table (hive-OVERWRITE)
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table count_sqoop_demo \
  --fields-terminated-by '|' \
  --lines-terminated-by '\n' \
  --hive-home /user/hive/warehouse \
  --hive-import \
  --hive-overwrite \
  --hive-table sqoop_import.count_sqoop_demo \
  --outdir java_files \
  --m 1

# Create hive table example (IMPORT WITH CREATE)
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --fields-terminated-by '|' \
  --lines-terminated-by '\n' \
  --hive-home /user/hive/warehouse \
  --hive-import \
  --hive-table sqoop_import.customers_test \
  --create-hive-table \
  --outdir java_files

# Getting delta (--where)
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/hive/warehouse/sqoop_import/customers \
  --append \
  --split-by id \
  --where "id > 0" \
  --outdir java_files


# Incremental load
sqoop import \
  --connect "jdbc:mysql://quickstart.cloudera:3306/retail_db" \
  --username retail_dba \
  --password cloudera \
  --table customers \
  --target-dir /user/hive/warehouse/sqoop_import/customers \
  --append \
  --check-column "id" \
  --incremental append \
  --last-value 249 \
  --outdir java_files
