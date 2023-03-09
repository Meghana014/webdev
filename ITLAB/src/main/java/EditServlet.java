

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

@WebServlet("/editservlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
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
       	String s="update Register set  firstname=?,lastname=?,mobile=?,mail=?,password1=? where servicenumber=?";
       	PreparedStatement p=con.prepareStatement(s);
       	p.setString(1, firstname);
       	p.setString(2, lastname);
       	p.setInt(3,phone1);
       	p.setString(4,Mail);
       	p.setString(5, password);
    	p.setInt(6,serviceno1);

   	    int i=p.executeUpdate();
   	    if(i>0)
   	    	pw.println("<h1 style='background-color:blue;color:white;border-top:150px;'>Congrats..You Successfully Updated the content in database</h1>");
   	    else
   	     	pw.println("<h1 style='background-color:blue;color:white;border-top:150px;'>Service Number you  entered is not in database!!so you can't update the content in database,Please Try again</h1>");
       }
       catch(Exception e)
       {
      	 e.printStackTrace();
       }
       pw.println("<a href='Home1.html'>Home</a>");
       pw.print("</body></html>");
	
	
	
	
	}

}
