package DataProcess;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import tech.tablesaw.api.Table;

import java.io.IOException;

public class DataLoad {
    public static Dataset<Row> file_load(SparkSession sparkSession, String path, boolean header){

        return sparkSession.read()
                .option("header", header)
                .csv(path);
    }
    public static Table file_load_table(String path) throws IOException {
        return Table.read().file(path);
    }

}
