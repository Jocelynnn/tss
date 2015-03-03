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
								class="icon-bar"></span></a> <a href="#" class="brand">教务系统</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><s:a href="teacherGetCourse.action">课程管理</s:a></li>
									<li class="active"><s:a
											href="teacherGetAssignments.action">作业管理</s:a></li>



								</ul>
								<ul class="nav pull-right">
									<li><a href="#">授课教师</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">授课教师<strong class="caret"></strong></a>
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

				<label>当前课程： 课程名</label>

				<div class="control-group">
					<label class="control-label" for="number">作业编号:自动生成~</label>
					<div class="controls">
						<input id="number" type="text" placeholder="identifier" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="description">作业描述</label>
					<div class="controls">
						<input id="description" type="text" placeholder="作业描述" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="submissionDeadline">提交截止日期</label>
					<div class="controls">
						<input id="submissionDeadline" type="text" placeholder="deadline" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="gradeDealine">批改截止日期</label>
					<div class="controls">
						<input id="gradeDealine" type="text" placeholder="deadline" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="format">作业文件格式</label>
					<div class="controls">
						<input id="format" type="text" placeholder="format" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="fullGrade">满分</label>
					<div class="controls">
						<input id="fullGrade" type="text" placeholder="fullGrade" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="difficulty">难度：三个选项</label>
					<div class="controls">
						<input id="difficulty" type="text" placeholder="difficulty" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="example">样例：上传文件</label>
					<div class="controls">
						<input id="example" type="text" placeholder="example" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="generalGrade">总体点评</label>
					<div class="controls">
						<input id="generalGrade" type="text" placeholder="generalGrade" />
					</div>
				</div>





			</div>






		</div>


	</div>



	</div>

</body>
</html>