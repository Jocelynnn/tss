<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="author" content="Shuaiqi Xia" />
<link rel="stylesheet" href="<s:url value="//css/bootstrapTwo.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<link rel="stylesheet"
	href="<s:url value="/css/bootstrap-theme.min.css"></s:url>" />
<title>Index</title>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<s:url value="/views/teachingManagerIndex.jsp"></s:url>"><img
					alt="logo" src="<s:url value="/img/logo.png"></s:url>" /></a>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-9">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<h1>你好,&nbsp;教学负责人!</h1>
					<p>欢迎来到统计界面，你在这里可以查看整个教学管理系统数据图表。</p>
				</div>
				<div class="row">
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>
							<s:a action="courseAssignCheckAction" namespace="/action">课程作业情况</s:a>
						</h2>
						<p>课程数、作业数、分数情况等</p>
					</div>
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>
							<s:a action="studentCheckAction" namespace="/action">学生情况</s:a>
						</h2>
						<p>作业提交、得分等</p>
					</div>
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>
							<s:a action="taAssignCheckAction" namespace="/action">助教情况</s:a>
						</h2>
						<p>批改作业情况</p>
					</div>
					<div class="col-6 col-sm-6 col-lg-4">
						<h2>
							<s:a action="teacherAssignCheckAction" namespace="/action">教师情况</s:a>
						</h2>
						<p>作业安排情况</p>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<s:a cssClass="list-group-item" action="courseAssignCheckAction" namespace="/action">课程作业情况</s:a>
					<s:a cssClass="list-group-item" action="studentCheckAction" namespace="/action">学生情况</s:a>
					<s:a cssClass="list-group-item" action="taAssignCheckAction" namespace="/action">助教情况</s:a>
					<s:a cssClass="list-group-item" action="teacherAssignCheckAction" namespace="/action">教师情况</s:a>
					
				</div>
			</div>
		</div>
	</div>
</body>