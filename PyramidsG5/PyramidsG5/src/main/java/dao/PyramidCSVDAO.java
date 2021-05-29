/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pyramidsassignment.Pyramid;

/**
 *
 * @author 4S
 */
public class PyramidCSVDAO implements PyramidDaoInterface {

    @Override
    public List<Pyramid> getInfoFromCSV(String path) {
        List<Pyramid> pyramidinfo = new ArrayList<>();
        try{
            Scanner sc=new Scanner(new File(path));
            if (sc.hasNextLine()) sc.nextLine();
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String [] parts=line.split(",");
                Pyramid p;
                p = new Pyramid(parts[0],parts[2],parts[4],parts[14],parts[7]);
                pyramidinfo.add(p);
            }
         

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pyramidinfo;

    
    }
}
