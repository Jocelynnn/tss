<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>

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
									<li><s:a href="/tss/action/teacherGetCourse.action">课程管理</s:a></li>
									<li class="active"><s:a
											href="/tss/action/teacherGetAssignments.action">作业管理</s:a></li>



								</ul>
								<ul class="nav pull-right">
									<li><a href="#">授课教师</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">${username}<strong class="caret"></strong></a>
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
					<s:label>当前课程:  </s:label>
					<s:property value="courseName"></s:property>
				</div>
				<div>
					<s:label>作业编号:<s:property value="assignNumber"></s:property>
					</s:label>

				</div>



				<form action="/tss/action/teacherUpload.action"
					enctype="multipart/form-data" method="post">
					<input type="hidden" name="courseId"
						value="<s:property value="courseId"/>"> <input
						type="hidden" name="assignNumber"
						value="<s:property value="assignNumber"/>"> <input
						type="hidden" name="assignmentId"
						value="<s:property value="assignId"/>"> <input
						type="hidden" name="teacherId"
						value="<s:property value="teacherId"/>">

					<s:label>作业范例：</s:label>
					<input type="file" name="image" id="image">
					<button class="btn" type="submit">上传</button>
					<s:label>
						<s:property value="alterstr"></s:property>
					</s:label>
				</form>

				<div>
					<s:label>总体点评</s:label>
					<s:textarea></s:textarea>

				</div>
				<div>
					<button class="btn" type="submit">提交</button>

				</div>

				<br> <br> <br> <br>

				<div class="tabbable" id="tabs-742700">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-750199" data-toggle="tab">未审核作业</a>
						</li>
						<li><a href="#panel-5708" data-toggle="tab">未通过作业</a></li>
						<li><a href="#panel-5709" data-toggle="tab">已通过作业</a></li>

					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-750199">
							<div>
								<s:label>未审核作业</s:label>
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
											<th>审核</th>
										</tr>
									</thead>
									<s:iterator value="unviewedSubmissionList" id="submission">
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
											<td><a
												href="teacherPassSubmission.action?submissionId=<s:property value='#submission.id'/>&assignId=<s:property value='assignId'/>">通过</a>
												<a
												href="teacherUnpassSubmission.action?submissionId=<s:property value='#submission.id'/>&assignId=<s:property value='assignId'/>">不通过</a></td>
										</tr>
									</s:iterator>
								</table>


							</div>
						</div>
						<div class="tab-pane" id="panel-5708">
							<div>
								<s:label>未通过作业</s:label>
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
											<th>审核</th>
										</tr>
									</thead>
									<s:iterator value="unpassedSubmissionList" id="submission">
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
											<td><a
												href="teacherPassSubmission.action?submissionId=<s:property value='#submission.id'/>&assignId=<s:property value='assignId'/>">通过</a>
												<a
												href="teacherUnpassSubmission.action?submissionId=<s:property value='#submission.id'/>&assignId=<s:property value='assignId'/>">不通过</a></td>
										</tr>
									</s:iterator>
								</table>


							</div>
						</div>
						<div class="tab-pane" id="panel-5709">
							<div>
								<s:label>已通过作业</s:label>
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
											<th>审核</th>
										</tr>
									</thead>
									<s:iterator value="passedSubmissionList" id="submission">
										<tr class="success">
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
											<td>已通过</td>
										</tr>
									</s:iterator>
								</table>


							</div>
						</div>
					</div>









				</div>






			</div>


		</div>
</body>
</html>