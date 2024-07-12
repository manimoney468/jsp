import jakarta.servlet.*;
import java.io.*;

public class Babu extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        if(uname.equals("manish") && pwd.equals("1234")){
            res.getWriter().print("<h1>Hello "+uname+"World</h1>");
        }
        else{
            res.getWriter().print("<h1>Invalid Credentials</h1>");
        }
        // res.getWriter().print("<h1>Hello "+uname+"World</h1>");
    }
}
