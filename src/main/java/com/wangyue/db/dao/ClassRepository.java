package com.wangyue.db.dao;

import com.wangyue.db.model.TClass;
import com.wangyue.db.model.TSpecialty;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<TClass, Long> {
}
