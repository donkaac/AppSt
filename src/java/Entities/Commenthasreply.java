package Entities;
// Generated Oct 19, 2016 3:46:26 PM by Hibernate Tools 4.3.1



/**
 * Commenthasreply generated by hbm2java
 */
public class Commenthasreply  implements java.io.Serializable {


     private Integer idcommenthasreply;
     private Comment comment;
     private Developer developer;
     private String replyComment;
     private boolean state;

    public Commenthasreply() {
    }

    public Commenthasreply(Comment comment, Developer developer, String replyComment, boolean state) {
       this.comment = comment;
       this.developer = developer;
       this.replyComment = replyComment;
       this.state = state;
    }
   
    public Integer getIdcommenthasreply() {
        return this.idcommenthasreply;
    }
    
    public void setIdcommenthasreply(Integer idcommenthasreply) {
        this.idcommenthasreply = idcommenthasreply;
    }
    public Comment getComment() {
        return this.comment;
    }
    
    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public Developer getDeveloper() {
        return this.developer;
    }
    
    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
    public String getReplyComment() {
        return this.replyComment;
    }
    
    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }
    public boolean isState() {
        return this.state;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }




}


