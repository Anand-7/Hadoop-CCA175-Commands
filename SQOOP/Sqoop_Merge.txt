# SQOOP MERGE COMMANDS

# Merge process begins
hadoop fs -mkdir /user/cloudera/sqoop_merge

# Initial load
sqoop import \
  --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --table countries \
  --as-textfile \
  --target-dir=/user/cloudera/sqoop_merge/countries

# Validate
sqoop eval --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --query "select * from countries" 

hadoop fs -cat /user/cloudera/sqoop_merge/countries/part*

# update
sqoop eval --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --query "update countries set name='Testing Merge' where id = 251"

# Insert
sqoop eval --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --query "insert into countries values (252, 'Bahamas', 'BH')"

sqoop eval --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --query "select * from countries"

# New load
sqoop import \
  --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --table countries \
  --as-textfile \
  --target-dir=/user/cloudera/sqoop_merge/countries_delta \
  --where "id >= 251"

hadoop fs -cat /user/cloudera/sqoop_merge/countries_delta/part*

# Merge
sqoop merge --merge-key id \
  --new-data /user/cloudera/sqoop_merge/countries_delta \
  --onto /user/cloudera/sqoop_merge/countries \
  --target-dir /user/cloudera/sqoop_merge/countries_stage \
  --class-name countries \
  --jar-file /tmp/sqoop-training/compile/be5a43f07ad5441bfb96f4e3650ffd6b/countries.jar

hadoop fs -cat /user/cloudera/sqoop_merge/countries_stage/part*

# Delete old directory
hadoop fs -rm -R /user/cloudera/sqoop_merge/countries

# Move/rename stage directory to original directory
hadoop fs -mv /user/cloudera/sqoop_merge/countries_stage /user/cloudera/sqoop_merge/countries 

# Validate that original directory have merged data
hadoop fs -cat /user/cloudera/sqoop_merge/countries/part*

# Command to count number of lines in a HDFS File
hadoop fs -cat /user/cloudera/sqoop_merge/countries/part* | wc -l

# Merge process ends