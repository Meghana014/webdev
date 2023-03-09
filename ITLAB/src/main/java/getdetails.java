

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

@WebServlet("/getdetails")
public class getdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getdetails() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        String sid=request.getParameter("sid");
        int sid1=Integer.parseInt(sid);
        String name1=request.getParameter("oname");
        
       pw.println("<html><head><title>Data from db</title><style>tr:nth-child(even){background-color:blue;color:white}</style></head>");
       pw.println("<body style='background-image:url('back.jpg');'>");
       try
       {
  		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	 String s="select * from Register where servicenumber=? and firstname=?";
		 //String s="select * from Register";
		 PreparedStatement p=c.prepareStatement(s);
   p.setInt(1, sid1); 
	 p.setString(2, name1);
		 ResultSet r=p.executeQuery();
		 pw.println("<h1 style='background-color:blue;color:white;text-align:center;'>Content Fetched from DataBase</h1>");
		 pw.println("<table border=1  style='margin-left:auto;margin-right:auto;;'>");
		 pw.println("<tr><th>ServiceNumber</th><th>FirstName</th><th>LastName</th><th>Mobile</th><th>Mail</th><th>password</th></tr>");
		boolean status=r.next();
       //while(r.next())
       //{
		if(status)
		{
        	 int servno=r.getInt("servicenumber");
        	 String fname=r.getString("firstname");
        	 String lname=r.getString("lastname");
        	 int phonenum=r.getInt("mobile");
        	 String mail=r.getString("mail");
        	 String password=r.getString("password1");
        	 pw.println("<tr><td>"+servno+"</td><td>"+fname+"</td><td>"+lname+"</td><td>"+phonenum+"</td><td>"+mail+"</td><td>"+password+"</td></tr>");
             
        }
         pw.println("</table>");
         pw.println("</body></html>");
         c.close();
       }
       catch(Exception e)
       {
    	   pw.println("Error");
    	   e.printStackTrace();
       }
	
	}

}
