package com.demo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "Demo1", "Demo2" })
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSON = "{" + "  \"HEADER\":{" + "    \"headA\":\"1\"," + "    \"headB\":\"2\"" + "  },"
			+ "  \"TRANRS\":{" + "    \"downA\":\"3\"," + "    \"downB\":\"4\"" + "  }" + "}";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		while (request.getReader().ready()) {
			System.out.println(request.getReader().readLine());
		}

		request.getHeaderNames().asIterator().forEachRemaining((head) -> {
			if ("NEW_HEAD".equals(head)) {
				System.out.println(head + "=" + request.getHeader(head));
			}
		});
		response.addHeader("HEAD", "ERROR");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter() //
				.append(JSON) //
		;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
