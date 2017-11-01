<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>

</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[部门管理]</td>

        <td width="57%" align="right">
            <%--添加部门 --%>
            <a href="${pageContext.request.contextPath}/pages/department/addOrEditDepartment.jsp">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>
<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1">

    <tr class="henglan" style="font-weight:bold;">
        <td width="6%" align="center">部门名称</td>
        <td width="7%" align="center">编辑</td>
    </tr>
    <s:iterator value="#attr.pb.beanList" var="department" status="st">
        <s:if test="#st.Even">
            <tr class="tabtd1">
        </s:if>
        <s:else>
            <tr class="tabtd2">
        </s:else>
        <td align="center">${department.depName}</td>
        <td width="7%" align="center">
            <a href="${pageContext.request.contextPath}/departById.action?depID=${department.depID}">
                <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
        </td>
        </tr>
    </s:iterator>

</table>


<table border="0" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td align="right">

            <span>
            第${pb.pc}页/共${pb.tp}页
            <a href="department.action">[首页]</a>
            <c:if test="${pb.pc > 1}">
                <a href="department.action?pc=${pb.pc-1}">[上一页]</a>
            </c:if>

            <c:choose>
                <c:when test="${pb.tp <= 10}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="${pb.tp}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${pb.pc-5}"/>
                    <c:set var="end" value="${pb.pc+4}"/>
                    <%-- 头溢出 --%>
                    <c:if test="${begin < 1}">
                        <c:set var="begin" value="1"/>
                        <c:set var="end" value="10"/>
                    </c:if>
                    <%-- 尾溢出 --%>
                    <c:if test="${end > pb.tp}">
                        <c:set var="begin" value="${pb.tp - 9}"/>
                        <c:set var="end" value="${pb.tp}"/>
                    </c:if>
                </c:otherwise>
            </c:choose>
	<c:forEach var="i" begin="${begin}" end="${end}">
        <c:choose>
            <c:when test="${pb.pc eq i}">
                [${i}]
            </c:when>
            <c:otherwise>
                <a href="department.action?pc=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>



<c:if test="${pb.pc < pb.tp}">
    <a href="department.action?pc=${pb.pc+1}">[下一页]</a>
</c:if>
  <a href="department.action?pc=${pb.tp}">[尾页]</a>
        </span>
        </td>
    </tr>
</table>
</body>
</html>
