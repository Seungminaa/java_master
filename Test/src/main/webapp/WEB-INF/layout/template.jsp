<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="author" content="Untree.co">
<link rel="shortcut icon" href="favicon.png">

<meta name="description" content="" />
<meta name="keywords" content="bootstrap, bootstrap4" />
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<!-- Bootstrap CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">
<link href="css/tiny-slider.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>middle Project</title>
<style>
	body>table{
		width: 100%; 
		border-style:none;
		border-spacing:0;
		padding:0;
	}
	td{
		border-spacing: 0px;
    	border-style: none;
    	padding: 0px;
	}

</style>
</head>
<body>
<tiles:insertAttribute name="quickmenu" />
<table id="tilesTable">
	<tr>
		<td colspan="3">
			<tiles:insertAttribute name="header" />
		</td>
	</tr>
	<tr>
		<td>
		</td>
		<td>
			<tiles:insertAttribute name="body" />
		</td>
	</tr>
	<tr>
		<td colspan="3" style="padding-top:250px;">
			<tiles:insertAttribute name="footer" />
		</td>
	</tr>
</table>
</body>
</html>
