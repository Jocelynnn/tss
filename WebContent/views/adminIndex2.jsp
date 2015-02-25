<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
								class="icon-bar"></span></a> <a href="#" class="brand">教务系统</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a
										href="<%=request.getContextPath()%>/views/adminIndex1.jsp">用户管理</a></li>
									<li class="active"><a
										href="<%=request.getContextPath()%>/views/adminIndex2.jsp">课程管理</a></li>


								</ul>
								<ul class="nav pull-right">
									<li><a href="#">管理员</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">admin<strong
											class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="#">个人信息</a></li>

											<li><a href="#">登出</a></li>
											<li class="divider"></li>
											<li><a href="#">链接3</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>
				<div class="tabbable" id="tabs-702235">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-386299" data-toggle="tab">新增课程</a>
						</li>
						<li><a href="#panel-29008" data-toggle="tab">修改课程信息</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-386299">
							<div>
								<div class="control-group">
									<label class="control-label" for="CourseID">课程编号</label>
									<div class="controls">
										<input id="CourseID" type="text" placeholder="identifier" />
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="inputCourseName">课程名</label>
									<div class="controls">
										<input id="inputCourseName" type="text" placeholder="课程名" />
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="inputCourseDescription">课程描述</label>
									<div class="controls">
										<input id="inputCourseDescription" type="text"
											placeholder="description" />
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="inputCourseSemester">开课学期</label>
									<div class="controls">
										<input id="inputCourseSemester" type="text"
											placeholder="semester" />
									</div>
								</div>

								<div class="control-group">
									<label class="control-label" for="inputCourseInstructor">授课教师</label>
									<div class="controls">
										<input id="inputCourseInstructor" type="text"
											placeholder="instructor" />
									</div>
								</div>

							</div>


						</div>
						<div class="tab-pane" id="panel-29008">
							<form class="form-search">
								<input class="input-medium search-query" type="text" />
								<button type="submit" class="btn">查找课程</button>
							</form>
							<div id="searchResult" style="display: none;"></div>
						</div>
					</div>



				</div>
			</div>
		</div>
</body>
</html>