package com.wangyue.db.dao;

import com.wangyue.db.model.TDepartment;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<TDepartment, Long> {
}
