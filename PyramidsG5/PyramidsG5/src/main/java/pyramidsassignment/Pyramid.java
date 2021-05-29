/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramidsassignment;

/**
 *
 * @author 4S
 */
public class Pyramid {
    String pharaoh;
    String modername;
    String site;
    String material;
    String height;
    

    public String getPharaoh() {
        return pharaoh;
    }

    public String getModername() {
        return modername;
    }

    public String getSite() {
        return site;
    }

    public String getMaterial() {
        return material;
    }



    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public void setModername(String modername) {
        this.modername = modername;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
    

    public Pyramid(String pharaoh, String modername, String site, String material,String height) {
        this.pharaoh = pharaoh;
        this.modername = modername;
        this.site = site;
        this.material = material;
        this.height=height;
    }

    @Override
    public String toString() {
        return "===== Pharaoh is : "+pharaoh+ " ,Its Modern Name is: "+modername+" ,Its Site is: "+site+" ,Its material: "+material+",the height is: "+height+"=====";
    }

   
    }

   
        
    
    
    

