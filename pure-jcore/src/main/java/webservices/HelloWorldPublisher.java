package webservices;

import javax.xml.ws.Endpoint;

// Endpoint publisher
public class HelloWorldPublisher {
	public static void main(String[] args) {
		// RPC Style
		Endpoint.publish("http://localhost:7979/ws/hello", new HelloWorldImpl());
		// Document Style
		// Endpoint.publish("http://localhost:7979/ws/hello", new HelloWorldDocImpl());
		System.out.println("SOAP Server is online..");
	}
}
