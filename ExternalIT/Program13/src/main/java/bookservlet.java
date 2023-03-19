

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

@WebServlet("/bookservlet")
public class bookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public bookservlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw= response.getWriter();
              
        String tit=request.getParameter("title");
               
        try
        {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
        	String s="select * from books where bookName=?";
        	PreparedStatement p=con.prepareStatement(s);
        	p.setString(1, tit);
        	
        	ResultSet r=p.executeQuery();
        	boolean status=r.next();
        	if(status)
        	{
        		String type=r.getString(1);
        		String name=r.getString(2);
        		String Author=r.getString(3);
        		String publication=r.getString(4);
        		String price=r.getString(5);

        		pw.println("<html><body style='text-align:center;font-size:20px'>BookType: "+type);
        		pw.println("<br>BookName: "+name);
        		pw.println("<br>BookAuthor: "+Author);
        		pw.println("<br>Book Published By: "+publication);
        		pw.println("<br>Book Price: "+price);
        		pw.println("</body></html>");

        	}
        	else
        	{
        		pw.println("<html><body>Sorry!!No Such Book</body></html>");
        	}
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	
	}

}
