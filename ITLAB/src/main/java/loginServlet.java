

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

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public loginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        
        String Serviceno=request.getParameter("sid");
        int sno=Integer.parseInt(Serviceno);
        String password= request.getParameter("pass");
        
        pw.println("<html><body bgcolor='#C0C0C0'>");
        try
        {
   		 Class.forName("oracle.jdbc.driver.OracleDriver");
 		 Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
 		String s="select * from Register where servicenumber=? and password1=?";
 		 PreparedStatement p=c.prepareStatement(s);
 		p.setInt(1, sno); 
 		 p.setString(2,password);
 		 ResultSet r=p.executeQuery();
 		 
 		boolean status=r.next();
 		String fname=r.getString("firstname");
 		if(status)
 			//pw.println("<h1 style='background-color:#8AB2F7;color:white;text-align:center;border-style:groove;border-width:7px;border-color:blue;margin-top:150px;'>");
 			pw.println("<h1 style='background-color:white;color:#808080;text-align:center;height:200px;margin-top:200px;'>");
 			pw.println("Hello "+fname+" you are successfully loggedin..Now you can continue with your requirements<br>");
 			pw.println("<img src='greentick.jpg' height=130px width=130px style='margin-left:auto;margin-right:auto;'></img></h1>");
 			pw.println("<a href='Home1.html' style='background-color:#808080;color:white;font-size:30px;'>Home</a>");
 		
 		c.close();
         
      }
        catch(Exception e)
        {
 	//	    pw.println("<h1 style='background-color:#8AB2F7;color:white;text-align:center;border-style:groove;border-width:7px;border-color:blue;margin-top:150px;'>Hello customer your login credentials are wrong!!please try again</h1>");
        	pw.println("<h1 style='background-color:white;color:#808080;text-align:center;height:200px;margin-top:200px;'>");
 			pw.println("Hello customer your login credentials are wrong!!please try again<br>");
 			pw.println("<img src='redtick.jpg' height=120px width=120px style='margin-left:auto;margin-right:auto;'></img></h1>");
        	pw.println("<a href='Home1.html' style='background-color:#808080;color:white;font-size:30px;'>Home</a><br><br>");
 			pw.println("<a href='login.html' style='background-color:#808080;color:white;font-size:30px;'>Login</a>");

        }
        pw.println("</body></html>");
 	}
}


