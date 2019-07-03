package com.wangyue.db.dao;

import com.wangyue.db.model.TAcdemy;
import com.wangyue.db.model.TStudent;
import org.springframework.data.repository.CrudRepository;

public interface AcdemyRepository extends CrudRepository<TAcdemy, Long> {
}
