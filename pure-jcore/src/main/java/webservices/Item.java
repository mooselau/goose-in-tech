package webservices;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Using JAXB to make this object suitable for transmit via net.
 * 
 * Below is the xml sample:
 * <Item name="xxx">
 * <\/Item>
 */
@XmlRootElement
public class Item {
	
	private String name;
	
	public Item() {}
	
	public Item(String name) {
		this.name = name;
	}
	
	// use the annotation on the method, ignore the fields for now..
	// reason unknown..
	@XmlAttribute
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Item: "+this.name+" is stored on server side!";
	}
	
}
