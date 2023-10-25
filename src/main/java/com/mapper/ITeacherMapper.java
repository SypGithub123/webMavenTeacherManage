package com.mapper;

import com.po.PageBean;
import com.po.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 孙宇鹏
 * @Date: 2023/10/23/15:32
 */
@Service("ITeacherMapper")
public interface ITeacherMapper {
    public int save();
    public List<Teacher> findPageAll(PageBean pb);
    public int findMaxRows();
}
