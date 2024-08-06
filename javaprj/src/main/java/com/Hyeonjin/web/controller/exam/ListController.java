package com.Hyeonjin.web.controller.exam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 12222, maxFileSize = 100 * 1024 * 1024, // MB
		maxRequestSize = 200 * 1024 * 1024 // MB
)
public class ListController extends HttpServlet implements Controller {

	@Autowired
	private ExamService service;

	public void ExamController(ExamService service) throws IOException {
		this.service = service;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; UTF-8");

		String[] colors = request.getParameterValues("c");
		System.out.println(Arrays.toString(colors));

		int page = 1;
		String page_ = request.getParameter("p");
		if (page_ != null && "".equals(page_)) {
			page = Integer.parseInt(page_);
		}

		System.out.println("동작중");
		List<Exam> exams = service.getList(page);

		request.setAttribute("list", exams);
		request.getRequestDispatcher("/WEB-INF/view/exam/list.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part imgPart = req.getPart("img");
		String imgName = imgPart.getSubmittedFileName();
		InputStream is = imgPart.getInputStream();

		// 2. 파일경로 설정하기
		String realPath = req.getServletContext().getRealPath("/notice/upload");
		File pathFile = new File(realPath);
		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}

		String path = realPath + File.separator + imgName;
		FileOutputStream fous = new FileOutputStream(path);

		int i = 0; // 1. 숟가락 키우기
		byte[] buf = new byte[1024]; //
		for (int size = 0; (size = is.read(buf)) != -1;) {
			fous.write(buf, 0, size);
			System.out.println(++i); // 읽는 횟수
		}

		fous.close();
		System.out.println(imgName);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}