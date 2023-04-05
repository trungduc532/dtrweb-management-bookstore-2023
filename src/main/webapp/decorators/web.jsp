<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ"/></title>
<!-- css -->
<link href="<c:url value='/template/web/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/template/web/css/stype.css'/>" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- header -->
	<section class="py-5">
		<div class="container">
			<dec:body />
		</div>
	</section>

	<!--  footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!--  footer -->

	<script type="text/javascript"
		src="<c:url value='/template/web/jquery/jquery.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js'/>"></script>
</body>
</html>