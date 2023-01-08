import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class RegisterServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String d=request.getParameter("dob"); 
String g=request.getParameter("gender"); 
String mn=request.getParameter("mobno"); 
String u=request.getParameter("uid"); 
String p=request.getParameter("password"); 
String cp=request.getParameter("conpassword"); 
 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/testing", "root", "root");  
PreparedStatement ps=con.prepareStatement(  
"insert into login(Name,DOB,Gender,Mobile_No,Email,Password,Confirm_Password) values(?,?,?,?,?,?,?)");  

ps.setString(1,n);  
ps.setString(2,d); 
ps.setString(3,g);
ps.setString(4,mn);
ps.setString(5,u);
ps.setString(6,p);
ps.setString(7,cp);
         
int i=ps.executeUpdate();  
if(i>0)  
//out.print("You are successfully registered...");  
response.sendRedirect("login.html");     
          
}catch (Exception e2) {System.out.println(e2);}         
out.close();  
}  
  
}  