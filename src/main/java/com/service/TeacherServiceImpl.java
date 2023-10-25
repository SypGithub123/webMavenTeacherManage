package com.service;

import com.mapper.ITeacherMapper;
import com.po.PageBean;
import com.po.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 孙宇鹏
 * @Date: 2023/10/23/15:42
 */
@Service("TeacherServiceImpl")
@Transactional
public class TeacherServiceImpl implements ITeacherService {
    @Resource(name = "ITeacherMapper")
    private ITeacherMapper dao;

    public ITeacherMapper getDao() {
        return dao;
    }

    public void setDao(ITeacherMapper dao) {
        this.dao = dao;
    }

    @Override
    public boolean save() {
        if(dao.save() > 0){
            return true;
        }
        return false;
    }
    @Override
    public List<Teacher> findPageAll(PageBean pb) {
        return dao.findPageAll(pb);
    }

    @Override
    public int findMaxRows() {
        return dao.findMaxRows();
    }
}
