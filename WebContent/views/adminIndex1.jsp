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
									<li class="active"><a
										href="<%=request.getContextPath()%>/views/adminIndex1.jsp">用户管理</a></li>
									<li><a
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
											<li><s:a href="logout.action">登出</s:a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>
				<div class="tabbable" id="tabs-702235">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-386299" data-toggle="tab">修改信息</a>
						</li>
						<li><a href="#panel-29008" data-toggle="tab">注册用户</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-386299">
							<div>
								<s:form class="form-search" action="/action/adminSearchUser">
									<input class="input-medium search-query" name="searchkey"
										type="text" />
									<button type="submit" class="btn">查找用户</button>
								</s:form>

								<div id="searchResult">
									<table class="table">
										<thead>
											<tr>
												<th>用户名</th>
												<th>姓名</th>
												<th>email</th>
												<th>性别</th>
												<th>角色</th>
											</tr>
										</thead>
										<s:iterator value="users" id="user">
											<tr>
												<td><s:property value="#user.username" /></td>
												<td><s:property value="#user.realName" /></td>
												<td><s:property value="#user.email" /></td>
												<td><s:property value="#user.gender" /></td>
												<td><s:property value="#user.role" /></td>

											</tr>
										</s:iterator>
									</table>
								</div>

							</div>


						</div>
						<div class="tab-pane" id="panel-29008">
							<div>
								<s:form action="/action/adminAddUser" method="post">

									<s:select headerKey="-1" headerValue="选择角色"
										list="#{'2':'授课教师', '3':'学生','4':'助教','5':'教学负责人'}"
										name="role" value="-1" />
									<div>
										<s:label>用户名</s:label>
										<s:textfield name="username"></s:textfield>
									</div>

									<div>
										<s:label>姓名</s:label>
										<s:textfield name="realName"></s:textfield>
									</div>

									<div>
										<s:label>密码</s:label>
										<s:password name="password"></s:password>
									</div>

									<div>
										<s:label>邮箱</s:label>
										<s:textfield name="email"></s:textfield>
									</div>
									<s:select headerKey="-1" headerValue="选择性别"
										list="#{'1':'男', '2':'女'}" name="gender" value="-1" />
									<div>
										<button class="btn" type="submit">注册</button>
									</div>
									<%-- <label  for="username">用户名</label>
											<input id="username" type="text" placeholder="username" />

										<label class="control-label" for="realName">姓名</label>
										<div class="controls">
											<input id="realName" type="text" placeholder="name" />
										</div>

										<label class="control-label" for="password">密码</label>
										<div class="controls">
											<input id="password" type="password" placeholder="password" />
										</div>

										<label class="control-label" for="email">E-mail</label>
										<div class="controls">
											<input id="email" type="text" placeholder="email" />
										</div>

										<s:select headerKey="-1" headerValue="选择性别"
											list="#{'1':'男', '2':'女'}" name="gender" value="-1" />

										<div class="controls">
											<button class="btn" type="submit">注册</button>
										</div> --%>
								</s:form>
							</div>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>

</body>
</html>

