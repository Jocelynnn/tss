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
								class="icon-bar"></span></a> <a href="#" class="brand">教务系统</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li ><s:a
										href="/tss/action/adminGetAllUser.action">用户管理</s:a></li>
									<li class="active"><s:a
										href="/tss/action/adminGetAllCourse.action">课程管理</s:a></li>


								</ul>
								<ul class="nav pull-right">
									<li><a href="#">管理员</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">admin<strong
											class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="#">个人信息</a></li>
											<li><s:a href="/tss/action/logout.action">登出</s:a></li>

										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>
				<div class="tabbable" id="tabs-702235">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-29008" data-toggle="tab">修改课程信息</a></li>
						<li><a href="#panel-386299" data-toggle="tab">新增课程</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-29008">
							<div>
								<s:form class="form-search" action="/action/adminSearchCourses">
									<input class="input-medium search-query" name="searchkey"
										type="text" />
									<button type="submit" class="btn">查找课程</button>
								</s:form>

								<div id="searchResult">
									<table class="table">
										<thead>
											<tr>
												<th>课程编号</th>
												<th>课程名</th>
												<th>课程描述</th>
												<th>学期</th>
												<th>授课教师</th>
												<th>操作</th>
											</tr>
										</thead>
										<s:iterator value="courses" id="course">
											<s:form action="/action/adminModifyCourse" methof="post">
												<tr>
													<td><s:textfield style="width: 100px" name="courseId"
															value="%{#course.courseId}"></s:textfield></td>
													<td><s:textfield style="width: 100px"
															name="courseName" value="%{#course.courseName}"></s:textfield></td>
													<td><s:textfield style="width: 100px"
															name="description" value="%{#course.description}"></s:textfield></td>
													<td><s:textfield style="width: 100px" name="semester"
															value="%{#course.semester}"></s:textfield></td>
													<td><s:textfield style="width: 100px"
															name="teacherName" value="%{#course.teacherName}"></s:textfield></td>
													<td><s:textfield style="width: 100px"
															name="teacherName"
															value="%{#course.initializationDeadline}"></s:textfield></td>
													<td>
														<button class="btn" type="submit">保存</button>

													</td>

												</tr>
											</s:form>
										</s:iterator>
									</table>
								</div>

							</div>
						</div>
						<div class="tab-pane " id="panel-386299">
							<div>
								<s:form action="/action/adminAddCourses" method="post">
									<div>
										<s:label>课程编号</s:label>
										<s:textfield name="courseid"></s:textfield>
									</div>


									<div>
										<s:label>课程名</s:label>
										<s:textfield name="coursename"></s:textfield>
									</div>

									<div>
										<s:label>课程描述</s:label>
										<s:textfield name="description"></s:textfield>
									</div>

									<div>
										<s:select headerKey="-1" headerValue="选择学期"
											list="#{'1':'2015 Winter', '2':'2015 Fall','3':'2015 Summer','4':'2015 Spring'}"
											name="semester" value="-1" />
									</div>

									<div>
										<s:label>授课教师</s:label>
										<s:textfield name="instructor"></s:textfield>
									</div>

									<div>
										<button class="btn" type="submit">添加</button>
									</div>
								</s:form>

							</div>


						</div>

					</div>



				</div>
			</div>
		</div>
</body>
</html>