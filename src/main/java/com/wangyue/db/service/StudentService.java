package com.wangyue.db.service;

import com.wangyue.db.dao.StudentRepository;
import com.wangyue.db.model.TStudent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    @Transactional
    public void save(TStudent student){
        studentRepository.save(student);
    }

    @Transactional
    public void saveAll(List<TStudent> students){
        studentRepository.saveAll(students);
    }
}
