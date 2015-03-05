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

								<ul class="nav pull-right">
									<li><a href="#">助教</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">助教<strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="#">个人信息</a></li>
											<li><a href="/tss/action/logout.action">登出</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>

				<div>
					<s:label>未通过教师审核作业</s:label>
					<table class="table table-hover table-bordered ">
						<thead>
							<tr>
								<th>编号</th>
								<th>学生学号</th>
								<th>学生姓名</th>
								<th>文件路径</th>
								<th>提交时间</th>
								<th>批改人</th>
								<th>分数</th>
								<th>评价</th>
								<th>教师审核</th>
							</tr>
						</thead>
						<s:iterator value="unpassedSubmissionList" id="submission">
							<tr class="error">
								<td><s:property value="#submission.id" /></td>
								<td><s:property value="#submission.studentId" /></td>
								<td><s:property value="#submission.studentName" /></td>
								<td><s:property value="#submission.submission" /></td>
								<%-- <td><s:date name="#submission.submitDate"
										format="yyyy/MM/dd hh:mm:ss" /></td> --%>
								<td><s:property value="#submission.submitDate" /></td>
								<td><s:property value="#submission.grader" /></td>
								<td><s:property value="#submission.grade" /></td>
								<td><s:property value="#submission.evaluation" /></td>
								<s:if test="%{#submission.isPassed==1}">
									<td><a href="#">未审核</a></td>
								</s:if>
								<s:if test="%{#submission.isPassed==2}">
									<td><a href="#">已通过</a></td>
								</s:if>
								<s:if test="%{#submission.isPassed==3}">
									<td><a href="#">未通过</a></td>
								</s:if>
							</tr>
						</s:iterator>
					</table>
				</div>




				<div>
					<s:label>未批改作业</s:label>
					<table class="table table-hover table-bordered ">
						<thead>
							<tr>
								<th>编号</th>
								<th>学生学号</th>
								<th>学生姓名</th>
								<th>文件路径</th>
								<th>提交时间</th>
								<th>批改人</th>
								<th>分数</th>
								<th>评价</th>
								<th>教师审核</th>
							</tr>
						</thead>
						<s:iterator value="ungradedSubmissionList" id="submission">
							<tr >
								<td><s:property value="#submission.id" /></td>
								<td><s:property value="#submission.studentId" /></td>
								<td><s:property value="#submission.studentName" /></td>
								<td><s:property value="#submission.submission" /></td>
								<%-- <td><s:date name="#submission.submitDate"
										format="yyyy/MM/dd hh:mm:ss" /></td> --%>
								<td><s:property value="#submission.submitDate" /></td>
								<td><s:property value="#submission.grader" /></td>
								<td><s:property value="#submission.grade" /></td>
								<td><s:property value="#submission.evaluation" /></td>
								<s:if test="%{#submission.isPassed==1}">
									<td><a href="#">未审核</a></td>
								</s:if>
								<s:if test="%{#submission.isPassed==2}">
									<td><a href="#">已通过</a></td>
								</s:if>
								<s:if test="%{#submission.isPassed==3}">
									<td><a href="#">未通过</a></td>
								</s:if>
							</tr>
						</s:iterator>
					</table>
				</div>

				<div>
					<s:label>已通过教师审核作业</s:label>
					<table class="table table-hover table-bordered ">
						<thead>
							<tr>
								<th>编号</th>
								<th>学生学号</th>
								<th>学生姓名</th>
								<th>文件路径</th>
								<th>提交时间</th>
								<th>批改人</th>
								<th>分数</th>
								<th>评价</th>
								<th>教师审核</th>
							</tr>
						</thead>
						<s:iterator value="passedSubmissionList" id="submission">
							<tr>
								<td><s:property value="#submission.id" /></td>
								<td><s:property value="#submission.studentId" /></td>
								<td><s:property value="#submission.studentName" /></td>
								<td><s:property value="#submission.submission" /></td>
								<%-- <td><s:date name="#submission.submitDate"
										format="yyyy/MM/dd hh:mm:ss" /></td> --%>
								<td><s:property value="#submission.submitDate" /></td>
								<td><s:property value="#submission.grader" /></td>
								<td><s:property value="#submission.grade" /></td>
								<td><s:property value="#submission.evaluation" /></td>
								<s:if test="%{#submission.isPassed==1}">
									<td><a href="#">未审核</a></td>
								</s:if>
								<s:if test="%{#submission.isPassed==2}">
									<td><a href="#">已通过</a></td>
								</s:if>
								<s:if test="%{#submission.isPassed==3}">
									<td><a href="#">未通过</a></td>
								</s:if>
							</tr>
						</s:iterator>
					</table>
				</div>


			</div>
		</div>
	</div>

</body>
</html>