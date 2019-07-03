package com.wangyue.db.dao;

import com.wangyue.db.model.TTeacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<TTeacher, Long> {
}
