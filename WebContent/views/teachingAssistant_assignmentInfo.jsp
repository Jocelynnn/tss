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
<script type="text/javascript">
	//<![CDATA[
	var JCRUD = function(tb, colnum, saveAllBtn, add, ajaxSaver, allAjaxSaver,
			ajaxDeler) {
		var del = tb.getElementsByTagName('a');
		var span = tb.getElementsByTagName('span');
		var ctr = [];/* 保存修改的tr对象 */
		var delEvent = function() {
			var dder = this.parentNode.parentNode;
			this.data = [];
			for (var i = 0; i < dder.children.length - 1; i++)
				this.data[i] = dder.children[i].children[0].firstChild.nodeValue;
			var tag = 0;
			for (var j = 0; j < this.data.length; j++) {
				if (this.data[j] !== 'null') {/* 如果修改了单元格的默认值，这里也做相应修改 */
					tag = 1;
					break;
				}
			}
			for (var k = 0; k < ctr.length; k++)
				if (ctr[k] === dder)
					ctr.splice(k, 1);
			dder.parentNode.removeChild(dder);
			if (tag == 1)
				ajaxDeler.call(this);
		};
		var spanEvent = function() {/* 点击生成修改框 */
			var value = this.firstChild.nodeValue;
			var input = document.createElement('input');
			input.value = value;
			this.parentNode.appendChild(input);
			this.parentNode.removeChild(this);
			input.focus();
			input.onblur = function() {/* 失去焦点移除修改框 */
				var span = document.createElement('span');
				span.appendChild(document
						.createTextNode(this.value ? this.value : 'null'));/* 如果修改了单元格的默认值，这里也做相应修改 */
				span.onclick = spanEvent;
				this.parentNode.appendChild(span);
				this.parentNode.removeChild(this);
				if (value != this.value) {/* 如果内容改变生成保存按钮 */
					var tr = span.parentNode.parentNode
					tds = tr.children;
					btns = tds[colnum - 1].getElementsByTagName('a');
					for (var i = 0; i < btns.length; i++) {
						if (btns[i].firstChild.nodeValue != '保存') {
							var saver = document.createElement('a');
							saver.href = "javascript:;";
							saver.appendChild(document.createTextNode('保存'));
						} else {
							var saver = btns[i];
						}
					}
					tds[tds.length - 1].appendChild(saver);
					var tag = 0;
					for (var k = 0; k < ctr.length; k++)
						if (ctr[k] === tr)
							tag = 1;
					if (tag == -0)
						ctr.push(tr);
					saver.onclick = function() {/* 添加保存处理事件 */
						this.data = [];
						for (var i = 0; i < tds.length - 1; i++)
							this.data[i] = this.parentNode.parentNode.children[i].children[0].firstChild.nodeValue;
						ajaxSaver.call(this);
						for (var i = ctr.length - 1; i >= 0; i--) {
							if (this.parentNode.parentNode === ctr[i]) {
								ctr.splice(i, 1);
							}
						}
						this.parentNode.removeChild(this);
					};
				}
			}
		};
		for ( var i in del)
			del[i].onclick = delEvent;/* 给现在有元素添加事件 */
		for ( var j in span)
			span[j].onclick = spanEvent;
		add.onclick = function() {
			var tbody = tb.children[0];
			var tr = document.createElement('tr');
			for (var j = 0; j < colnum; j++) {
				var td = document.createElement('td');
				if (j == (colnum - 1)) {
					var del = document.createElement('a');
					del.href = 'javascript:;';
					del.appendChild(document.createTextNode('删除'));
					del.onclick = delEvent;/* 给新加元素添加事件 */
					td.appendChild(del);
				} else {
					var span = document.createElement('span');
					span.appendChild(document.createTextNode('null'));/* 如果在添加时修改默认值，在这里修改的 */
					td.appendChild(span);
					span.onclick = spanEvent;
				}
				tr.appendChild(td);
			}
			tbody.appendChild(tr);
		};
		var getAllData = function() {/* 保存全部的数据解析 */
			var allData = [];
			for (var i = 0; i < ctr.length; i++) {
				allData[i] = [];
				for (var j = 0; j < ctr[i].children.length - 1; j++)
					allData[i]
							.push(ctr[i].children[j].children[0].firstChild.nodeValue);
				ctr[i].children[colnum - 1]
						.removeChild(ctr[i].children[colnum - 1].children[1]);
			}
			ctr = [];
			return allData;
		};
		saveAllBtn.onclick = function() {/* 添加保存全部数据保存事件 */
			this.allData = getAllData();
			if (this.allData.length) {
				allAjaxSaver.call(this);
			} else {
				alert('No data!');
			}
		};
		window.onbeforeunload = function() {/* 刷新提示保存数据 */
			if (ctr.length) {
				var y = confirm('数据还未保存，是否保存数据？')
				if (y) {
					saveAllBtn.click();
				}
			}
		};
	};
	window.onload = function() {
		var table = document.getElementById('tb'), /* 要操作的表格 */
		colnum = 5, /* 这里修改表格的列数 */
		saveAllBtn = document.getElementById('SaveAll'), /* 保存全部的按钮 */
		addBtn = document.getElementById('Add'), /* 添加的按钮 */
		saver = function() {
			/* 此处可以加上ajax效果与数据库交互 data是个数组，需要可以改成JSON */
			alert('要传的数据为data数据："' + this.data + '"此处调用ajax实现后台保存！实现略……');
		}, allSaver = function() {
			/* 此处可以加上ajax效果与数据库交互 data是个数组，需要可以改成JSON */
			alert('要传的数据为allDtat数组："' + this.allData + '"此处调用ajax实现后台保存！实现略……');
		}, deler = function() {
			/* 此处可以加上ajax效果与数据库交互 data是个数组，需要可以改成JSON */
			alert('要传的数据为data数据："' + this.data + '"此处调用ajax实现后台删除！实现略……');
		};
		window.JCRUD(table, colnum, saveAllBtn, addBtn, saver, allSaver, deler);
	};
	//]]>
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
												<th>批改人</th>
												<th>分数</th>
												<th>评价</th>
												<th>教师审核</th>
											</tr>
										</thead>
										<s:iterator value="unpassedSubmissionList" id="submission">
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