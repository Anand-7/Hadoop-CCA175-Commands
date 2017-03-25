### Sqoop EXPORT Delimiter Commands

# Sqoop EXPORT Command with NULL STRINGS
sqoop export --connect "jdbc:mysql://localhost/training" --username=training --password=training --table countries_test --export-dir /user/hive/warehouse/countries_hive --input-fields-terminated-by '\001' --input-lines-terminated-by '\n' --num-mappers 2 --batch --outdir java_files --input-null-string nvl --input-null-non-string -1