package maven.projetoCD;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/voting")
public class Frontend {
	
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
	
	@Path("/TestREST")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testme() {
		try {
			return stub.testFunc();
		} catch (RemoteException e) {
			return "Falha!";
		}
	}
	
	@Path("/itensEmVotação")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listarItens() {
		try {
			return stub.listarItensEmVotacao();
		} catch (RemoteException e) {
			return "Falha!";
		}
	}
	
	@Path("/resultadosVotacao")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listarResultados() {
		try {
			return stub.listarResultados();
		} catch (RemoteException e) {
			return "Falha!";
		}
	}
	
	@GET
	@Path("/login/{usr}/{pw}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String login(@PathParam("usr") String usr, @PathParam("pw") String pw){
		try {
			String retS = "";
			boolean[] value = stub.authenticator(usr, pw);
			if (value[0] = true && value[1] == true) {
				retS = "truetrue";
			}
			else if (value[0] = true && value[1] == false) {
				retS = "truefalse";
			}
			else if (value[0] = false && value[1] == true) {
				retS = "falsetrue";
			}
			else{
				retS = "falsefalse";
			}
			return retS;
		} catch (RemoteException e) {
			return "falsefalse";
		}
	}
	
}

