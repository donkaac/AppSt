package Entities;
// Generated Sep 27, 2016 8:18:01 PM by Hibernate Tools 4.3.1



/**
 * Cart generated by hbm2java
 */
public class Cart  implements java.io.Serializable {


     private Integer idCart;
     private Application application;
     private Customer customer;

    public Cart() {
    }

    public Cart(Application application, Customer customer) {
       this.application = application;
       this.customer = customer;
    }
   
    public Integer getIdCart() {
        return this.idCart;
    }
    
    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }
    public Application getApplication() {
        return this.application;
    }
    
    public void setApplication(Application application) {
        this.application = application;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}


