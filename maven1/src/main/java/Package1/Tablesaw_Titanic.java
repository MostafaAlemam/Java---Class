/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
/**
 *
 * @author 4S
 */
public class Tablesaw_Titanic {
    public static void main(String[] args) {
        try {
            Table titanicData=Table.read().csv("D:\\ITI AI Pro Material\\Java and UML\\Session 4- 6 june\\JUPAI5_Examples\\titanic.csv");
            System.out.println(titanicData.summary().toString());
            Table age=titanicData.retainColumns("age");
            int rowCount=titanicData.rowCount();
            double[] theIndexing = new double[rowCount];
            for(int i = 0;i < rowCount;i++) {
            theIndexing[i]=i;
        }
            DoubleColumn myIndexColumn = DoubleColumn.create ("theIndexes", theIndexing);
            System.out.println(age.insertColumn(1, myIndexColumn));
            
        } catch (IOException e) {
        }
        
    }
}
