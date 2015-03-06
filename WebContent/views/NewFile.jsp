<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
.panama_table
{
    font-size:12px;
    font-weight:light;
}
.panama_table_row_odd
{
    
}
.panama_table_row_even
{
    background-color:gray;
    color: white;
}
.panama_table_cell
{
    width:80px;
    height:28px;
    text-align:center;
    cursor: pointer;
}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/net.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/panama_table.js"></script>

</head>
<body onload="PanamaTableInit()">

<table cellpadding="2px" cellspacing="0px" style="font-size:12px;font-weight:light">
<tr>
    <td><input type="checkbox" onclick="PanamaTableSelAll()" />全选/取消</td>
    <td><a href="javascript:PanamaTableAppendRow()">添加行</a></td>
    <td><a href="javascript:PanamaTableDeleteRow()">删除行</a></td>
    <td><a href="javascript:PanamaTableSave()">保存</a></td>
</tr>
</table>
<div style="width:300px"><hr /></div>
<table cellpadding="4" cellspacing="0" class="panama_table" id="panama_table" >
<tr><td><input type="checkbox" /></td><td>郭佳</td><td>陈珩</td><td>王赢</td></tr>
<tr><td><input type="checkbox" /></td><td>蔡一</td><td>覃晖</td><td>彭杉</td></tr>
<tr><td><input type="checkbox" /></td><td>杨莉</td><td>李英海</td><td>杜宽</td></tr>
</table>

</body>
</html>