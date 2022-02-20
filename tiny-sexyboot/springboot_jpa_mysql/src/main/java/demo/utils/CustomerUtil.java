package demo.utils;

import demo.jpa.entity.Address;
import demo.jpa.entity.Customer;
import demo.jpa.entity.Goods;


public final class CustomerUtil {
    private CustomerUtil() {
    }

    public static Goods buildGoods(String name, Double price) {
        Goods newGoods = new Goods();
        newGoods.setName(name);
        newGoods.setPrice(price);
        return newGoods;
    }

    public static Customer buildCustomer(String name) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        return newCustomer;
    }

    public static Customer buildCompleteCustomer(String name, String mobile, String email, String city,
            String address) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setMobile(mobile);
        newCustomer.setCity(city);
        newCustomer.setEmail(email);
        Address newAddress = new Address();
        newAddress.setDetail(address);
        newCustomer.setAddress(newAddress);
        // newCustomer.setAddressId(addressId);
        return newCustomer;
    }

    public static Address buildAddress(String address) {
        Address newAddress = new Address();
        newAddress.setDetail(address);
        return newAddress;
    }
}
