/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CollectionApp;
import CitiesAndCountries.City;
import CitiesAndCountries.CityDao;
import CitiesAndCountries.Countries;
import CitiesAndCountries.CountriesDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 *
 * @author 4S
 */
public class MainClass {
    public static void main(String[] args) {
        CityDao cd=new CityDao();
        List<City> city_list=cd.getInfo("D:\\ITI AI Pro Material\\Java and UML\\cities.csv");
        CountriesDao cond=new CountriesDao();
        List<Countries>country_list=cond.getInfo("D:\\ITI AI Pro Material\\Java and UML\\countries.csv");
        city_list.sort((o1,o2)->o2.getPopulation()-o1.getPopulation());
        Map<String,List<City>> output=new HashMap<>();
        
        for(Countries country:country_list){
            String cc=country.getName();
            List<City> cities=new ArrayList<>();
            for(City city:city_list){
                if(country.getLoc().equals(city.getLoc())){
                    cities.add(city);
                }else{
                    
                }
            }
            
            output.put(cc, cities);
        }
        
        System.out.println(output);
    }
    
            

}
