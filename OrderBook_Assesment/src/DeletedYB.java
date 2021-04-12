

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletedYB
 */
@WebServlet("/DeletedYB")
public class DeletedYB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBConnection.getConnection();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String schoolname=request.getParameter("schoolname");
		String YByear=request.getParameter("YByear");
		try
		{
		PreparedStatement pst=con.prepareStatement("delete from YEARBOOK where schoolname=? and YByear=?");
		pst.setString(1,schoolname);
		pst.setString(2, YByear);
			int count=pst.executeUpdate();
		if(count>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("DeleteYB.html");
			rd.include(request, response);
			out.println("<h3><center><font color='red'>"+count+" YearBook Order is Deleted..!!</font></center></h3>");
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

}
