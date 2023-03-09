

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

@WebServlet("/BillgenerationServlet")
public class BillgenerationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BillgenerationServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        
        
        String Serviceno=request.getParameter("sno");
        int serviceno1=Integer.parseInt(Serviceno);
        String name=request.getParameter("name");

       String Units= request.getParameter("units");
       int u=Integer.parseInt(Units);
       String lr= request.getParameter("preading");
       String pr= request.getParameter("creading");
       String ct= request.getParameter("ctype");
       String phase= request.getParameter("phase");
       
        
	   int billno=213;
       pw.println("<html><head><title>BILL</title><style>tr:nth-child(even){background-color:#AFCFF3;}body{background-image:url('generate.jpg');background-repeat:no-repeat;background-size:1450px 700px}</style></head>");
       pw.println("<body>");     
       try
       {
      	Class.forName("oracle.jdbc.driver.OracleDriver");
       	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
       	String s="insert into billgeneration values(?,?,?,?,?,?)";
       	PreparedStatement p=con.prepareStatement(s);
       	p.setInt(1,serviceno1);
       	p.setInt(2, u);
       	p.setString(3, lr);
       	p.setString(4,pr);
       	p.setString(5,ct);
       	p.setString(6, phase);
        
       	int fc=50;
       	int custcharg=100;
       	int electricduty=12;
       	int addcharges=25;
       	
   	    int i=p.executeUpdate();
   	    if(i>0)
   	    {
   	    	pw.println("<h1 style='border-top:120px;text-align:center;color:white'>");
   	    	pw.println("T S E P BILL-CUM NOTICE</h1>");
   	    	pw.println("<h1><table bgcolor=white align=center>");
   	    	pw.println("<tr><h4><td>DT: "+ct+"</td></h4></tr>");
   	    	pw.println("<tr><h4><td></td><td>NIZAMPET KUKATPALLY</td></h4></tr>");
   	    	pw.println("<tr><b><td style='color:blue'>Bill NO:"+billno+"</td></b></tr>");
   	    	pw.println("<tr><h4><td>KUKATPALLY    </td><td>Nizampet</h4></tr>");
   	    	pw.println("<tr><h4><td>AREA CODE:000415E</td></h4>");
   	    	pw.println("<tr><h4><td colspan=2>--------------------------------------------------------------</td></h4></tr>");
   	    	pw.println("<tr><h2><b><td>SC.NO "+serviceno1+"</h2></td></tr>");
   	    	pw.println("<tr><h4><td>Name: "+name+"</td></h3>");
   	    	pw.println("<tr><h4><td>previous reading: </td><td>"+lr+"</td></h3>");
   	    	pw.println("<tr><h4><td>current reading: </td><td>"+pr+"</td></h3>");
   	    	pw.println("<tr><h4><td colspan=2>---------------------------------------------------------------</td></h6></tr>");
   	    	pw.println("<tr><h2><td>Energy charges: </td><td>"+(u+400)+"</td></h2>");
   	    	pw.println("<tr><h2><td>Fixed charges: </td><td>"+fc+"</td></h2>");
   	    	pw.println("<tr><h2><td>customer charges: </td><td>"+custcharg+"</td></h2>");
   	    	pw.println("<tr><h2><td>Additional charges: </td><td>"+addcharges+"</td></h2>");
   	    	pw.println("<tr><h2><td>loss/gain: </td><td>"+0.00+"</td></h2>");
   	    	pw.println("<tr><h2><td>Net Amount: </td><td>"+((u+400)+fc+custcharg+addcharges+electricduty)+"</td></h2>");
   	    	pw.println("<tr><h2><td>arrears------<td/></h2>");
   	    	pw.println("<tr style='color:blue'><h1><td>TOTAL DUE: </td><td>"+((u+400)+fc+custcharg+addcharges+electricduty)+"</td></h1>");
   	    	pw.println("<tr><h4><td></td><td style='color:red'>Helpline: 78781</td></h3>");
   	    	pw.println("<tr><h4><td></td><td style='color:red'>gmail: power@gmail.com</td></h3>");


   	    	pw.println("</table></h1>");
   	    	
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
