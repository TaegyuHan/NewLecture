package com.Hyeonjin.web.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.repository.Repository;

@Component
public class ExamService {

	@Autowired
	private Repository<Exam> examRepository;

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