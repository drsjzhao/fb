<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=”zh”> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=”zh”> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=”zh”> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang=”zh”>
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>TOUFU (v1.0.0)</title>
<meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<%@ include file="./commons/runParams.html"%>
<link href="../assets/library/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="../assets/plugins/nprogress/nprogress.css" rel="stylesheet">
<link
	href="../assets/library/icons/pictoicons/css/picto-foundry-medical-science.css"
	rel="stylesheet">
<link
	href="../assets/library/icons/pictoicons/css/picto-foundry-general.css"
	rel="stylesheet">
<link
	href="../assets/library/icons/glyphicons/assets/css/glyphicons_regular.css"
	rel="stylesheet">
<link href="../assets/css/frame.css" rel="stylesheet">
<!--<link href="../assets/css/pat_list.css" rel="stylesheet">-->
<!--[if lt IE 9]>
            <script src="../assets/library/respond/respond.js"></script>
        <![endif]-->
<script src="../assets/library/modernizr/modernizr.js"></script>
<style>
.navTabs {
	border-bottom: 1px solid #E5E5E5;
	background: #fff;
	height: 39px;
	display: block;
	margin: 0;
	padding: 0px;
}

.navTabs li {
	float: left;
	height: 39px;
	list-style: none;
	width: 33%;
}

.navTabs li a {
	height: 39px;
	width: 78px;
	margin: 0 auto;
	display: block;
	line-height: 39px;
	text-align: center;
	color: #333;
}

.navTabs li a:hover {
	text-decoration: none;
}

.navTabs li.active a {
	color: #4098DF;
	border-bottom: 2px solid #4098DF;
}

#content {
	background: #F2F2F2;
}

.toux {
	text-align: center;
	padding: 50px 0 40px 0;
}

.toux img {
	width: 360px;
	height: 360px;
	border-radius: 75px;
}

.personInfo {
	text-align: center;
}

.personInfo p {
	font-size: 16px;
	color: #666;
	line-height: 25px;
}

.personInfo p span {
	padding-right: 20px;
}

.personInfo .line1 span {
	font-size: 24px;
	color: #000;
}

.mainCon {
	padding-left: 50px;
	display: inline-block
}

.mainTitle {
	text-align: center;
	padding: 5px 0 5px 0;
}

.outDiv {
	text-align: center;
}

/*响应式样式*/
@media ( min-width :100px) and (max-width:768px) {
	.toux img {
		width: 150px;
		height: 150px;
		border-radius: 75px;
	}
}
</style>
</head>
<body>
	<!--[if lt IE 7]>
            <p style="margin:0.2em 0;background:#ccc;color:#000;padding:0.2em 0;">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<div class="container-fluid">
		<div class="mainTitle">
			<h1>Which girl is more beautiful!</h1>
		</div>
		<div class="outDiv">
			<c:forEach items="${personList}" var="person" varStatus="status">
				<div class="mainCon">
					<div class="toux">
						<a href="${mainUrl}winner?winner_index=${status.index}"
							title="i want you"> <img src="${person.head}" />
						</a>
					</div>
					<div class="personInfo">
						<p class="line1">
							<span>${person.name}</span>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>


	<script src="../assets/library/jquery/jquery.min.js"></script>
	<script src="../assets/library/jquery/jquery-migrate.min.js"></script>
	<script src="../assets/library/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/plugins/nicescroll/jquery.nicescroll.min.js"></script>
	<script src="../assets/plugins/nprogress/nprogress.js"></script>
	<script src="../assets/script/frame.js"></script>
</body>
</html>