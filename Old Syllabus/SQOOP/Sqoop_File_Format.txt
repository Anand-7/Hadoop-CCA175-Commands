### SQOOP FILE FORMAT COMMANDS

# Importing all tables in AVRO FILE FORMAT to HDFS
sqoop import-all-tables \
  -m 12 \
  --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --as-avrodatafile \
  --target-dir=/user/hive/warehouse/file_format_demo.db

# Importing a single table in TEXT(DEFAULT) FILE FORMAT to HDFS
sqoop import \
  --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --table countries \
  --as-textfile \
  --target-dir=/user/cloudera/countries_file_format_demo

# Importing a single table in SEQUENCE FILE FORMAT to HDFS
sqoop import \
  --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --table countries \
  --as-sequencefile \
  --target-dir=/user/cloudera/countries_file_format_demo

# Importing a single table in AVRO FILE FORMAT to HDFS
sqoop import \
  --connect "jdbc:mysql://localhost/training" \
  --username=training \
  --password=training \
  --table countries \
  --as-avrodatafile \
  --target-dir=/user/cloudera/countries_file_format_demo
