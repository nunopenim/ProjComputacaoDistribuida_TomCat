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
	
	public String getResults() {
		String response;
		try {
			response = stub.listarResultados();
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
	
	public String winningItem() {
		String response;
		try {
			response = stub.winningItem();
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
	
	public boolean rmuser(String uid) {
		boolean response = false;
		try {
			response = stub.removeUserFromVoters(uid);
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
	public boolean hasStarted() {
		boolean response = false;
		try {
			response = stub.hasStarted();
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
	public boolean hasEnded() {
		boolean response = false;
		try {
			response = stub.hasEnded();
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
	public long startTime() {
		long total = 0;
		try {
			total = stub.startTime();
			return total; 
		}
		catch (RemoteException e) {
			return 0;
		}
	}
	
	public long sLength() {
		long total = 0;
		try {
			total = stub.sessionLength();
			return total; 
		}
		catch (RemoteException e) {
			return 0;
		}
	}
	
	public boolean setStartTime(long epoch) {
		boolean response = false;
		try {
			response = stub.setStarting(epoch);
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}

	public boolean setLength(long seconds) {
		boolean response = false;
		try {
			response = stub.setLength(seconds);
		}
		catch (RemoteException e) {
			return false;
		}
		return response;
	}
	
	public String getAllUsers() {
		String response;
		try {
			response = stub.getAllVoters();
			return response;
		} catch (RemoteException e) {
			return null;
		}
	}
	
	public String getAllUsersInSession() {
		String response;
		try {
			response = stub.getAllSessionVoters();
			return response;
		} catch (RemoteException e) {
			return null;
		}
	}
}

