import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class Display3 extends HttpServlet  
{    
	private static final long serialVersionUID = 1L;
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
         PrintWriter out = res.getWriter();
         try 
         {  
             res.setContentType("text/html");
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");   
             PreparedStatement stmt = con.prepareStatement("select * from query");  
             ResultSet rs = stmt.executeQuery();  
             out.println("<html><body><table border=4 width=50% height=50% style='background-color:grey'><tr style='background-color:rgb(203, 207, 203)'><td>QID</td><td>Email</td><td>Query</td><tr>");  
             while (rs.next()) 
             {       
                 out.println("<tr style='background-color:rgb(172, 240, 172)'><td>" +rs.getString(1)+ "</td><td>" +rs.getString(2)+ "</td><td>" +rs.getString(3)+ "</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();  
            }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  