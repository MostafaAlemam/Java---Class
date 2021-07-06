package DataProcess;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class DataSummary {
    public static void getSummary(Dataset<Row>df){

        df.describe().show();
    }
    public static void showData(Dataset<Row>df){
         df.show();
    }
}
