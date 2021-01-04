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
	
	public boolean[] authenticator(String uid, String pw) {
		boolean[] response;
		try {
			response = stub.authenticator(uid, pw);
		} catch (RemoteException e) {
			return null;
		}
		return response;
	}
	
}
