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
								
								<ul class="nav pull-right">
									<li><a href="#">助教</a></li>
									<li class="divider-vertical"></li>
									<li class="dropdown"><a data-toggle="dropdown"
										class="dropdown-toggle" href="#">学生<strong class="caret"></strong></a>
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

				<div>
					<label>课程编号</label> <label>作业编号</label>

					<table class="table">
						<thead>
							<tr>
								<th>学生id</th>
								<th>作业文件</th>
								<th>分数</th>
								<th>点评</th>
								<th>批改状态</th>
								<th>审核状态</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Default</td>
								<td>something</td>
								<td>something</td>
								<td>已批改</td>
								<td>未通过</td>
							</tr>
							<tr class="success">
								<td>1</td>
								<td>Approved</td>
								<td>something</td>
								<td>something</td>
								<td>已批改</td>
								<td>已通过</td>
							</tr>
							<tr class="error">
								<td>2</td>
								<td>Declined</td>
								<td>something</td>
								<td>something</td>
								<td>已批改</td>
								<td>已通过</td>
							</tr>
							<tr class="warning">
								<td>3</td>
								<td>Pending</td>
								<td>something</td>
								<td>something</td>
								<td>已批改</td>
								<td>已通过</td>
							</tr>
							<tr class="info">
								<td>4</td>
								<td>Call in to confirm</td>
								<td>something</td>
								<td>something</td>
								<td>已批改</td>
								<td>已通过</td>
							</tr>
						</tbody>
					</table>


				</div>

			</div>
		</div>
	</div>

</body>
</html>