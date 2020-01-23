<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="$pageContext.request.contextPath"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="author" content="Online Shopping System">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>home</title>

<!--<c:url value="/css/custom.css" var="myCss" /><link href="${myCss}" rel="stylesheet" > -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
</head>

<body >
  ${contextRoot}says ${greeting}
  <!-- Navigation Bar Section -->
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" >
          <span class="sr-only">Toggle Navigation</span>
          <span class="icon-bar"> </span>
          <span class="icon-bar"> </span>
          <span class="icon-bar"> </span>
          </button>
          <a class="navbar-brand" href="#">MOTECH SHOPPING CENTRE</a>
  
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav">
               <li> <a href="#">About Us</a> </li>
               <li> <a href="#">Service</a> </li>
               <li> <a href="#">Contact</a> </li>
               <li> <a href="#"></a> </li>
           </ul>
      </div>
  </nav>

 
</body>
</html>