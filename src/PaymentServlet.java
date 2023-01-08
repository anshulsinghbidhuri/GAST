import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class PaymentServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String mn=request.getParameter("mobno"); 
String u=request.getParameter("uid"); 
String d=request.getParameter("destination"); 
String f=request.getParameter("from"); 
String t=request.getParameter("to"); 
String p=request.getParameter("pan"); 
 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/testing", "root", "root");  
PreparedStatement ps=con.prepareStatement(  
"insert into checkout(Name,Mobile_No,Email,Destination,_FROM_,_TO_,PAN_Card) values(?,?,?,?,?,?,?)");  

ps.setString(1,n);  
ps.setString(2,mn); 
ps.setString(3,u);
ps.setString(4,d);
ps.setString(5,f);
ps.setString(6,t);
ps.setString(7,p);
         
int i=ps.executeUpdate();  
if(i>0)  
//out.print("You are successfully registered...");  
response.sendRedirect("razpayment.html");     
          
}catch (Exception e2) {System.out.println(e2);}         
out.close();  
}  
  
}  