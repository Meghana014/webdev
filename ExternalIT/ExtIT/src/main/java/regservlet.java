
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

@WebServlet("/regservlet")
public class regservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public regservlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    response.setContentType("text/html");
                   PrintWriter pw= response.getWriter();
                   
                String Name =request.getParameter("name");
                String pass =request.getParameter("psd");
                String mail =request.getParameter("email");
                String phone =request.getParameter("phno");
                String gen =request.getParameter("gender");
                String date =request.getParameter("d");
                String lan =request.getParameter("lang");
                String addr=request.getParameter("address");
                String cno=request.getParameter("credit");
                
                try
                {
                	Class.forName("oracle.jdbc.driver.OracleDriver");
                	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
                    String s="insert into labreg values(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement p=con.prepareStatement(s);
                    p.setString(1, Name);
                    p.setString(2, pass);
                    p.setString(3, mail);
                    p.setString(4, phone);
                    p.setString(5, gen);
                    p.setString(6, date);
                    p.setString(7, lan);
                    p.setString(8, addr);
                    p.setString(9, cno);
                    
                    int i=p.executeUpdate();
                    if(i>0)
                    {
                    	pw.println("<html><head><title>storing into db</title></head>");
                    	pw.println("<body><h1 style='bgcolor:blue;text-align:center'>Successfully stored into DB</h1></body>");
                    }
                }
                catch(Exception e)
                {
                	pw.println("<html><head><title>storing into db</title></head>");
                	pw.println("<body><h1 style='bgcolor:blue;text-align:center'>Something went wrong!!unable to store into DB..try again</h1></body>");
                	e.printStackTrace();
                }

	}

}
