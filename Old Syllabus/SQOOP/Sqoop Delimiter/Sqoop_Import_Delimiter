### Sqoop IMPORT Delimiter Commands

# Enclosed By Command
sqoop import --connect "jdbc:mysql://localhost/training" --username=training --password=training --table countries --target-dir /user/cloudera/sqoop_import/countries_enclosedby --enclosed-by \"

# Fields and Lines Terminated By Command
sqoop import --connect "jdbc:mysql://localhost/training" --username=training --password=training --table countries --target-dir /user/cloudera/sqoop_import/countries_terminatedby --enclosed-by \" --fields-terminated-by \| --lines-terminated-by \:

# Create hive table with sqoop import command WITHOUT ANY DELIMITER
sqoop import --connect "jdbc:mysql://localhost/training" --username=training --password=training --table countries --hive-home /user/hive/warehouse --hive-import --hive-table countries_hive --create-hive-table --outdir java_files

# Append to an exisiting hive table with sqoop import command WITHOUT ANY DELIMITER (ALL VALUES WOULD BE NONE)
sqoop import --connect "jdbc:mysql://localhost/training" --username=training --password=training --table countries --target-dir /user/hive/warehouse/countries_hive --append

# Import by SQOOP for NULL STRINGS & NON STRINGS
sqoop import --connect "jdbc:mysql://localhost/training" --username=training --password=training --table countries_test --hive-home /user/hive/warehouse --hive-import --hive-table countries_hive --create-hive-table --outdir java_files --m 1 --null-string nvl --null-non-string -1
