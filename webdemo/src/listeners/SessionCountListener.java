package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// @WebListener
public class SessionCountListener implements ServletContextListener, HttpSessionListener {
	int count = 0 ;
    public void sessionCreated(HttpSessionEvent se)  {
    	count++;
    	se.getSession().getServletContext().setAttribute("sessioncount", count);
    	System.out.println("Session Created! Count " + count);
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	count --;
    	se.getSession().getServletContext().setAttribute("sessioncount", count);
    	System.out.println("Session Destroyed! Count " + count);

    }
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("Context Destroyed!");

    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	count = 0;
    	System.out.println("Context Created!");
    }
	
}
