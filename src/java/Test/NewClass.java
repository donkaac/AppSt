/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Datacontroller.DataParser;
import Entities.Application;
import Entities.Appplatform;
import Entities.Apptype;
import Entities.Category;
import Entities.Comment;
import Entities.Commenthasreply;
import Entities.Country;
import com.sun.tools.jxc.ApBasedTask;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Ish
 */
public class NewClass {
    public static void main(String[] args) {
     
                            
        String base64decode = Datacontroller.EncryptUtils.base64encode("hhjk");
        System.out.println(base64decode);
        try {
            
        Application uniqeresault = (Application) DataParser.getuniqeresault(new Application(), 8);
        Set<Comment> comments = uniqeresault.getComments();
        for (Comment comment : comments) {
             System.out.println("Comment : "+comment.getComment());
            Set<Commenthasreply> commenthasreplies = comment.getCommenthasreplies();
            for (Commenthasreply commenthasreply : commenthasreplies) {
                System.out.println("Reply : "+commenthasreply.getReplyComment());
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
