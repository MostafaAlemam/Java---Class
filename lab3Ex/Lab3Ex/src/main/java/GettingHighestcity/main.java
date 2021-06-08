/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingHighestcity;
import GettingHighestcity.City;
import GettingHighestcity.CityDao;
import GettingHighestcity.Countries;
import GettingHighestcity.CountriesDao;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;




/**
 *
 * @author 4S
 */
public class main {
    public static void main(String[] args) {
        CityDao city_data=new CityDao();
        List<City> city_list=city_data.getInfo("D:\\ITI AI Pro Material\\Java and UML\\Projects\\CityandCountry\\cities.csv");
        CountriesDao country_data=new CountriesDao();
        List<Countries> country_list=country_data.getInfo("D:\\ITI AI Pro Material\\Java and UML\\Projects\\CityandCountry\\countries.csv");
        
        List<City> highcity=new ArrayList<>();
        Map<String,List<City>> map;
        map=city_list.stream().collect(Collectors.groupingBy(a->a.getLoc()));
        map.keySet().forEach(t->highcity.add(map.get(t).stream().max((i1,i2)->i1.population-i2.population).get()));
        highcity.forEach(t->System.out.println(t.getLoc()+"\t\t"+t.population+"\t\t"+t.name));
        
        //Getting Highest population Capital
        City highcapital=city_list.stream().filter(a->a.isCapital()).max((i1,i2)->i1.population-i2.population).get();
        System.out.println("The Highest Population Capital is  "+highcapital.name);
        
    }
    
}