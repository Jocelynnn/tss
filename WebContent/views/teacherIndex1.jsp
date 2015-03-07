<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a data-target=".navbar-responsive-collapse"
								data-toggle="collapse" class="btn btn-navbar"><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span></a> <a href="/tss/action/userBackToFirst.action" class="brand">教务系统</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li class="active"><s:a href="teacherGetCourse.action">课程管理</s:a></li>

									<li><s:a href="teacherGetAssignments.action">作业管理</s:a></li>


								</ul>
								<ul class="nav pull-right">
									<li><a href="#">授课教师</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">${username}<strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="/tss/action/userGetPersonalInfo.action">个人信息</a></li>

											<li><a href="/tss/action/logout.action">登出</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>

				<div>
					<table class="table table-hover table-bordered ">
						<thead>
							<tr>
								<th>课程编号</th>
								<th>课程名</th>
								<th>开课学期</th>
								<th>选课学生</th>
								<th>助教</th>
							</tr>
						</thead>
						<s:iterator value="teacherCourses" id="course">
							<tr>
								<td><s:property value="#course.courseId" /></td>
								<td><s:property value="#course.courseName" /></td>
								<td><s:property value="#course.semester" /></td>
								<td><a
									href="teacherGetStudent.action?courseId=<s:property value='#course.courseId'/>&courseName=<s:property value="#course.courseName" />">现在添加</a></td>
								<td><a
									href="teacherGetTA.action?courseId=<s:property value='#course.courseId'/>&courseName=<s:property value="#course.courseName" />">现在添加</a></td>


							</tr>
						</s:iterator>
					</table>


				</div>
			</div>
		</div>
	</div>

</body>
</html>