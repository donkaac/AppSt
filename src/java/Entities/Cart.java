package Entities;
// Generated Oct 22, 2016 1:21:43 PM by Hibernate Tools 4.3.1



/**
 * Cart generated by hbm2java
 */
public class Cart  implements java.io.Serializable {


     private CartId id;
     private Application application;
     private Customer customer;
     private boolean state;

    public Cart() {
    }

    public Cart(CartId id, Application application, Customer customer, boolean state) {
       this.id = id;
       this.application = application;
       this.customer = customer;
       this.state = state;
    }
   
    public CartId getId() {
        return this.id;
    }
    
    public void setId(CartId id) {
        this.id = id;
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
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }




}


