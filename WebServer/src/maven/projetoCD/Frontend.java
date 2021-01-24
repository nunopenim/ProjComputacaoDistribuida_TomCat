package maven.projetoCD;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CDFrontend")
public class Frontend extends HttpServlet {
	
	public static RMI_Interface stub = null;
    public static String host = "localhost";
    public static int port = 1099;
    public Registry registry;
	
    public Frontend() {
		try {
			registry = LocateRegistry.getRegistry(host);
            stub = (RMI_Interface) registry.lookup("test_connection");
		} catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
	}
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)	throws IOException {
    	String user = request.getParameter("user");
    	String password = request.getParameter("password");
    	boolean[] user_params;
    	user_params = stub.authenticator(user, password);
    	if (!user_params[0]) {
    		response.sendRedirect(request.getContextPath() + "/falha.jsp");
    	}
    	else {
    		if (user_params[1]) { //admin
    			response.sendRedirect(request.getContextPath() + "/admin.jsp");
    		}
    		else {
    			response.sendRedirect(request.getContextPath() + "/user.jsp");
    		}
    	}
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
    	if (request.getParameter("botao1") != null) {
    		String aaa = stub.listarItensEmVotacao();
    		String[] spliter = aaa.split(Pattern.quote("|"));
    		for (String s : spliter) {
    			out.println(s);
    			out.println("<br>");
            }
    	}
    	else if (request.getParameter("botao2") != null) {
    		String aaa = stub.listarResultados();
    		String[] spliter = aaa.split(Pattern.quote("|"));
    		for (String s : spliter) {
    			out.println(s);
    			out.println("<br>");
            }
    	}
    	else if (request.getParameter("botao3") != null) {
    		String aaa = stub.getAllVoters();
    		String[] spliter = aaa.split(Pattern.quote("|"));
    		for (String s : spliter) {
    			out.println(s);
    			out.println("<br>");
            }
    	}
    }
}
