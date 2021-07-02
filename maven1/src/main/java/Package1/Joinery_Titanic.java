/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package1;
import java.io.IOException;
import java.util.List;
import joinery.DataFrame;
/**
 *
 * @author 4S
 */
public class Joinery_Titanic {
    public static void main(String[] args){
        try {
             DataFrame<Object> df= DataFrame.readCsv ("D:\\ITI AI Pro Material\\Java and UML\\Session 4- 6 june\\JUPAI5_Examples\\titanic.csv");
               
             DataFrame <Object> describe=df.describe();
             System.out.println(describe);
             System.out.println(df.retain("age").add(df.retain("name")));
             
             System.out.println(df.retain("age","name","sex","fare").join(df.retain("parch")));
           
             
             
             
        

        } catch (IOException e) {
            
        }
            

    }
    
    
    
}
