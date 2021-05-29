/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpyramid;

import dao.PyramidCSVDAO;
import java.util.List;
import pyramidsassignment.Pyramid;

/**
 *
 * @author 4S
 */
public class MainPyramid {
    public static void main(String[] args) {
          PyramidCSVDAO pd=new PyramidCSVDAO();
    List<Pyramid> pyramids=   pd.getInfoFromCSV("D:\\ITI AI Pro Material\\Java and UML\\session 2 - 29 may\\pyramids.csv");
    System.out.println(pyramids);
    }
}
