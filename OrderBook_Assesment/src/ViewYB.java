

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewYB
 */
@WebServlet("/ViewYB")
public class ViewYB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBConnection.getConnection();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
		PreparedStatement st=con.prepareStatement("select * from YEARBOOK");
		ResultSet rs=st.executeQuery();
		out.println("<body bgcolor='lightblue'>");
		out.println("<table border=1 align='center'>");
		out.println("<tr><th>YearBook Order Id</th><th>School Name</th><th>Teacher Name</th><th>Year</th><th>Grade</th><th>Quantity</th></tr>");
		while(rs.next())
		{
			out.println("<tr><td>"+rs.getInt(1)+"</td><td> "+rs.getString(2)+"</td><td> "+rs.getString(3)+"</td><td> "+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td></tr>");
		}
	}
catch(Exception e)
		{
	e.printStackTrace();
		}
	
	
	}

}
