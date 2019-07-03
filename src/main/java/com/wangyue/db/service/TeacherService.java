package com.wangyue.db.service;

import com.wangyue.db.dao.TeacherRepository;
import com.wangyue.db.model.TTeacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherService {
    @Resource
    private TeacherRepository TeacherRepository;

    @Transactional
    public void save(TTeacher teacher) {
        TeacherRepository.save(teacher);
    }

    @Transactional
    public void saveAll(List<TTeacher> teacherList) {
        TeacherRepository.save(teacherList);
    }

    @Transactional
    public void removeAll() {
        TeacherRepository.deleteAll();
    }
}
