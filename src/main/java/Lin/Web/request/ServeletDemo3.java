package Lin.Web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/demo3")
public class ServeletDemo3 extends MyHttpServlet {
    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("Get...");
    }

    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("Post...");

    }
}
