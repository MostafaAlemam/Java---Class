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
public class StringUtils {
    static String betterString(String s1,String s2,BiPredicate<String,String> p){
        return p.test(s1, s2) ==true ?s1:s2;
    }
    
}
