package DataProcess;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DataClean {
    public static Dataset<Row> dropNulls(SparkSession sparkSession, Dataset<Row> df){
        return df.na().drop();
    }

    public static Dataset<Row> dropDuplicates(SparkSession sparkSession, Dataset<Row> df){
        return df.dropDuplicates();
    }
}
