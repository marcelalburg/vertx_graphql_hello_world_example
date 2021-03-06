package com.example.guice;

import java.util.ArrayList;
import java.util.List;

import com.example.apigen.Contact;
import com.example.apigen.Other1;
import com.example.apigen.helloWorldQuery;
import com.example.apigen.helloWorldQuery.PageArgs;

public class HelloWorldImpl implements helloWorldQuery {

	public List<Object> page(PageArgs args) {
		List<Object> res = new ArrayList<Object>();

		res.add(new Contact.Builder().withId("123").build());
		res.add(new Other1.Builder().withId("321").build());

		return res;
	}

}
