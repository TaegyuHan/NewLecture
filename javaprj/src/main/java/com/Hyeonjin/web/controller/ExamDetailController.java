package com.Hyeonjin.web.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/exam/detail", loadOnStartup = 1)
@MultipartConfig(maxFileSize = 100 * 1024 * 1024, // MB
		maxRequestSize = 200 * 1024 * 1024 // MB
)
public class ExamDetailController extends HttpServlet {

	public ExamDetailController() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");

		request.getRequestDispatcher("/WEB-INF/view/exam/detail.jsp").forward(request, response);
	}
}