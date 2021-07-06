package DataTask;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasks {
    public static Dataset<Row> getMostDemandCompany(SparkSession sparkSession, Dataset<Row> df) {
        df.createOrReplaceTempView("Wuzzuf");
        return sparkSession.sql("select Company,COUNT(Title) as Jobs from Wuzzuf group by Company order by Jobs desc ");
    }

    public static Dataset<Row> getMostPopJob(SparkSession sparkSession, Dataset<Row> df) {
        df.createOrReplaceTempView("Wuzzuf");
        return sparkSession.sql("select Title,COUNT(Title) as Count from Wuzzuf group by Title order by Count desc ");
    }
    public static Dataset<Row> getPopArea(SparkSession sparkSession, Dataset<Row> df) {
        df.createOrReplaceTempView("Wuzzuf");
        return sparkSession.sql("select Location,COUNT(Location) as Count from Wuzzuf group by Location order by Count desc ");
    }
    public static Dataset<Row> getEachSkillCount(SparkSession sparkSession, Dataset<Row> df){
        List<Row> rows = df.select("Skills").collectAsList();
        List<String> allSkills = new ArrayList<>();
        for (Row row : rows) {
            String str = row.toString().replace("[", "").replace("]", "");
            String[] skills = str.split(",");
            allSkills.addAll(Arrays.asList(skills));
        }
        Dataset<Row> skillsDf = sparkSession.createDataset(allSkills, Encoders.STRING()).toDF("Skills");
        skillsDf.createOrReplaceTempView("skillsDf");
        skillsDf = sparkSession.sql("SELECT Skills,count(Skills) as Count_Skills  From skillsDf group by Skills order by Count_Skills desc");
        return skillsDf;
}



}
