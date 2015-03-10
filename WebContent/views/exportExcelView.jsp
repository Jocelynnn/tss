<%@page import="tss.model.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="author" content="Shuaiqi Xia" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet"
	href="<s:url value="/css/bootstrapTwo.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<link rel="stylesheet"
	href="<s:url value="/css/bootstrap-theme.min.css"></s:url>" />
<title>Export Excel</title>

<script type="text/javascript"
	src="<s:url value="/js/jquery-1.11.0.js"></s:url>"></script>

</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<s:url value="/views/teachingManagerIndex.jsp"></s:url>"><img
					alt="logo" src="<s:url value="/img/logo.png"></s:url>" /></a>
			</div>
			<s:div cssClass="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a
						href="<s:url value="/views/teachingManagerIndex.jsp"></s:url>">主页</a></li>
					<li><s:a action="courseAssignCheckAction" namespace="/action">课程作业情况</s:a></li>
					<li><s:a action="studentCheckAction" namespace="/action">学生情况</s:a></li>
					<li><s:a action="taAssignCheckAction" namespace="/action">助教情况</s:a></li>
					<li><s:a action="teacherAssignCheckAction" namespace="/action">教师情况</s:a></li>
					<li><s:a action="excelExportAction" namespace="/action">导出课程Excel</s:a></li>
					<li><s:a action="logout" namespace="/action">登出</s:a></li>
				</ul>
			</s:div>
		</div>
	</div>
	<script src="<s:url value="/js/highcharts.js"></s:url>"></script>
	<script src="<s:url value="/js/modules/exporting.js"></s:url>"></script>
	<script src="<s:url value="/js/modules/data.js"></s:url>"></script>

	<div class="container">
		<s:if test="%{isNull==0}">
			<center>
				<h2>当前暂无结束课程</h2>
			</center>
		</s:if>

		<s:if test="%{isNull==1}">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>课程编号</th>
						<th>课程名</th>
						<th>课程描述</th>
						<th>开课时间</th>
						<th>下载链接</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="courseList" id="course">
						<tr class="success">
							<td><s:property value="#course.courseId" /></td>
							<td><s:property value="#course.courseName" /></td>
							<td><s:property value="#course.description" /></td>
							<td><s:property value="#course.semester" /></td>
							<td><a
								href="/tss/action/saveExcelAction?courseId=<s:property value="#course.courseId"/>">下载课程Excel</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:if>
	</div>
</body>
</html>
