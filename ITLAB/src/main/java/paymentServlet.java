

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


@WebServlet("/paymentServlet")
public class paymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public paymentServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String paymethod=request.getParameter("pay");
		String sno=request.getParameter("serv");
		int sid=Integer.parseInt(sno);
		String cost=request.getParameter("cost");
		int amt=Integer.parseInt(cost);
		String ptype=request.getParameter("type");
		String ctype=request.getParameter("ctype");
		String pin=request.getParameter("pin");
		
		 try
         {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
         	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
         	String s="insert into payment values(?,?,?,?,?,?)";
         	PreparedStatement p=con.prepareStatement(s);
         	p.setString(1,paymethod);
         	p.setInt(2, sid);
         	p.setInt(3,amt );
         	p.setString(4,ptype);
         	p.setString(5,ctype);
         	p.setString(6, pin);

     	    int i=p.executeUpdate();
     	    if(i>0)
     	    {
     	    	pw.println("<h1 style='background-color:blue;color:white;border-top:150px;text-align:center'>Congrats..You paid Bill Successfully</h1>");
     	    }
     	    else
     	    {
     	    	pw.println("<h1 style='background-color:blue;color:white;border-top:150px;text-align:center'>Something is missed..PAYMENT FAILED,PleaseTry again</h1>");

     	    }
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         pw.print("</body></html>");

}


}
