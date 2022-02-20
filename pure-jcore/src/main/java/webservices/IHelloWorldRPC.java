package webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * This is JAX-WS (SOAP) RPC Style.
 */
// Service Endpoint Interface
@WebService
@SOAPBinding(style=Style.RPC)
public interface IHelloWorldRPC {
	@WebMethod
	String getHelloWorldAsString(String name);
	
	@WebMethod
	String addItem(Item item);
}
