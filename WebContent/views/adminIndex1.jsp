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

<script>
	function validate() {
		if (document.getElementById("username").value == "") {
			alert("Please enter user Name.");
			document.getElementById("username").focus();
			return false;
		}
		if (document.getElementById("password").value == "") {
			alert("Please enter password.");
			document.getElementById("password").focus();
			return false;
		}
		if (document.getElementById("role").value == -1) {
			alert("Please select role.");
			document.getElementById("role").focus();
			return false;
		}
		/* alert ( "Welcome User" );
		 */
		return true;
	}
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
									<li class="active"><a
										href="/tss/action/adminGetAllUser.action">用户管理</a></li>
									<li><a href="/tss/action/adminGetAllCourse.action">课程管理</a></li>


								</ul>
								<ul class="nav pull-right">
									<li><a href="#">管理员</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">admin<strong
											class="caret"></strong></a>
										<ul class="dropdown-menu">
											<li><a href="#">个人信息</a></li>
											<li><s:a href="/tss/action/logout.action">登出</s:a></li>
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
						<li><a href="#panel-29008" data-toggle="tab">注册新用户</a></li>

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
									<%
										String[] rows = { "success", "error", "warning", "info" };
									%>
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>用户名</th>
												<th>姓名</th>
												<th>密码</th>
												<th>email</th>
												<th>性别</th>
												<th>角色</th>
												<th>操作</th>
											</tr>
										</thead>
										<s:iterator value="users" id="user">
											<s:form action="/action/adminModifyUser" method="post">
												<tr>
													<td><s:textfield style="width: 100px" name="username"
															value="%{#user.username}"></s:textfield></td>
													<td><s:textfield style="width: 100px" name="realName"
															value="%{#user.realName}"></s:textfield></td>
													<td><s:textfield style="width: 100px" name="password"
															value="%{#user.password}"></s:textfield></td>
													<td><s:textfield style="width: 100px" name="email"
															value="%{#user.email}"></s:textfield></td>
													<td><s:textfield style="width: 100px" name="gender"
															value="%{#user.gender}"></s:textfield></td>
													<td><s:textfield style="width: 100px" name="role"
															value="%{#user.role}"></s:textfield></td>
													<td>
														<button class="btn" type="submit">保存</button>

													</td>
												</tr>
											</s:form>
										</s:iterator>
									</table>

								</div>

							</div>


						</div>
						<div class="tab-pane" id="panel-29008">
							<div>
								<s:form action="/action/adminAddUser" method="post"
									onsubmit="return validate();">

									<s:select headerKey="-1" headerValue="选择角色(必选)"
										list="#{'2':'授课教师', '3':'学生','4':'助教','5':'教学负责人'}"
										name="role" value="-1" id="role" />
									<div>
										<s:label>用户名(必填)</s:label>
										<s:textfield name="username" id="username"></s:textfield>
									</div>

									<div>
										<s:label>姓名</s:label>
										<s:textfield name="realName"></s:textfield>
									</div>

									<div>
										<s:label>密码(必填)</s:label>
										<s:password name="password" id="password"></s:password>
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

