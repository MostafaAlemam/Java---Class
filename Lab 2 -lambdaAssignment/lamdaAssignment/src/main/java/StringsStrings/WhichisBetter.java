/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringsStrings;

import java.util.function.BiPredicate;

/**
 *
 * @author 4S
 */
public class WhichisBetter {

    
    public static void main(String[] args) {
        String string1 = "Mohamed";
        String string2 = "Mai";
        String longer=StringUtils.betterString(string1, string2, (s1,s2)->s1.length()>s2.length());
        System.out.println(longer);
        String first=StringUtils.betterString("first", "second",(s1,s2)->true );
        System.out.println(first);
        
    }
        
    }
    
        

       

   
