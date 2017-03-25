### PART 2 OF CERTIFICATION: SQOOP EXPORT


# Simple EXPORT COMMAND

sqoop export --connect "jdbc:mysql://localhost/training" \
       --username=training \
  	   --password=training \
       --table countries_export \
       --export-dir /user/hive/warehouse/sqoop_import/countries \
       --input-fields-terminated-by '|' \
       --input-lines-terminated-by '\n' \
       --num-mappers 2 \
       --batch \
       --outdir java_files

# EXPORT COMMAND UPDATE ONLY (DEFAULT)
sqoop export --connect "jdbc:mysql://localhost/training" \
       --username=training \
  	   --password=training \
       --table export_demo \
  	   --export-dir /user/cloudera/sqoop_import/export_demo \
  	   --batch \
  	   --outdir java_files \
       --m 1 \
  	   --update-key id \
  	   --update-mode updateonly

# EXPORT COMMAND INSERT ONLY
sqoop export --connect "jdbc:mysql://localhost/training" \
       --username=training \
  	   --password=training \
       --table export_demo \
  	   --export-dir /user/cloudera/sqoop_import/export_demo \
  	   --batch \
  	   --outdir java_files \
       --m 1 \
  	   --update-mode allowinsert
