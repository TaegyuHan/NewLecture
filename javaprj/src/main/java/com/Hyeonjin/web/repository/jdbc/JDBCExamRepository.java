package com.Hyeonjin.web.repository.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.Hyeonjin.web.entity.Exam;
import com.Hyeonjin.web.repository.Repository;

public class JDBCExamRepository implements Repository<Exam> {

    @Override
    public List<Exam> findAll() {
    	List<Exam> list = new ArrayList<>();
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int save() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
