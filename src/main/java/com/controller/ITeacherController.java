package com.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Teacher;

public interface ITeacherController {
	public String save(HttpServletRequest request, HttpServletResponse response);
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows);
}
