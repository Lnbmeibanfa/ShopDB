package Lin.Web;

import Lin.Web.DB.AllOperation;
import Lin.Web.DB.EventName;
import Lin.Web.DB.Person;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String username = "Jamie Gordon";
//        String password = "7KpGee04sy";
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        //查询username和password是否一致,若一致，登录成功。若不一致，则登录失败。
        AllOperation ap = new AllOperation();
        PrintWriter writer = resp.getWriter();
        Map<Integer, List<String>> map = ap.Select(EventName.Buyer,username);



        if(map != null) {
            for (int k : map.keySet()) {
                if (map.get(k).get(1).equals(username)) {
                    if (map.get(k).get(2).equals(password)) {
                        writer.write("LoginSuccessfully!");
                    }
                }
            }
        }else{
            writer.write("loginFailure!");
        }




//        if(true){
//
//
//        }
//        else{
//
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}