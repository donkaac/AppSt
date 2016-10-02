package Entities;
// Generated Oct 2, 2016 12:23:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country  implements java.io.Serializable {


     private Integer idCountry;
     private String countryName;
     private boolean state;
     private Set<Province> provinces = new HashSet<Province>(0);

    public Country() {
    }

	
    public Country(boolean state) {
        this.state = state;
    }
    public Country(String countryName, boolean state, Set<Province> provinces) {
       this.countryName = countryName;
       this.state = state;
       this.provinces = provinces;
    }
   
    public Integer getIdCountry() {
        return this.idCountry;
    }
    
    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }
    public String getCountryName() {
        return this.countryName;
    }
    
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    public Set<Province> getProvinces() {
        return this.provinces;
    }
    
    public void setProvinces(Set<Province> provinces) {
        this.provinces = provinces;
    }




}


