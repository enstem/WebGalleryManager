<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: дмитро
  Date: 30.03.2018
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>



<c:if test="${!empty listPaintings }">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">Author</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPaintings}" var="painting">
            <tr>
                <td>${painting.id}</td>
                <td><a href="/paintingsdata/${painting.id}" target="_blank">${painting.paintingTitle}</a></td>
                <td>${painting.paintingAuthor}</td>
                <td>${painting.paintingPrice/100}${painting.paintingPrice%100}</td>
                <td><a href="<c:url value='/edit/${painting.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${painting.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Painting</h1>

<c:url var="addAction" value="/paintings/add"/>

<form:form action="${addAction}" commandName="painting">
    <table>
        <c:if test="${!empty painting.paintingTitle}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="paintingTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="paintingTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="paintingAuthor">
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <form:input path="paintingAuthor"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="paintingPrice">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="paintingPrice"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty painting.paintingTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit Painting"/>"/>
                </c:if>
                <c:if test="${empty painting.paintingTitle}">
                    <input type="submit"
                           value="<spring:message text="Add Painting"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
