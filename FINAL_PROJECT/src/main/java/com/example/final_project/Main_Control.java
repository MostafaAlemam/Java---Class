package com.example.final_project;
import Charts.DrawingCharts;
import DataTask.Tasks;
import Main_Model.MainModel;
import DataProcess.DataLoad;
import DataProcess.DataClean;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.Iterator;
@RestController
public class Main_Control {
    @RequestMapping("/")
    public String index() {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1>Wuzzuf Dataset Application:</h1>");
        builder.append("<br><a href=http://localhost:8080/load-csv?>1) Load Dataset</a><br>");
        builder.append("<br><a href=http://localhost:8080/summary>2) Print Summary</a><br> ");
        builder.append("<br><a href=http://localhost:8080/clean-data>3) Clean Data(nulls and duplicates) </a><br>");
        builder.append("<br><a href=http://localhost:8080/print-df>4) Print All Dataset</a><br>");

        builder.append("<br><a href=http://localhost:8080/most-demanded-jobs>5) Most Demanded Companies For Jobs</a><br>");
        builder.append("<br><a href=http://localhost:8080/most-demanded-jobs-pie>6) PieChart For Most Demanded Companies</a><br>");
        builder.append("<br><a href=http://localhost:8080/most-jobs-title>7) Most Popular Job Titles</a><br>");
        builder.append("<br><a href=http://localhost:8080/most-jobs-title-bar>8) BarChart For Most Popular Job Titles</a><br>");
        builder.append("<br><a href=http://localhost:8080/most-pop-areas>9) Most Popular Areas</a><br>");
        builder.append("<br><a href=http://localhost:8080/most-pop-areas-bar>10)BarChart For Most Popular Areas</a><br>");
        builder.append("<br><a href=http://localhost:8080/most-pop-skills>11) Print The Most Popular Skills</a><br>");

        return builder.toString();
    }

    @RequestMapping("/load-csv")
    public String load_csv() {
        Dataset<Row> df = DataLoad.file_load(MainModel.getSession(), "src/main/resources/Wuzzuf_Jobs.csv", true);
        MainModel.setMainDataframe(df);

        return "<h1>Done ,File is Loaded !</h1>";

    }

    @RequestMapping("/print-df")
    public String printDataframe() {
        StringBuilder jobs = new StringBuilder();
        jobs.append("<h1>Dataset</h1>");
        jobs.append("<table style=\"width:100%\">");
        jobs.append(" <tr>")
                .append("<th>#</th>")
                .append("<th>Title</th>")
                .append("<th>Company</th>")
                .append("<th>Location</th>")
                .append("<th>Type</th>")
                .append("<th>Level</th>")
                .append("<th>YearsEXP</th>")
                .append("<th>Country</th>")
                .append("<th>Skills</th>")
                .append("</tr>");
        int i = 1;
        for (Iterator<Row> it = MainModel.getMainDataframe().toLocalIterator(); it.hasNext(); ) {
            Row row = it.next();
            jobs.append(" <tr>")
                    .append("<th>").append(i).append("</th>")
                    .append("<th>").append(row.getString(0)).append("</th>")
                    .append("<th>").append(row.getString(1)).append("</th>")
                    .append("<th>").append(row.getString(2)).append("</th>")
                    .append("<th>").append(row.getString(3)).append("</th>")
                    .append("<th>").append(row.getString(4)).append("</th>")
                    .append("<th>").append(row.getString(5)).append("</th>")
                    .append("<th>").append(row.getString(6)).append("</th>")
                    .append("<th>").append(row.getString(7)).append("</th>")
                    .append("</tr>");
            i++;
        }
        jobs.append("</table>");
        return jobs.toString();
    }

    @RequestMapping("/summary")
    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("<h1> Summary </h1>");
        for (Iterator<String> iter = MainModel.getMainDataframe().summary().toJSON().toLocalIterator(); iter.hasNext(); ) {
            String js = iter.next();
            System.out.println(js);
            summary.append("<br>").append(js).append("<br>");


        }
        return summary.toString();


    }

    @RequestMapping("/clean-data")
    public String clean() {
        StringBuilder builder = new StringBuilder();
        builder.append("<h1> Dropping Null&Duplicate Rows </h1>");
        MainModel.setMainDataframe(DataClean.dropNulls(MainModel.getSession(), MainModel.getMainDataframe()));
        MainModel.setMainDataframe(DataClean.dropDuplicates(MainModel.getSession(), MainModel.getMainDataframe()));
        return builder.toString() + "Done ! Null and Duplicate Rows Are Deleted";

    }

    @RequestMapping("/most-demanded-jobs")
    public String mostDemandedJobs() {
        StringBuilder jobs = new StringBuilder();
        jobs.append("<h1>Most Demanded Jobs</h1>");
        jobs.append("<table style=\"width:100%\">");
        jobs.append(" <tr>")
                .append("<th>#</th>")
                .append("<th>Company</th>")
                .append("<th>Count</th>")
                .append("</tr>");
        int i = 1;
        for (Iterator<Row> it = Tasks.getMostDemandCompany(MainModel.getSession(), MainModel.getMainDataframe()).toLocalIterator(); it.hasNext(); ) {
            Row row = it.next();
            jobs.append(" <tr>")
                    .append("<th>").append(i).append("</th>")
                    .append("<th>").append(row.getString(0)).append("</th>")
                    .append("<th>").append(row.get(1)).append("</th>")
                    .append("</tr>");
            i++;
        }
        jobs.append("</table>");
        return jobs.toString();


    }


    @RequestMapping("/most-demanded-jobs-pie")
    public String draw_piechart() throws IOException {
        return DrawingCharts.sendChartString(DrawingCharts.drawPieChart(Tasks.getMostDemandCompany(MainModel.getSession(), MainModel.getMainDataframe()), "Most Demand Companies For Jobs"));


    }

    @RequestMapping("/most-jobs-title")
    public String mostjobTitle() {
        StringBuilder jobs = new StringBuilder();
        jobs.append("<h1>Most Popular Job Titles</h1>");
        jobs.append("<table style=\"width:100%\">");
        jobs.append(" <tr>")
                .append("<th>#</th>")
                .append("<th>Job Title</th>")
                .append("<th>Count</th>")
                .append("</tr>");
        int i = 1;
        for (Iterator<Row> it = Tasks.getMostPopJob(MainModel.getSession(), MainModel.getMainDataframe()).toLocalIterator(); it.hasNext(); ) {
            Row row = it.next();
            jobs.append(" <tr>")
                    .append("<th>").append(i).append("</th>")
                    .append("<th>").append(row.getString(0)).append("</th>")
                    .append("<th>").append(row.get(1)).append("</th>")
                    .append("</tr>");
            i++;
        }
        jobs.append("</table>");
        return jobs.toString();

    }

    @RequestMapping("/most-jobs-title-bar")
    public String draw_barchart() throws IOException {
        return DrawingCharts.sendChartString(DrawingCharts.drawBarChart(Tasks.getMostPopJob(MainModel.getSession(), MainModel.getMainDataframe()), "Most Popular Job Titles", "Jop Title"));

    }

    @RequestMapping("/most-pop-areas")
    public String mostpopareas() {
        StringBuilder jobs = new StringBuilder();
        jobs.append("<h1>Most Popular Areas</h1>");
        jobs.append("<table style=\"width:100%\">");
        jobs.append(" <tr>")
                .append("<th>#</th>")
                .append("<th>Area</th>")
                .append("<th>Count</th>")
                .append("</tr>");
        int i = 1;
        for (Iterator<Row> it = Tasks.getPopArea(MainModel.getSession(), MainModel.getMainDataframe()).toLocalIterator(); it.hasNext(); ) {
            Row row = it.next();
            jobs.append(" <tr>")
                    .append("<th>").append(i).append("</th>")
                    .append("<th>").append(row.getString(0)).append("</th>")
                    .append("<th>").append(row.get(1)).append("</th>")
                    .append("</tr>");
            i++;
        }
        jobs.append("</table>");
        return jobs.toString();
    }

    @RequestMapping("/most-pop-areas-bar")
    public String draw_barchart_2() throws IOException {
        return DrawingCharts.sendChartString(DrawingCharts.drawBarChart(Tasks.getPopArea(MainModel.getSession(), MainModel.getMainDataframe()), "Most Popular Areas", "Area Name"));

    }

    @RequestMapping("/most-pop-skills")
    public String getSkills() {
        StringBuilder jobs = new StringBuilder();
        jobs.append("<h1>Each Skill Count</h1>");
        jobs.append("<table style=\"width:100%\">");
        jobs.append(" <tr>")
                .append("<th>#</th>")
                .append("<th>Skill</th>")
                .append("<th>Count</th>")
                .append("</tr>");
        int i = 1;
        for (Iterator<Row> it = Tasks.getEachSkillCount(MainModel.getSession(), MainModel.getMainDataframe()).toLocalIterator(); it.hasNext(); ) {
            Row row = it.next();
            jobs.append(" <tr>")
                    .append("<th>").append(i).append("</th>")
                    .append("<th>").append(row.getString(0)).append("</th>")
                    .append("<th>").append(row.get(1)).append("</th>")
                    .append("</tr>");
            i++;
        }
        jobs.append("</table>");
        return jobs.toString();


    }

}