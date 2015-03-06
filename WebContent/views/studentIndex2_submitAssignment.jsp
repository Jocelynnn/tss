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
									<li><a
										href="<%=request.getContextPath()%>/views/teacherIndex1.jsp">我的课程</a></li>
									<li class="active"><a
										href="<%=request.getContextPath()%>/views/teacherIndex2.jsp">我的作业</a></li>


								</ul>
								<ul class="nav pull-right">
									<li><a href="#">学生</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">学生<strong class="caret"></strong></a>
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
					<form action="/tss/action/uploadStudentAssignAction.action"
						enctype="multipart/form-data" method="post">
						<input type="hidden" name="courseId" value="<s:property value="assignment.courseId"/>">
						<input type="hidden" name="assignmentNumber" value="<s:property value="assignment.number"/>">
						<input type="hidden" name="assignmentId" value="<s:property value="assignment.id"/>">
						<input type="hidden" name="submissionId" value="<s:property value="submission.id"/>">

						
						<label>课程名: <s:property value="assignment.courseName"/> </label> 
						<label>作业编号: <s:property value="assignment.number"/></label> 
						<label>作业描述: <s:property value="assignment.description"/></label> 
						<label>截止时间: <s:property value="assignment.submissionDeadline"/></label>
						
						<s:if test="%{type==1}">
							<label> <input type="file" name="image"></label> 
							<label> <input type="submit" value="上传" /></label>
						</s:if>
						
						<s:if test="%{type==2}">
							<label>已提交作业名称: <s:property value="fileName"/></label>
							<label> <input type="file" name="image"></label> 
							<label> <input type="submit" value="上传" /></label>
						</s:if>
						
						<s:if test="%{type==3}">
							<label>已提交作业名称: <s:property value="fileName"/></label>
							<label>提交日期: <s:property value="submission.submitDate"/></label>
							<label>分数: <s:property value="submission.grade"/></label>
						</s:if>
						
						<s:if test="%{type==4}">
							<label>提交情况: 你完了，你作业没交~</label>
						</s:if>
						
					</form>
				</div>

			</div>
		</div>
	</div>

</body>
</html>