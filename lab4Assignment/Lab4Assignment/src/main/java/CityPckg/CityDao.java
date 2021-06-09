/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CityPckg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 4S
 */
public class CityDao implements Dao<City> {

    @Override
    public List<City> getInfo(String path) {
        List <City> info=new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            sc.nextLine();
            while(sc.hasNextLine()){
                String line=sc.nextLine();
                String [] parts=line.split(",");
                String loc       = "".equals(parts[6]) ? "" : parts[6].trim();
                boolean capital   = "TRUE".equals(parts[5]);
                int population    = "".equals(parts[4]) ? 0  : Integer.valueOf(parts[4].trim().replace(".", ""));
                String code         = "".equals(parts[0]) ? "" : parts[0].trim();
                String name         = "".equals(parts[1]) ? "" : parts[1].trim();
                String continent="".equals(parts[2]) ? "" : parts[2].trim();
                String surface_area="".equals(parts[3]) ? "" : parts[3].trim();
                City c=new City( code,name,continent,surface_area,population,capital,loc);
                info.add(c);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CityDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("number of city records = " + info.size());
        return info;
        
    }
    
}
