package Entities;
// Generated Oct 22, 2016 1:21:43 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Serialkeys generated by hbm2java
 */
public class Serialkeys  implements java.io.Serializable {


     private Integer idserialkeys;
     private Application application;
     private String serialkey;
     private Boolean state;
     private Set<Customerhasapplication> customerhasapplications = new HashSet<Customerhasapplication>(0);

    public Serialkeys() {
    }

	
    public Serialkeys(Application application, String serialkey) {
        this.application = application;
        this.serialkey = serialkey;
    }
    public Serialkeys(Application application, String serialkey, Boolean state, Set<Customerhasapplication> customerhasapplications) {
       this.application = application;
       this.serialkey = serialkey;
       this.state = state;
       this.customerhasapplications = customerhasapplications;
    }
   
    public Integer getIdserialkeys() {
        return this.idserialkeys;
    }
    
    public void setIdserialkeys(Integer idserialkeys) {
        this.idserialkeys = idserialkeys;
    }
    public Application getApplication() {
        return this.application;
    }
    
    public void setApplication(Application application) {
        this.application = application;
    }
    public String getSerialkey() {
        return this.serialkey;
    }
    
    public void setSerialkey(String serialkey) {
        this.serialkey = serialkey;
    }
    public Boolean getState() {
        return this.state;
    }
    
    public void setState(Boolean state) {
        this.state = state;
    }
    public Set<Customerhasapplication> getCustomerhasapplications() {
        return this.customerhasapplications;
    }
    
    public void setCustomerhasapplications(Set<Customerhasapplication> customerhasapplications) {
        this.customerhasapplications = customerhasapplications;
    }




}


