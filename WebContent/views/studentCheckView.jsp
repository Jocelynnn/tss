<%@page import="tss.model.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="author" content="Shuaiqi Xia" />
<link rel="shortcut icon"
	href="<s:url value="/material/logo.ico"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrapTwo.css"></s:url>" />
<link rel="stylesheet" href="<s:url value="/css/customize.css"></s:url>" />
<link rel="stylesheet"
	href="<s:url value="/css/bootstrap-theme.min.css"></s:url>" />
<title>Club Statistics</title>
<%
	Data[] gradeData = (Data[]) request.getAttribute("gradeData");
%>
<script type="text/javascript"
	src="<s:url value="/js/jquery-1.11.0.js"></s:url>"></script>
<script type="text/javascript">
	$(function() {
		$('#container1')
				.highcharts(
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false
							},
							title : {
								text : '分数分布情况'
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										color : '#000000',
										connectorColor : '#000000',
										format : '<b>{point.name}</b>: {point.percentage:.1f} %'
									}
								}
							},
							series : [ {
								type : 'pie',
								name : 'Browser share',
								data : [ [ "<%=gradeData[0].getName()%>",parseFloat(<%=gradeData[0].getData()%>)],
										[ "<%=gradeData[1].getName()%>",parseFloat(<%=gradeData[1].getData()%>)] ]
							} ]
						});
	});
</script>

</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="<s:url value="/views/teachingManagerIndex.jsp"></s:url>"><img
					alt="logo" src="<s:url value="/img/logo.png"></s:url>" /></a>
			</div>
			<s:div cssClass="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<s:url value="/views/teachingManagerIndex.jsp"></s:url>">主页</a></li>
					<li><s:a action="courseAssignCheckAction" namespace="/action">课程作业情况</s:a></li>
					<li><s:a action="studentCheckAction" namespace="/action">学生情况</s:a></li>
					<li><s:a action="taAssignCheckAction" namespace="/action">助教情况</s:a></li>
					<li><s:a action="teacherAssignCheckAction" namespace="/action">教师情况</s:a></li>
				</ul>
			</s:div>
		</div>
	</div>
	<script src="<s:url value="/js/highcharts.js"></s:url>"></script>
	<script src="<s:url value="/js/modules/exporting.js"></s:url>"></script>
	<script src="<s:url value="/js/modules/data.js"></s:url>"></script>

	<div class="container">
		<div id="container1"
			style="min-width: 310px; height: 400px; margin: 0 auto"></div>
		<br>
	</div>
</body>
</html>
