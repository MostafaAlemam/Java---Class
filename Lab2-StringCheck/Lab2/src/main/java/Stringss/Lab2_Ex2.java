/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stringss;
import java.util.function.Predicate;
/**
 *
 * @author 4S
 */
public class Lab2_Ex2 {
    public static boolean stringCheck(String s){
        for (int i=0;i<s.length();i++){
            if(!Character.isLetter(s.charAt(i))){
                return false;
                
            }
                
            }
        return true;  
        }
    public static void main(String[] args) {
        Predicate<String> p = Lab2_Ex2::stringCheck;
        System.out.println(p.test("EmamEmo"));
        System.out.println(p.test("Hamada123"));
    }
    }

        
    

