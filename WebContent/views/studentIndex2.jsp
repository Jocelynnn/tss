<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
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
									<li class="active"><s:a
											href="/tss/action/studentSearchCourse.action">我的课程</s:a></li>
									<li><s:a
											href="/tss/action/studentGetAssignment.action">我的作业</s:a></li>


								</ul>
								<ul class="nav pull-right">
									<li><a href="#">学生</a></li>
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
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<!-- 								<th>课程编号</th>
 -->
								<th>课程名</th>
								<th>作业编号</th>
								<th>作业描述</th>
								<th>难度</th>
								<th>提交截止日期</th>
								<th>我的提交</th>

							</tr>
						</thead>
						<s:iterator value="courseAssignments" id="column">
							<s:set var="total" name="total" value="#column.value.size" />
							<s:iterator value="#column.value" id="col" status="st">
								<tr>
									<s:if test="#st.first">
										<%-- 										<td rowspan="${total}"><s:property value="#column.key" /></td>
 --%>
										<td rowspan="${total}"><s:property value="courseName" /></td>

									</s:if>
									<td><s:a href="/tss/action/">
											<s:property value="number" />
										</s:a></td>
									<td><s:property value="description" /></td>
									<td><s:property value="level" /></td>
									<td><s:property value="submissionDeadline" /></td>
									<td><s:a href="/tss/action/studentGetSingleAssignment.action?assignmentId=%{#col.Id}">作业详情</s:a></td>
								</tr>
							</s:iterator>
						</s:iterator>
					</table>
				</div>

			</div>
		</div>
	</div>

</body>
</html>