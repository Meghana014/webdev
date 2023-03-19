

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/payservlet")
public class payservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public payservlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
       PrintWriter pw= response.getWriter();
       
		String c=request.getParameter("cno");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	      	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	          String s="select * from labreg where creditcardNo=? ";
	          PreparedStatement p=con.prepareStatement(s);
	          p.setString(1, c);
	         
	          ResultSet r=p.executeQuery();
	          boolean status=r.next();
	          if(status)
	          {
	        	  pw.println("<html><body style='text-align:center'><h1>Payment Successfull</h1></body></html>");
	          }
	          else
	          {
	        	  pw.println("<html><body style='text-align:center'><h1>payment unsuccess</h1></body></html>");
	          }
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	
	
	}

}
