package Entities;
// Generated Sep 27, 2016 8:18:01 PM by Hibernate Tools 4.3.1



/**
 * Customerhascomment generated by hbm2java
 */
public class Customerhascomment  implements java.io.Serializable {


     private Integer idCustomerHasComment;
     private Comment comment;
     private Customer customer;

    public Customerhascomment() {
    }

    public Customerhascomment(Comment comment, Customer customer) {
       this.comment = comment;
       this.customer = customer;
    }
   
    public Integer getIdCustomerHasComment() {
        return this.idCustomerHasComment;
    }
    
    public void setIdCustomerHasComment(Integer idCustomerHasComment) {
        this.idCustomerHasComment = idCustomerHasComment;
    }
    public Comment getComment() {
        return this.comment;
    }
    
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




}


