# README.md

- build the env:
`ant clean resolve dist`

- setup hdfs:
```
hadoop fs -mkdir /user/ec2-user/wordcount
hadoop fs -put resource/loremipsum.txt /user/ec2-user/wordcount
```
- run the commands:
```
hadoop jar dist/hw.jar com.jl.test.JavaHelloWorld
hadoop jar dist/hw.jar com.jl.test.ScalaHelloWorld
hadoop jar dist/hw.jar com.jl.test.CascadingWordCount /user/ec2-user/wordcount/loremipsum.txt /user/ec2-user/wordcount/cascading-results
hadoop jar dist/hw.jar com.twitter.scalding.Tool com.jl.test.ScaldingWordCount --hdfs --input /user/ec2-user/wordcount/loremipsum.txt --output /user/ec2-user/wordcount/scalding-results
hadoop jar dist/hw.jar com.twitter.scalding.Tool com.jl.test.Convert --hdfs --input csv%/path/to/input/file.csv --output avro%/path/to/output/folder # note: supported types are csv, tsv, avro
```
