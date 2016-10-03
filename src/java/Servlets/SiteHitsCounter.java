package Servlets;

import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class SiteHitsCounter implements Filter ,HttpSessionActivationListener{

    private int hitCount;
    private static int OnlineUsersCount;

    public void init(FilterConfig config)
            throws ServletException {
        // Reset hit counter.
        hitCount = 0;
    }

    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws java.io.IOException, ServletException {

        // increase counter by one
        hitCount++;

        // Print the counter.
        System.out.println("Site visits count :" + hitCount);
System.out.println(OnlineUsersCount);
        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    public void destroy() {
        // This is optional step but if you like you
        // can write hitCount value in your database.
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
       OnlineUsersCount=+1;
        System.out.println(OnlineUsersCount);
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
       OnlineUsersCount=-1;
        System.out.println(OnlineUsersCount);
    }
    
}
