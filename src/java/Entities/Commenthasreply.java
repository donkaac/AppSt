package Entities;
// Generated Oct 2, 2016 12:23:07 PM by Hibernate Tools 4.3.1



/**
 * Commenthasreply generated by hbm2java
 */
public class Commenthasreply  implements java.io.Serializable {


     private int idcommenthasreply;
     private Comment comment;
     private Developer developer;
     private String replyComment;
     private boolean state;

    public Commenthasreply() {
    }

    public Commenthasreply(int idcommenthasreply, Comment comment, Developer developer, String replyComment, boolean state) {
       this.idcommenthasreply = idcommenthasreply;
       this.comment = comment;
       this.developer = developer;
       this.replyComment = replyComment;
       this.state = state;
    }
   
    public int getIdcommenthasreply() {
        return this.idcommenthasreply;
    }
    
    public void setIdcommenthasreply(int idcommenthasreply) {
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


