import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class Regi extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>Hello This is Regi Servlet</h1>");
      
        // Uncomment this section to handle username and password
        /*
        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");
        if(uname.equals("manish") && pwd.equals("1234")){
            out.print("<h1>Hello " + uname + " World</h1>");
        } else {
            out.print("<h1>Invalid Credentials</h1>");
        }
        */
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
         out.println("<h1>"+email+"</h1>");
        out.println("<h1>"+password+"</h1>");
        out.println("<h1>"+phone+"</h1>");
        out.println("<h1>"+address+"</h1>");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("Driver loaded");
            
            Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/register?user=root");
            PreparedStatement ps = con.prepareStatement("insert into regi values(?,?,?,?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, phone);
            ps.setString(4, address);
            int rs= ps.executeUpdate();
            if(rs>0){
               out.println("Data inserted successfully");
               ((HttpServletResponse)res).sendRedirect("index.html");
                    }
            else{
               out.println("Data not inserted");
               ((HttpServletResponse)res).sendRedirect("b.html?msg=Data not inserted");
                }
        } catch (Exception e) {
            e.printStackTrace();
            out.println(e);
        }
        // out.println("<h1>"+email+"</h1>");
        // out.println("<h1>"+password+"</h1>");
        // out.println("<h1>"+phone+"</h1>");
        // out.println("<h1>"+address+"</h1>");
    }
}
