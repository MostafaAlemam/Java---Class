package Charts;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DrawingCharts {
    public static PieChart drawPieChart(Dataset<Row> dataset, String title) {
        List<Row> jobs_companyList = dataset.collectAsList();
        List<Integer> jobs = new ArrayList<>();
        List<String> company = new ArrayList<>();

        for (Row i : jobs_companyList) {
            company.add(i.get(0).toString());
            jobs.add(Integer.valueOf(i.get(1).toString()));
        }


        PieChart chart = new PieChartBuilder().width(1920).height(1000).title(title).build();
        for (int c = 0; c < 12; c++) {
            chart.addSeries(company.get(c), jobs.get(c));
        }
        return chart;
    }

    public static String sendChartString(PieChart chart) throws IOException {
        String bytes = null;
        byte[] image_bytes = BitmapEncoder.getBitmapBytes(chart, BitmapEncoder.BitmapFormat.PNG);
        bytes = Base64.getEncoder().encodeToString(image_bytes);
        return "<img src=\"data:image/png;base64," + bytes + "\" />";
    }

    public static CategoryChart drawBarChart(Dataset<Row> dataset, String title, String Colname) {
        List<Row> pop_job_list = dataset.collectAsList();
        List<Integer> count_pop_job = new ArrayList<>();
        List<String> pop_job = new ArrayList<>();

        for (Row i : pop_job_list) {
            pop_job.add(i.get(0).toString());
            count_pop_job.add(Integer.valueOf(i.get(1).toString()));
        }
        CategoryChart barchart = new CategoryChartBuilder().width(1400).height(768).title(title).xAxisTitle(Colname).yAxisTitle("Count").build();
        barchart.getStyler().setHasAnnotations(true);
        barchart.getStyler().setLegendPosition(Styler.LegendPosition.InsideN);
        barchart.addSeries("title counts", pop_job.subList(0, 10), count_pop_job.subList(0, 10));
        barchart.getStyler().setStacked(true);
        return barchart;


    }

    public static String sendChartString(CategoryChart barchart) throws IOException {
        String bytes = null;
        byte[] image_bytes = BitmapEncoder.getBitmapBytes(barchart, BitmapEncoder.BitmapFormat.PNG);
        bytes = Base64.getEncoder().encodeToString(image_bytes);
        return "<img src=\"data:image/png;base64," + bytes + "\" />";


    }
}
