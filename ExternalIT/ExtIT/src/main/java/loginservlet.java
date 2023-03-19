

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

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginservlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         PrintWriter pw= response.getWriter();
         
      String Mail =request.getParameter("mail");
      String pass =request.getParameter("psd");
      
      try
      {
      	Class.forName("oracle.jdbc.driver.OracleDriver");
      	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
          String s="select * from labreg where Email=? and password1=?";
          PreparedStatement p=con.prepareStatement(s);
          p.setString(1, Mail);
          p.setString(2, pass);
         
          ResultSet r=p.executeQuery();
          boolean status=r.next();
          if(status)
          {
          	pw.println("<html><head><title>Login db</title></head>");
          	pw.println("<body style='text-align:center;font-size:20px;'><h1 style='bgcolor:blue;text-align:center'>Successfully Loggedin <br>Your details are: </h1>");
          	pw.println("<br>Name: "+r.getString("Name"));
          	pw.println("<br>password: "+r.getString("password1"));
          	pw.println("<br>Mail: "+r.getString("Email"));
          	pw.println("<br>Phone number: "+r.getString("Contact"));
          	pw.println("<br>Gender: "+r.getString("Gender"));
          	pw.println("<br>DateOfBirth: "+r.getString("DOB"));
          	//pw.println("Name: "+r.getString("language"));
          	pw.println("<br>Address: "+r.getString("Address"));

          	
          }
          else
          {
        	  pw.println("<html><head><title>storing into db</title></head>");
            	pw.println("<body><h1 style='bgcolor:blue;text-align:center'>Something went wrong!!Invalid credentials..try again</h1></body>");
          }
      }
      catch(Exception e)
      {     	
      	e.printStackTrace();
      }

	
	
	
	}

}
