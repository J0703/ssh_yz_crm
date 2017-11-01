<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/images/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<form action="${pageContext.request.contextPath}/staffSaveOrUpdate.action" method="post">
	
	<input type="hidden" name="staffId" value="${staff.staffId}"/>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><input type="text" name="loginName" value="${staff.loginName}" /> </td>
	    <td>密码：</td>
	    <td><input type="password" name="loginPwd" value="${staff.loginPwd}" /> </td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><input type="text" name="staffName" value="${staff.staffName}" /> </td>
	    <td>性别：</td>
	    <td>
	    	<input type="radio" name="gender" value="男"
				   <c:if test="${requestScope.staff.gender=='男'}">
					   checked='checked'
				   </c:if>
				    />男
	    	<input type="radio" name="gender" value="女"
					<c:if test="${requestScope.staff.gender=='女'}">
						checked='checked'
					</c:if>
				   />女
	    </td>
	  </tr>
	 <tr>
	    <td width="10%">所属部门：</td>
	    <td width="20%">
	    	<select name="post.department.depID" onchange="changePost(this)">
			    <option value="">----请--选--择----</option>
				<s:iterator value="#session.departments" var="depart">
					<option value="${depart.depID}"
					<c:if test="${staff.post.department.depID eq depart.depID}">
						selected="selected"
					</c:if>>${depart.depName}</option>
				</s:iterator>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000001" selected="selected">教学部</option>--%>
			    <%--<option value="ee050687bd1a4455a153d7bbb7000002">咨询部</option>--%>
			</select>

	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
	    	<select name="post.postId" id="postSelectId">
			    <option value="">----请--选--择----</option>
				<s:iterator value="#attr.staff.post.department.posts" var="post">
					<option value="${post.postId}"
							<c:if test="${staff.post.postId eq post.postId}">
								selected="selected"
							</c:if>>${post.postName}</option>
				</s:iterator>
			    <%--<option value="2c9091c14c78e58b014c78e6b34a0003">总监</option>--%>
			    <%--<option value="2c9091c14c78e58b014c78e6d4510004" selected="selected">讲师</option>--%>
				<script type="text/javascript">
					function createXMLHttpRequest() {
						try {
							return new XMLHttpRequest();
						} catch (e) {
							try {
								return new ActiveXObject("Msxml2.HTTP");
							} catch (e) {
								try {
									return new ActiveXObject("Microsoft.HTTP");
								} catch (e) {
									throw e;
								}
							}
						}
					}
					function changePost(obj) {

						var departId = obj.value;
						var httpRequest = createXMLHttpRequest();
						var url = "${pageContext.request.contextPath}/findPost.action";
						httpRequest.open("POST", url, true);
						httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
						httpRequest.send("depId=" + departId);
						httpRequest.onreadystatechange = function () {
							if (httpRequest.readyState == 4 && httpRequest.status == 200) {
								var jsonData = eval("(" + httpRequest.responseText + ")");
								var postSelect = document.getElementById("postSelectId");
								postSelect.innerHTML = "<option value='-1'>----请--选--择----</option>";
								for (var i = 0; i < jsonData.length; i++) {
									var id = jsonData[i].postId;
									var postName = jsonData[i].postName;
									postSelect.innerHTML += "<option value='" + id + "'>" + postName + "</option>";
								}
							}
						}

					}
				</script>
			</select>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<input type="text" name="onDutyDate" value="${staff.onDutyDate}" readonly="readonly" onfocus="c.showMoreDay=true; c.show(this);"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</form>

</body>
</html>
