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

				<div class="tabbable" id="tabs-742700">

					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-750199" data-toggle="tab">消息列表</a></li>
						<li><a href="#panel-5708" data-toggle="tab">个人信息</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-750199">
							<s:if test="%{messageList.size()==0}">
								<s:label>无消息</s:label>
							</s:if>

							<s:else>
								<table class="table table-hover table-bordered">
									<thead>
										<tr>
											<th>时间</th>
											<th>内容</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="messageList" id="message">
											<s:if test="%{#message.flag==1}">
												<tr class="error">
													<td><s:property value="#message.date" /></td>
													<td><s:property value="#message.message" /></td>
												</tr>
											</s:if>
											<s:else>
												<tr>
													<td><s:property value="#message.date" /></td>
													<td><s:property value="#message.message" /></td>
												</tr>
											</s:else>

										</s:iterator>
									</tbody>
								</table>
							</s:else>


						</div>
						<div class="tab-pane " id="panel-5708">
							<div>
								<s:label>用户名：
									<s:property value="username"></s:property>
								</s:label>
							</div>
							<div>
								<s:label> 姓名：
									<s:property value="realName"></s:property>
								</s:label>
							</div>
							<div>
								<s:label> 邮箱：
									<s:property value="email"></s:property>
								</s:label>
							</div>
							<div>
								<s:label> 性别：
									<s:property value="gender"></s:property>
								</s:label>
							</div>
						</div>

					</div>
				</div>



			</div>
		</div>
	</div>


</body>
</html>