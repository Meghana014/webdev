

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		           response.setContentType("text/html");
                   PrintWriter pw=response.getWriter();
                   
                  String Serviceno=request.getParameter("sno");
	              int serviceno1=Integer.parseInt(Serviceno);
	             String firstname= request.getParameter("fname");
	             String lastname= request.getParameter("lname");
	             String phone= request.getParameter("ph");
	             int phone1=Integer.parseInt(phone);
	             String Mail= request.getParameter("mail");
	             String password= request.getParameter("pass");
	             
	             pw.print("<html><head><title>Storing into database</title></head><body style='text-align:center;'>");
	             
	             try
	             {
	            	Class.forName("oracle.jdbc.driver.OracleDriver");
                 	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
                 	String s="insert into Register values(?,?,?,?,?,?)";
                 	PreparedStatement p=con.prepareStatement(s);
                 	p.setInt(1,serviceno1);
                 	p.setString(2, firstname);
                 	p.setString(3, lastname);
                 	p.setInt(4,phone1);
                 	p.setString(5,Mail);
                 	p.setString(6, password);

             	    int i=p.executeUpdate();
             	    if(i>0)
             	    {
             	    	pw.println("<h1 style='background-color:blue;color:white;border-top:150px;'>Congrats..You are Successfully Registered</h1>");
             	    }
             	    else
             	    {
             	    	pw.println("<h1>Something is missed..You are Not Registered,PleaseTry agin</h1>");

             	    }
	             }
	             catch(Exception e)
	             {
	            	 e.printStackTrace();
	             }
	             pw.print("</body></html>");

	}

}
