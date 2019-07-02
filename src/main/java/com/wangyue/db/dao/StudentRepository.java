package com.wangyue.db.dao;

import com.wangyue.db.model.TStudent;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<TStudent, Long> {
}
