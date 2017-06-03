package com.automation.designPatterns;

import javax.naming.NameNotFoundException;

public class CustomException {

    public Customer findByName(String name) throws NameNotFoundException {

        if ("".equals(name)) {
            throw new NameNotFoundException("Name is empty!");
        }

        return new Customer(name);

    }

    public static void main(String[] args) {

    	CustomException obj = new CustomException();

        try {

            Customer cus = obj.findByName("");

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
