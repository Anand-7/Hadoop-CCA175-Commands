# HDFS Commands

### Copy from local file system to HDFS
hadoop fs -copyFromLocal /home/varunu28/word_count.txt /user/varunu28/textfiles

### Getting details about files,blocks and location of files in a HDFS
hdfs fsck /user/varunu28/textfiles -files -blocks -locations

### Copy from HDFS to local file system
hadoop fs -copyToLocal /user/varunu28/textfiles .

### Copy from local file system to HDFS with changed blocksize and replication factor
hadoop fs -Ddfs.blocksize=67108864 -Ddfs.repliction=1 -copyFromLocal textfiles /user/varunu28/textfiles