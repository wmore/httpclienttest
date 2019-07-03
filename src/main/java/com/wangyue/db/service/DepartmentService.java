package com.wangyue.db.service;

import com.wangyue.db.dao.DepartmentRepository;
import com.wangyue.db.model.TDepartment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {
    @Resource
    private DepartmentRepository departmentRepository;

    @Transactional
    public void save(TDepartment department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void saveAll(List<TDepartment> departmentList) {
        departmentRepository.save(departmentList);
    }

    @Transactional
    public void removeAll(){
        departmentRepository.deleteAll();
    }

}
