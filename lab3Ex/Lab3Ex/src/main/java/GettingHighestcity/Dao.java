/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GettingHighestcity;
import java.util.List;
/**
 *
 * @author 4S
 * @param <t>
 */
public interface Dao<t> {
    List<t> getInfo(String path);
}
