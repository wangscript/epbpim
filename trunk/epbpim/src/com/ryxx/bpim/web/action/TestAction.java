package com.ryxx.bpim.web.action;

import java.io.PrintWriter;

public class TestAction extends ActionSupportBase {
	private static final long serialVersionUID = 6993975688546636282L;
	
	public String execute() throws Exception {
		PrintWriter out = response.getWriter();
		out.println("this is a test");
		return SUCCESS;
	}
}