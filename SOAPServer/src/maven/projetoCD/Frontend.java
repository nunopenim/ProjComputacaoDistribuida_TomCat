package maven.projetoCD;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.jws.WebService;

@WebService(targetNamespace = "http://projetoCD.maven/", portName = "FrontendPort", serviceName = "FrontendService")
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
            e.printStackTrace();
        }
	}
	
	public String test() {
		String response;
		try {
			response = stub.testFunc();
			return response;
		} catch (RemoteException e) {
			return null;
		}
	}
	
	public String listarItens() {
		String response;
		try {
			response = stub.listarItensEmVotacao();
			return response;
		}
		catch (RemoteException e) {
			return null;
		}
	}
	
	public int obterTotalVotos() {
		int total = 0;
		try {
			total = stub.getTotalDeVotos();
			return total; 
		}
		catch (RemoteException e) {
			return 0;
		}
	}
	
	public boolean votarEmItem(String uid, String itemID) {
		boolean response = false;
		try {
			response = stub.votar(uid, itemID);
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
	public boolean[] authenticator(String uid, String pw) {
		boolean[] response;
		try {
			response = stub.authenticator(uid, pw);
		} catch (RemoteException e) {
			return null;
		}
		return response;
	}
	
	public String getItem(String id) {
		String response;
		try {
			response = stub.obterItem(id);
			return response;
		}
		catch (RemoteException e) {
			return null;
		}
	}
	
	public boolean hasVoted(String uid) {
		boolean response = false;
		try {
			response = stub.jaVotou(uid);
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
	public boolean adduser(String uid) {
		boolean response = false;
		try {
			response = stub.addUserToVoters(uid);
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
}