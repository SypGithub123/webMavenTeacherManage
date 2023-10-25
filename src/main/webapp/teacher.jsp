<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页面管理</title>
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		showAll();
	});

	/**************展示列表begin***************/
	var page = 1;
	var rows = 5;
	var maxPage=1;
	function showAll(){
		$.getJSON("findPageAll_Teacher.do?page="+page+"&rows="+rows,function(pb){
			page=pb.page;
			rows=pb.rows;
			maxPage=pb.maxPage;
			var lstea=pb.pageList;
			var tablehead="<table id='t1' border='1px' width='900px' align='center'>"
					+"<tr align='center' bgcolor='#FFFFCC'>"
					+"<td colspan='7'>教师信息展示</td>"
					+"</tr>"
					+"<tr>"
					+"<td>编号</td>"
					+"<td>姓名</td>"
					+"<td>性别</td>"
					+"<td>生日</td>"
					+"<td>学科</td>"
					+"<td>部门</td>"
					+"<td>操作</td>"
					+"</tr>"
			var trows="";
			for(var i=0;i<lstea.length;i++){
				var tea=lstea[i];
				trows+="<tr>"
						+"<td>"+tea.tno+"</td>"
						+"<td>"+tea.name+"</td>"
						+"<td>"+tea.sex+"</td>"
						+"<td>"+tea.birthday+"</td>"
						+"<td>"+tea.prof+"</td>"
						+"<td>"+tea.depart+"</td>"
						+"<td><input type='button' name='del' id='del' value='删除' onclick='dodelById("+tea.tno+")'><input type='button' name='edit' id='edit' value='编辑' onclick='doeditById("+tea.tno+")'></td>"
						+"</tr>"
			}
			var endtable= tablehead+ trows+"</table>";
			//写入表格
			$("#mytable").html(endtable);
			//分页组件赋值
			$("#outpage").val(page);
			$("#outrows").val(rows);
			$("#pagelable").html(page+"/"+maxPage);
			//按钮处理
			if(page==1){
				$("#btfirst").attr('disabled',true);
				$("#btup").attr('disabled',true);
			}
			if(page>1){
				$("#btfirst").attr('disabled',false);
				$("#btup").attr('disabled',false);
			}
			if(page==maxPage){
				$("#btnext").attr('disabled',true);
				$("#btlast").attr('disabled',true);
			}
			if(page<maxPage){
				$("#btnext").attr('disabled',false);
				$("#btlast").attr('disabled',false);
			}

		});
	};
	/*分页组件*/
	$(function(){
		$("#btfirst").click(function(){
			page=1;
			showAll();
		});
		$("#btup").click(function(){
			page=page-1;
			if(page<1){
				page=1;
			}
			showAll();
		});
		$("#btnext").click(function(){
			page=page+1;
			if(page>maxPage){
				page=maxPage;
			}
			showAll();
		});
		$("#btlast").click(function(){
			page=maxPage;
			showAll();
		});
		//更改当前页
		$("#btchangpage").click(function(){
			var outPage=$("#outpage").val();
			if(isNaN(outPage)){
				alert("请输入正确数字");
				$("#outpage").val(page);
			}
			page=outPage;
			showAll();
		});
		//更改每页
		$("#btchangrows").click(function(){
			var outRows=$("#outrows").val();
			if(isNaN(outRows)){
				alert("请输入正确数字");
				$("#outrows").val(rows);
			}
			rows=outRows;
			showAll();
		});
	});
	/*************展示列表end***************/

	/**************展示添加表格begin***************/
	$(function(){
		$("#btadd").click(function(){
			$.getJSON("save_Teacher.do",function(code){
				if(code == 0){
					alert("添加失败....");
				}
				if(code == 1){
					alert("添加成功....");
					showAll();
				}
			});
		});
	});
	/**************展示添加表格end***************/
	
</script>
</head>
<body>
	<p align="center">教师展示</p>
	<div id="mytable"></div>
	<form action="" id="form1" name="form1">
		<table border="1px" width="900px" align="center" bgcolor="#FFFFCC">
			<tr>
				<td>
					<input type="button" id="btfirst" name="btfirst" value="首页">
				</td>
				<td>
					<input type="button" id="btup" name="btup" value="上一页">
				</td>
				<td>
					<input type="button" id="btnext" name="btnext" value="下一页">
				</td>
				<td>
					<input type="button" id="btlast" name="btlast" value="尾页">
				</td>
				<td>
					跳转
					<input type="text" id="outpage" name="outpage" size="2">
					页
					<input type="button" id="btchangpage" name="btchangpage" value="确定">
				</td>
				<td>
					每页
					<input type="text" id="outrows" name="outrows" size="2" >
					条
					<input type="button" id="btchangrows" name="btchangrows" value="确定">
				</td>
				<td><span id="pagelable">1/1</span></td>
			</tr>
		</table>
	</form>
	<hr>
	<p align="center">
		<button id="btadd" name="btadd">添加</button>
	</p>
</body>
</html>