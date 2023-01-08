import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  

public class FeedbackkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String n=request.getParameter("name"); 
		String uu=request.getParameter("uid"); 
		String f=request.getParameter("feedback"); 

		 
		          
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testing", "root", "root");  
		PreparedStatement ps=con.prepareStatement( "insert into feedback values(?,?,?)");  

		ps.setString(1,n);  
		ps.setString(2,uu); 
		ps.setString(3,f); 
		         
		int i=ps.executeUpdate();  
		if(i>0)  
		//out.print("You are successfully registered...");  
		response.sendRedirect("home.html");  
		          
		}catch (Exception e2) {System.out.println(e2);}         
		out.close();  
		}  
		  
		}  