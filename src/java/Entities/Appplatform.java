package Entities;
// Generated Oct 19, 2016 3:46:26 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Appplatform generated by hbm2java
 */
public class Appplatform  implements java.io.Serializable {


     private Integer idAppplatform;
     private String appplatform;
     private boolean state;
     private Set<Apptype> apptypes = new HashSet<Apptype>(0);

    public Appplatform() {
    }

	
    public Appplatform(String appplatform, boolean state) {
        this.appplatform = appplatform;
        this.state = state;
    }
    public Appplatform(String appplatform, boolean state, Set<Apptype> apptypes) {
       this.appplatform = appplatform;
       this.state = state;
       this.apptypes = apptypes;
    }
   
    public Integer getIdAppplatform() {
        return this.idAppplatform;
    }
    
    public void setIdAppplatform(Integer idAppplatform) {
        this.idAppplatform = idAppplatform;
    }
    public String getAppplatform() {
        return this.appplatform;
    }
    
    public void setAppplatform(String appplatform) {
        this.appplatform = appplatform;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    public Set<Apptype> getApptypes() {
        return this.apptypes;
    }
    
    public void setApptypes(Set<Apptype> apptypes) {
        this.apptypes = apptypes;
    }




}


