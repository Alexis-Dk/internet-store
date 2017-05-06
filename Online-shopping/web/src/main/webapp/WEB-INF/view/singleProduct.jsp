<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>
<!DOCTYPE html>
<html>
<head>

    <c:set var="context" value="${pageContext.request.contextPath}" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eElectronics - HTML eCommerce Template</title>

<script>
    function setParam(name, value) {
        var l = window.location;

        /* build params */
        var params = {};        
        var x = /(?:\??)([^=&?]+)=?([^&?]*)/g;        
        var s = l.search;
        for(var r = x.exec(s); r; r = x.exec(s))
        {
            r[1] = decodeURIComponent(r[1]);
            if (!r[2]) r[2] = '%%';
            params[r[1]] = r[2];
        }

        /* set param */
        params[name] = encodeURIComponent(value);

        /* build search */
        var search = [];
        for(var i in params)
        {
            var p = encodeURIComponent(i);
            var v = params[i];
            if (v != '%%') p += '=' + v;
            search.push(p);
        }
        search = search.join('&');

        /* execute search */
        l.search = search;
    }
</script>

              <meta http-equiv=Content-Type content="text/html;charset=UTF-8">
              <title>Payments system</title>
              <link rel="stylesheet" href="resources/styles/bootstrap.css">
              <link rel="stylesheet" href="resources/styles/style.css">
              <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
              <link href='http://fonts.googleapis.com/css?family=Titillium+Web:4col-sm-60,200,300,700,600' rel='stylesheet' type='text/css'>
              <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
              <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

              <!-- Bootstrap -->
              <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

              <!-- Font Awesome -->
              <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

              <!-- Custom CSS -->
              <link rel="stylesheet" href="<c:url value="/css/owl.carousel.css" />" rel="stylesheet">
              <link rel="stylesheet" href="<c:url value="/css/styleMain.css" />" rel="stylesheet"> 
              <link rel="stylesheet" href="<c:url value="/css/responsive.css" />" rel="stylesheet"> 

              <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
              <script src="js/payments.js"> </script>
	  <style>
		.letter {
		    text-transform: uppercase;
		}
	  </style>
</head>
<body> 
    <div class="header-area">
        <div class="container">
            <div class="row">

                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <sec:authorize access="isAnonymous()">
                          		    <li><a href="registration"><i class="fa fa-user"></i> <locale:message code="label.registration"/></a></li>
	                          	    <li><a href="${context}/login"><i class="fa fa-heart"></i> <locale:message code="label.login"/></a></li>
                             </sec:authorize>
	  						 <sec:authorize access="isAuthenticated()">  
		                            <li><a href="ViewItemsOfCart"><i class="fa fa-user"></i>  <locale:message code="label.mycart"/></a></li>
		                            <li><a href="logout"><i class="fa fa-user"></i> <locale:message code="label.logout"/></a></li>
         					 </sec:authorize>	
                        </ul>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key"></span><span class="letter">${pageContext.response.locale} </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:setParam('lang', 'en');" id="baseUrl"><input type="text" value="" id="appendUrl" hidden="true"/><locale:message code="label.languageFull1"/></a></li>
                                    <li><a href="javascript:setParam('lang', 'fr');" id="baseUrl"><input type="text" value="" id="appendUrl" hidden="true"/><locale:message code="label.languageFull2"/></a></li>
                                    <li><a href="javascript:setParam('lang', 'ru');" id="baseUrl"><input type="text" value="" id="appendUrl" hidden="true"/><locale:message code="label.languageFull3"/></a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End header area -->
    
        <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="index">e<span><locale:message code="label.electronics"/></span></a></h1>
                    </div>
                </div>
                <div class="col-sm-6">
                       <c:forEach items="${requestScope.quantitiAndSum}" var="quantitiAndSum">
                			<sec:authorize access="isAuthenticated()"> 
	                    		<div class="shopping-item">
	                      			 <a href="ViewItemsOfCart.html"><locale:message code="label.cart"/> - <span class="cart-amunt"><c:out value="${quantitiAndSum.sum}"></c:out></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><c:out value="${quantitiAndSum.quantity}"></c:out></span></a>
	                  		     </div>
                    		</sec:authorize>
                    	</c:forEach> 
                </div>
            </div>
        </div>
    </div> <!-- End site branding area -->
    
    <div class="mainmenu-area">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index"><locale:message code="label.home"/></a></li>
                          	<c:forEach items="${requestScope.productCategory}" var="category">
			                    <li><a href="product?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
                            </c:forEach>
                            <sec:authorize access="isAuthenticated()">
                         		<li><a href="ViewItemsOfCart"><locale:message code="label.cart"/></a></li>
                         	</sec:authorize>
                        <li><a href="contact"><locale:message code="label.contact"/></a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
    
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2><locale:message code="label.shop"/></h2>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<img src="img/<%=request.getParameter("imagePath")%>" alt="">
			<table class="table">
				<tr ${categoryCharacteristicEnableIntStatus1}>
					<td><p class="user-menuMy">${categoryCharacteristicIntLang1}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("intCharacteristic1")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableIntStatus2}>
					<td><p class="user-menuMy">${categoryCharacteristicIntLang2}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("intCharacteristic2")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableIntStatus3}>
					<td><p class="user-menuMy">${categoryCharacteristicIntLang3}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("intCharacteristic3")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableIntStatus4}>
					<td><p class="user-menuMy">${categoryCharacteristicIntLang4}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("intCharacteristic4")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableIntStatus5}>
					<td><p class="user-menuMy">${categoryCharacteristicIntLang5}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("intCharacteristic5")%></h3></td>
				</tr>
				<tr>
					<td><p class="user-menuMy">Model</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("description")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus1}>
					<td><p class="user-menuMy">${categoryCharacteristicStrLang1}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic1")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus2}>
					<td><p class="user-menuMy">${categoryCharacteristicStr2.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic2")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus3}>
					<td><p class="user-menuMy">${categoryCharacteristicStr3.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic3")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus4}>
					<td><p class="user-menuMy">${categoryCharacteristicStr4.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic4")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus5}>
					<td><p class="user-menuMy">${categoryCharacteristicStr5.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic5")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus6}>
					<td><p class="user-menuMy">${categoryCharacteristicStr6.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic6")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableStrStatus7}>
					<td><p class="user-menuMy">${categoryCharacteristicStr7.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("characteristic7")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableBoolStatus1}>
					<td><p class="user-menuMy">${categoryCharacteristicBool1.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("boolCharacteristic1")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableBoolStatus2}>
					<td><p class="user-menuMy">${categoryCharacteristicBool2.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("boolCharacteristic2")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableBoolStatus3}>
					<td><p class="user-menuMy">${categoryCharacteristicBool3.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("boolCharacteristic3")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableBoolStatus4}>
					<td><p class="user-menuMy">${categoryCharacteristicBool4.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("boolCharacteristic4")%></h3></td>
				</tr>
				<tr ${categoryCharacteristicEnableBoolStatus5}>
					<td><p class="user-menuMy">${categoryCharacteristicBool5.categoryCharacteristicNameLanguageOne}</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("boolCharacteristic5")%></h3></td>
				</tr>
<%--  				<tr>
					<td><p class="user-menuMy">Stock availability</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("stockStatus")%></h3></td>
				</tr>
				<tr>
					<td><p class="user-menuMy">Rating</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("rating")%></h3></td>
				</tr>
				<tr>
					<td><p class="user-menuMy">Price</p></td>
					<td><p class="user-menuMy" />
						<h3><%=request.getParameter("price")%></h3></td>
				</tr> --%>
			</table>

			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="single-shop-product">
						<div class="product-upper"></div>
						<h2>
							<a href=""></a>
						</h2>
						<sec:authorize access="isAuthenticated()">
							<div class="product-option-shop">
								<a class="add_to_cart_button" data-quantity="1"
									data-product_sku="" data-product_id="70" rel="nofollow"
									href="${context}/addNewProductToCart?
description=<%=request.getParameter("description")%>
&name=<%=request.getParameter("name")%>
&characteristic1=<%=request.getParameter("characteristic1")%>
&characteristic2=<%=request.getParameter("characteristic2")%>
&characteristic3=<%=request.getParameter("characteristic3")%>
&characteristic4=<%=request.getParameter("characteristic4")%>
&characteristic6=<%=request.getParameter("characteristic6")%>
&characteristic7=<%=request.getParameter("characteristic7")%>
&rating=<%=request.getParameter("rating")%>
&stockStatus=<%=request.getParameter("stockStatus")%>
&imagePath=<%=request.getParameter("imagePath")%>
&price=<%=request.getParameter("price")%>
&productId=<%=request.getParameter("productId")%>">Add
									to cart</a>
							</div>
						</sec:authorize>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12"></div>
			</div>
		</div>
	</div>

	<div class="footer-top-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="footer-about-us">
                        <h2>e<span><locale:message code="label.electronics"/></span></h2>
                        <p><locale:message code="label.eElectronics"/></p>
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title"><locale:message code="label.userNavigation"/> </h2>
                        <ul>
                            <sec:authorize access="isAnonymous()">
                          		    <li><a href="registration"><i class="fa fa-user"></i> <locale:message code="label.registration"/></a></li>
	                          	    <li><a href="${context}/login"><i class="fa fa-heart"></i> <locale:message code="label.login"/></a></li>
                             </sec:authorize>
	  						 <sec:authorize access="isAuthenticated()">  
		                            <li><a href="ViewItemsOfCart"><i class="fa fa-user"></i> <locale:message code="label.mycart"/></a></li>
		                            <li><a href="logout"><i class="fa fa-user"></i> <locale:message code="label.logout"/></a></li>
         					 </sec:authorize>	
                        </ul>                              
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title"><locale:message code="label.categories"/></h2>
                        <ul>
                          	<c:forEach items="${requestScope.productCategory}" var="category">
			                    <li><a href="product?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
                            </c:forEach>
                        </ul>                        
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">

                </div>
            </div>
        </div>
    </div> <!-- End footer top area -->

    <div class="footer-bottom-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="copyright">
                        <p>&copy; <locale:message code="label.footer1"/> <i class="fa fa-heart"></i> <locale:message code="label.footer2"/></p>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="footer-card-icon">
                        <i class="fa fa-cc-discover"></i>
                        <i class="fa fa-cc-mastercard"></i>
                        <i class="fa fa-cc-paypal"></i>
                        <i class="fa fa-cc-visa"></i>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End footer bottom area -->


</body>
</html>
