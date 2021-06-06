/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CitiesAndCountries;

/**
 *
 * @author 4S
 */
public class City {
    String code;
    String name;
    String continent;
    String surface_area;
    int population;
    boolean capital;
    String loc;

  

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getSurface_area() {
        return surface_area;
    }

    public int getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return capital;
    }

    public String getLoc() {
        return loc;
    }

    public City(String code, String name, String continent, String surface_area, int population, boolean capital, String loc) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surface_area = surface_area;
        this.population = population;
        this.capital = capital;
        this.loc = loc;
    }
    @Override
    public String toString() {
       return "===== code is : "+code+ "  name is: "+name+"population is: "+population;
    }
}
