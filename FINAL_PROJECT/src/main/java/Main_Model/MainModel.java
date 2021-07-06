package Main_Model;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class MainModel {
    private static SparkSession mainSession;
    private static Dataset<Row> mainDataframe;

    public static void StartSession(){
        mainSession = SparkSession.builder()
                .appName("Final Project")
                .master("local[3]")
                .getOrCreate();
    }

    public static SparkSession getSession(){
        return mainSession;
    }


    public static void setMainDataframe(Dataset<Row> dataframe){
        mainDataframe = dataframe;
    }

    public static Dataset<Row> getMainDataframe() {
        return mainDataframe;
    }

}
