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
	<%
		String username = (String) request.getSession().getAttribute(
				"username");
		int count = (Integer) request.getSession().getAttribute(
				"messageCount");
	%>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a data-target=".navbar-responsive-collapse"
								data-toggle="collapse" class="btn btn-navbar"><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span></a> <a
								href="/tss/action/userBackToFirst.action" class="brand">教务系统</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">

								<ul class="nav pull-right">
									<li><a href="#">助教</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#"><%=username%> <span
											class="badge"><%=count%></span><strong class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="/tss/action/userGetPersonalInfo.action">个人信息<span
													class="badge"><%=count%></span></a></li>
											<li><a href="/tss/action/logout.action">登出</a></li>

										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>

				<div>
					<div class="tabbable" id="tabs-742700">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#panel-750199" data-toggle="tab">未通过教师审核作业</a>
							</li>
							<li><a href="#panel-5708" data-toggle="tab">未批改作业</a></li>
							<li><a href="#panel-5709" data-toggle="tab">已通过审核作业</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="panel-750199">

								<div>
									<s:label>未通过教师审核作业</s:label>

									<table class="table table-hover table-bordered " id="tb">
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
												<th>操作</th>
											</tr>
										</thead>
										<s:iterator value="unpassedSubmissionList" id="submission">
											<s:form action="/action/taSubmitGrade" method="post">
												<input type="hidden" name="submissionId"
													value="<s:property value="#submission.id"/>" />
												<input type="hidden" name="assignId"
													value="<s:property value="#submission.assignmentId"/>" />

												<tr class="error">
													<td><s:property value="#submission.id" /></td>
													<td><s:property value="#submission.studentId" /></td>
													<td><s:property value="#submission.studentName" /></td>
													<%-- <td><s:property value="#submission.submission" /></td> --%>
													<td><a
														href="/tss/action/taDownloadStuAssignment.action?url=<s:property value='#submission.submission'/>">点击下载</a>
													</td>
													<%-- <td><s:date name="#submission.submitDate"
										format="yyyy/MM/dd hh:mm:ss" /></td> --%>
													<td><s:property value="#submission.submitDate" /></td>
													<td><s:property value="#submission.grader" /></td>
													<td><s:textfield name="grade" maxlength="3"
															style="width: 25px" value="%{#submission.grade}"></s:textfield></td>
													<td><s:textarea name="evaluation"
															value="%{#submission.evaluation}"></s:textarea></td>
													<td>
														<button class="btn" type="submit">保存</button>

													</td>
												</tr>
											</s:form>
										</s:iterator>
									</table>
								</div>





							</div>
							<div class="tab-pane" id="panel-5708">

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
												<th>分数</th>
												<th>评价</th>
												<th>教师审核</th>
											</tr>
										</thead>
										<s:iterator value="ungradedSubmissionList" id="submission">
											<s:form action="/action/taSubmitGrade" method="post">
												<input type="hidden" name="submissionId"
													value="<s:property value="#submission.id"/>" />
												<input type="hidden" name="assignId"
													value="<s:property value="#submission.assignmentId"/>" />

												<tr>
													<td><s:property value="#submission.id" /></td>
													<td><s:property value="#submission.studentId" /></td>
													<td><s:property value="#submission.studentName" /></td>
													<%-- <td><s:property value="#submission.submission" /></td> --%>
													<td><a
														href="/tss/action/taDownloadStuAssignment.action?url=<s:property value='#submission.submission'/>">点击下载</a>
													</td>
													<%-- <td><s:date name="#submission.submitDate"
										format="yyyy/MM/dd hh:mm:ss" /></td> --%>
													<td><s:property value="#submission.submitDate" /></td>
													<td><s:textfield name="grade" maxlength="3"
															style="width: 25px" value="%{#submission.grade}"></s:textfield></td>
													<td><s:textarea name="evaluation"
															value="%{#submission.evaluation}"></s:textarea></td>
													<td>
														<button class="btn" type="submit">保存</button>

													</td>
												</tr>
											</s:form>
										</s:iterator>
									</table>
								</div>




							</div>

							<div class="tab-pane" id="panel-5709">


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
											<tr class="success">
												<td><s:property value="#submission.id" /></td>
												<td><s:property value="#submission.studentId" /></td>
												<td><s:property value="#submission.studentName" /></td>
												<td><a
													href="/tss/action/taDownloadStuAssignment.action?url=<s:property value='#submission.submission'/>">点击下载</a>
												</td>
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
		</div>
	</div>
</body>
</html>