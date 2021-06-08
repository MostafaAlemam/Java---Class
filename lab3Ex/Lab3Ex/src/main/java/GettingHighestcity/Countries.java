/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingHighestcity;

/**
 *
 * @author 4S
 */
public class Countries {
    String code;
    String name;
    String loc;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLoc() {
        return loc;
    }

    public Countries(String code, String name, String loc) {
        this.code = code;
        this.name = name;
        this.loc = loc;
    }
    @Override
    public String toString() {
       return "===== code is : "+code+ "  name is: "+name+"loc is: "+loc;
    }
}
