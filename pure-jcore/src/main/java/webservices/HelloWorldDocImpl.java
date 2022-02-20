package webservices;

import javax.jws.WebService;

// this is a implementation for JAX-WS (SOAP) Document Style
@WebService(endpointInterface = "JavaWebServices.IHelloWorldDocument")
public class HelloWorldDocImpl implements IHelloWorldDocument {

	@Override
	public String getHelloWorldAsString(String name) {
		return ("Hello World JAX-WS "+name);
	}

}
