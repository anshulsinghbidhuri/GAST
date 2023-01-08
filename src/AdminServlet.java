
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 /**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
PrintWriter writer = response.getWriter();
String password = request.getParameter("password");

 try {
Class.forName("com.mysql.jdbc.Driver");
Connection connection = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/testing", "root", "root");
Statement statement = connection.createStatement();
ResultSet rs = statement
.executeQuery("Select * from admin where Password='" + password
+ "'");
if(rs.next()){
response.sendRedirect("admin.html");
}else{
	response.sendRedirect("Invalid.html");
}
} catch (ClassNotFoundException | SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

}