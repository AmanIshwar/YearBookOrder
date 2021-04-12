

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
 * Servlet implementation class ModifyOrdered
 */
@WebServlet("/ModifyOrdered")
public class ModifyOrdered extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=DBConnection.getConnection();
		response.setContentType("text/html");
		PrintWriter upw=response.getWriter();
		String schoolname=request.getParameter("schoolname");
		String teachername=request.getParameter("teachername");		
		String YByear=request.getParameter("YByear");
		String grade=request.getParameter("grade");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		try
		{
		PreparedStatement pst=con.prepareStatement("update YEARBOOK set teachername=?,YByear=?, grade=?,quantity=? where schoolname=?");
		pst.setString(1,teachername);
		pst.setString(2,YByear);
		pst.setString(3, grade);
		pst.setInt(4, quantity);
		pst.setString(5, schoolname);
		int count=pst.executeUpdate();
		if(count>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("ModifyOrderedYB.html");
			rd.include(request, response);
			upw.println("<h3><center><font color='lightgreen'>"+count+" YearBooks Modified..!!</font></center></h3>");
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
