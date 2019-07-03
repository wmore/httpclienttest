package com.wangyue.db.service;

import com.wangyue.db.dao.AcdemyRepository;
import com.wangyue.db.dao.ClassRepository;
import com.wangyue.db.model.TAcdemy;
import com.wangyue.db.model.TClass;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassService {
    @Resource
    private ClassRepository ClassRepository;

    @Transactional
    public void save(TClass tClass) {
        ClassRepository.save(tClass);
    }

    @Transactional
    public void saveAll(List<TClass> classList) {
        ClassRepository.save(classList);
    }

    @Transactional
    public void removeAll() {
        ClassRepository.deleteAll();
    }
}
