<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style>
.quick-menu {
   position: fixed;
    top: 50%;
    right: 0;
    z-index: 101;
    box-sizing: border-box;
    width: 113px;
    opacity: 85%;
    border: 1px solid #e2e2e2;
    border-radius: 10px 0 0 10px;
    background: #fff;
    transform: translateY(-50%);
    padding-top: 30px;
    text-align: center;
}

.quickbar{
   font-color:black !important;
   list-style:none;
   font-size:small;
   padding:10px;
   
}
.quickbar>a{
   text-decoration:none;
}
.quickbar-ul{
padding:0;
}
</style>
</head>
<body>
	<div id="quick">
         <nav class="quick-menu" class="active">
            <ul class="quickbar-ul">
               <li class="quickbar"><a href="#">장바구니</a></li>
               <li class="quickbar"><a href="#">관심상품</a></li>
               <li class="quickbar"><a href="#">주문/배송</a></li>
               <li class="quickbar"><a href="#">문의내역</a></li>
               <li class="quickbar"><a href="#">top</a></li>
            </ul>
         </nav>
</div>
	
</body>
