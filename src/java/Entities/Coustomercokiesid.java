package Entities;
// Generated Oct 22, 2016 1:21:43 PM by Hibernate Tools 4.3.1



/**
 * Coustomercokiesid generated by hbm2java
 */
public class Coustomercokiesid  implements java.io.Serializable {


     private Integer idCokiesId;
     private Customer customer;
     private String cokiesId;

    public Coustomercokiesid() {
    }

	
    public Coustomercokiesid(Customer customer) {
        this.customer = customer;
    }
    public Coustomercokiesid(Customer customer, String cokiesId) {
       this.customer = customer;
       this.cokiesId = cokiesId;
    }
   
    public Integer getIdCokiesId() {
        return this.idCokiesId;
    }
    
    public void setIdCokiesId(Integer idCokiesId) {
        this.idCokiesId = idCokiesId;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public String getCokiesId() {
        return this.cokiesId;
    }
    
    public void setCokiesId(String cokiesId) {
        this.cokiesId = cokiesId;
    }




}


