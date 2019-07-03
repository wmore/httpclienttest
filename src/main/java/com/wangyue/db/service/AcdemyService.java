package com.wangyue.db.service;

import com.wangyue.db.dao.AcdemyRepository;
import com.wangyue.db.model.TAcdemy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AcdemyService {
    @Resource
    private AcdemyRepository acdemyRepository;

    @Transactional
    public void save(TAcdemy acdemy) {
        acdemyRepository.save(acdemy);
    }

    @Transactional
    public void saveAll(List<TAcdemy> acdemies) {
        acdemyRepository.save(acdemies);
    }

    @Transactional
    public void removeAll() {
        acdemyRepository.deleteAll();
    }
}
