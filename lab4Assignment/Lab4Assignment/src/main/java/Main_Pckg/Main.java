/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Pckg;
import CityPckg.City;
import CityPckg.CityDao;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 *
 * @author 4S
 */
public class Main {
    public static void main(String[] args) {
        CityDao city_data=new CityDao();
        List<City> city_list=city_data.getInfo("D:\\ITI AI Pro Material\\Java and UML\\Projects\\CityandCountry\\cities.csv");
        
       
        System.out.println("The Average of City Population is " +city_list.stream().mapToDouble(a->a.getPopulation()).average().getAsDouble());
        DoubleStream city_list1=city_list.stream().mapToDouble(City::getPopulation);
        double median=city_list.size()%2==0?
                city_list1.skip(city_list.size()/2-1).limit(2).average().getAsDouble():
                city_list1.skip(city_list.size()/2).findFirst().getAsDouble();
        double lowerquartile=city_list.stream().mapToDouble(City::getPopulation).skip(city_list.size()*3/4).findFirst().getAsDouble();
        double upperquartile=city_list.stream().mapToDouble(City::getPopulation).skip(city_list.size()*1/4-1).findFirst().getAsDouble();
        System.out.println("The Median of City Population is :"+median);
        System.out.println("The lower Quartile is :"+lowerquartile);
        System.out.println("The Upper Quartile is: "+upperquartile);
    }
    
}
