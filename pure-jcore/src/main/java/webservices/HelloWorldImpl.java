package webservices;

import javax.jws.WebService;

// Service Implementation
@WebService(endpointInterface = "JavaWebServices.IHelloWorldRPC")
public class HelloWorldImpl implements IHelloWorldRPC {

	@Override
	public String getHelloWorldAsString(String name) {
		return "Hello World JAX-WS " + name;
	}

	@Override
	public String addItem(Item item) {
		return item.toString();
	}

}
