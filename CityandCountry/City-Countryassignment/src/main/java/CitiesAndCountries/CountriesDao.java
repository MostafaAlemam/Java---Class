/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CitiesAndCountries;

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
public class CountriesDao implements Dao<Countries> {

    @Override
    public List<Countries> getInfo(String path) {
        List<Countries> counlist = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                Countries c = new Countries(parts[0], parts[1], parts[2]);
                counlist.add(c);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CountriesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("number of countries records = " + counlist.size());

        return counlist;
    }

}
