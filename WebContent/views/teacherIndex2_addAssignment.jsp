<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>



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
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="jqueryui/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker({
			minDate : -0,
			maxDate : "+4M +10D"
		});

	});

	$(function() {
		$("#datepicker1").datepicker({
			minDate : -0,
			maxDate : "+4M +10D"
		});
	});
</script>

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
					<s:form action="/action/teacherAddAssignment" method="post">
						<%-- <%String courseId=request.getParameter("courseId"); %>
						<label><%=courseId %></label> --%>

						<div>
							<s:label>当前课程:  </s:label>
							<s:textfield name="courseId" value="%{#parameters.courseId}"
								readonly="true">
							</s:textfield>
						</div>
						<div>
							<s:label>作业编号:</s:label>
							<s:textfield name="number" value="%{#parameters.count}"
								readonly="true">
							</s:textfield>
						</div>

						<div>
							<s:label>作业描述</s:label>
							<s:textarea name="description"></s:textarea>
						</div>


						<div>
							<s:label>提交截止日期</s:label>
							<input type="text" id="datepicker" name="submissionDeadline">
						</div>

						<div>
							<s:label>批改截止日期</s:label>
							<input type="text" id="datepicker1" name="gradeDeadline">
						</div>

						<div>
							<s:label>作业文件格式</s:label>
							<input type="checkbox" name="format" value="doc">doc
							<input type="checkbox" name="format" value="pdf">pdf
							<input type="checkbox" name="format" value="zip">zip

						</div>

						<div>
							<s:label>满分</s:label>
							<s:textfield name="score"></s:textfield>
						</div>


						<div>
							<s:select headerKey="-1" headerValue="作业难度"
								list="#{'1':'easy', '2':'middle','3':'hard'}" name="level"
								value="-1" />
						</div>

						<div>
							<button class="btn" type="submit">提交</button>
						</div>

						<!-- <div class="control-group">
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
				</div> -->


					</s:form>
				</div>
			</div>
		</div>
	</div>




</body>
</html>