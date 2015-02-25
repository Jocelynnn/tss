<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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

											<li><a href="#">登出</a></li>
											<li class="divider"></li>
											<li><a href="#">链接3</a></li>
										</ul></li>
								</ul>
							</div>

						</div>
					</div>

				</div>
				<div class="tabbable" id="tabs-702235">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#panel-386299" data-toggle="tab">注册用户</a>
						</li>
						<li><a href="#panel-29008" data-toggle="tab">修改信息</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="panel-386299">
							<div>


								<form>
									<select class="combobox">
										<option>选择角色</option>
										<option value="2">教师</option>
										<option value="3">学生</option>
										<option value="5">教学负责人</option>
									</select>

									<script type="text/javascript">
										$(document).ready(function() {
											$('.combobox').combobox();
										});
									</script>
									<div class="control-group">
										<label class="control-label" for="inputUsername">用户名</label>
 										<div class="controls">
 											<input id="inputUsername" type="text" placeholder="username" />
 										</div>
 									</div>

									<div class="control-group">
										<label class="control-label" for="inputRealname">姓名</label>
										<div class="controls">
											<input id="inputRealname" type="text" placeholder="name" />
										</div>
									</div>

									<div class="control-group">
										<label class="control-label" for="inputPassword">密码</label>
										<div class="controls">
											<input id="inputPassword" type="password"
												placeholder="password" />
										</div>
									</div>
									<div class="control-group">
										<div class="controls">
											<button class="btn" type="submit">注册</button>
										</div>
									</div>
								</form>
							</div>


						</div>
						<div class="tab-pane" id="panel-29008">
							<form class="form-search">
								<input class="input-medium search-query" type="text" />
								<button type="submit" class="btn">查找用户</button>
							</form>
							<div id="searchResult" style="display:none;">
							 
							
							</div>
							
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>

</body>
</html>