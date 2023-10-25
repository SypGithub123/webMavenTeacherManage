package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.po.Teacher;
import com.service.ITeacherService;
import com.service.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.po.PageBean;
import com.util.AjaxUtil;
@Controller
public class TeacherController implements ITeacherController {
	@Resource(name="TeacherServiceImpl")
	private ITeacherService biz;

	public ITeacherService getBiz() {
		return biz;
	}

	public void setBiz(ITeacherService biz) {
		this.biz = biz;
	}

	@RequestMapping("save_Teacher.do")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("save方法正在运行......");
		boolean flag = biz.save();
		if(flag) {
			String jsonStr = JSONObject.toJSONString(1);
			AjaxUtil.printString(response, jsonStr);
		}else {
			String jsonStr = JSONObject.toJSONString(0);
			AjaxUtil.printString(response, jsonStr);
		}
		return null;
	}

	@RequestMapping("findPageAll_Teacher.do")
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		System.out.println("findAll方法正在运行......" + page + "=====" + rows);
		PageBean pb = new PageBean();
		page = page == null || page < 0 ? pb.getPage() : page;
		rows = rows == null || rows < 0 ? pb.getRows() : rows;
		if(rows > 20) {
			rows = 10;
		}
		pb.setPage(page);
		pb.setRows(rows);
		List<Teacher> lstea = biz.findPageAll(pb);
		pb.setPageList(lstea);
		int maxRows = biz.findMaxRows();
		if(maxRows == 0){
			pb.setMaxPage(1);
		}else{
			int maxPage = maxRows % rows == 0 ? maxRows / rows : maxRows / rows + 1;
			pb.setMaxPage(maxPage);
		}
		String jsonStr = JSONObject.toJSONString(pb);
		AjaxUtil.printString(response, jsonStr);
		return null;
	}


}
