package com.service;

import com.po.PageBean;
import com.po.Teacher;

import java.util.List;

/**
 * @Author: 孙宇鹏
 * @Date: 2023/10/23/15:41
 */
public interface ITeacherService {
    public boolean save();
    public List<Teacher> findPageAll(PageBean pb);
    public int findMaxRows();
}
