

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
 * Servlet implementation class PlaceorderYB
 */
@WebServlet("/PlaceorderYB")
public class PlaceorderYB extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String schoolname=request.getParameter("schoolname");
		String teachername=request.getParameter("teachername");
		String YByear=request.getParameter("YByear");
		String grade=request.getParameter("grade");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		Connection con=DBConnection.getConnection();
		try
		{
		PreparedStatement st=con.prepareStatement("insert into YEARBOOK values(?,?,?,?,?)");
		st.setString(1,schoolname);
		st.setString(2,teachername);
		st.setString(3,YByear);
		st.setString(4, grade);
		st.setInt(5, quantity);
		int count=st.executeUpdate();
		if(count>0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("PlaceOrder.html");
			rd.include(request, response);
			pw.println("<h3><center><font color='lightgreen'>YearBook order placed..!!</font></center></h3>");
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
