package corejava;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import webservices.IHelloWorldRPC;

/**
 * This is for testing JAX-WS Client codes
 * 
 * @author MooseLiu
 *
 */
public class HelloWorldClient {
	
	public static void main(String[] args) throws MalformedURLException {
		// talk to server
		HelloWorldClient client = new HelloWorldClient();
		
		// use RPC Style instance
		IHelloWorldRPC service = client.getService();
		IHelloWorldRPC service2 = client.getService();
		IHelloWorldRPC service3 = client.getService();
		
		client.callMethods(service);
	}
	
	public IHelloWorldRPC getService() throws MalformedURLException {
		
		URL url = new URL("http://localhost:7979/ws/hello?wsdl");
		
		// targetNamespace="http://JavaWebServices/" name="HelloWorldImplService">
		// QName(Service URI(= targetNamespace), service name);
		// use RPC style
		QName qname = new QName("http://JavaWebServices/", "HelloWorldImplService");
		// use Document style
		// QName qname = new QName("http://JavaWebServices/", "HelloWorldDocImplService");

		Service service = Service.create(url, qname);
		
		// use RPC style
		IHelloWorldRPC hello = service.getPort(IHelloWorldRPC.class);
		// use Document style
		// IHelloWorldDocument hello = service.getPort(IHelloWorldDocument.class);
		
		return hello;
	}
	
	public void callMethods(IHelloWorldRPC hello) {
		System.out.println(hello.getHelloWorldAsString("Moose Liu"));
		// Item item = new Item("tester");
		// System.out.println(hello.addItem(item));
	}
}
