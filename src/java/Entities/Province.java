package Entities;
// Generated Oct 19, 2016 3:46:26 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Province generated by hbm2java
 */
public class Province  implements java.io.Serializable {


     private Integer idprovince;
     private Country country;
     private String provinceName;
     private boolean state;
     private Set<Discrict> discricts = new HashSet<Discrict>(0);

    public Province() {
    }

	
    public Province(Country country, boolean state) {
        this.country = country;
        this.state = state;
    }
    public Province(Country country, String provinceName, boolean state, Set<Discrict> discricts) {
       this.country = country;
       this.provinceName = provinceName;
       this.state = state;
       this.discricts = discricts;
    }
   
    public Integer getIdprovince() {
        return this.idprovince;
    }
    
    public void setIdprovince(Integer idprovince) {
        this.idprovince = idprovince;
    }
    public Country getCountry() {
        return this.country;
    }
    
    public void setCountry(Country country) {
        this.country = country;
    }
    public String getProvinceName() {
        return this.provinceName;
    }
    
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    public Set<Discrict> getDiscricts() {
        return this.discricts;
    }
    
    public void setDiscricts(Set<Discrict> discricts) {
        this.discricts = discricts;
    }




}


