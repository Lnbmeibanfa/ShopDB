package Lin.Web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class MyHttpServlet implements Servlet {
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        //1.获取请求方式
        String method = request.getMethod();

        if("GET".equals(method)){
            //get

            doGet(servletRequest,servletResponse);
        }
        else if("POST".equals(method)){
            //post
            doPost(servletRequest,servletResponse);
        }
    }

    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
