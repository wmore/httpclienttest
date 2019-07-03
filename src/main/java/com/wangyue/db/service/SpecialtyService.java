package com.wangyue.db.service;

import com.wangyue.db.dao.SpecialtyRepository;
import com.wangyue.db.dao.StudentRepository;
import com.wangyue.db.model.TSpecialty;
import com.wangyue.db.model.TStudent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecialtyService {
    @Resource
    private SpecialtyRepository specialtyRepository;

    @Transactional
    public void save(TSpecialty specialty) {
        specialtyRepository.save(specialty);
    }

    @Transactional
    public void saveAll(List<TSpecialty> specialties) {
        specialtyRepository.save(specialties);
    }

    @Transactional
    public void removeAll() {
        specialtyRepository.deleteAll();
    }
}
