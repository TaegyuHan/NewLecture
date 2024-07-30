package com.Hyeonjin.web.service;

import java.io.IOException;
import java.util.List;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.repository.Repository;

public class ExamService {

	private Repository<Exam> examRepository;

	// 생성자 의존성 주입

	public void setRepository(Repository<Exam> repository) throws IOException {
		this.examRepository = repository;
	}

	public ExamService() {
	}

	public ExamService(Repository<Exam> repository) throws IOException {
		this.examRepository = repository;
	}

	public List<Exam> getList() throws IOException {
		int page = 0;
		return getList(page);
	}

	public List<Exam> getList(int page) throws IOException {
		return examRepository.findAll();
	}
}