<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>
<!DOCTYPE html>
<html lang="en">
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
              <title>Internet-shop</title>
              <link rel="stylesheet" href="/css/style.css">
              <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
              <link href='https://fonts.googleapis.com/css?family=Titillium+Web:4col-sm-60,200,300,700,600' rel='stylesheet' type='text/css'>
              <link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
              <link href='https://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

              <!-- Bootstrap -->
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

              <!-- Font Awesome -->
              <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

              <!-- Custom CSS -->
              <link rel="stylesheet" href="<c:url value="/css/owl.carousel.css" />" rel="stylesheet">
              <link rel="stylesheet" href="<c:url value="/css/styleMain.css" />" rel="stylesheet"> 
              <link rel="stylesheet" href="<c:url value="/css/responsive.css" />" rel="stylesheet"> 

              <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
              <script src="js/customMenu.js"> </script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]   response.sendRedirect("login.jsp"); %>   -->
  </head>
  <style>
	.letter {
	    text-transform: uppercase;
	}
  </style>
  <body>

<%!String [] dataUsers = {"", "", ""};	%>
<%Authentication auth = SecurityContextHolder.getContext().getAuthentication();
String line = auth.getPrincipal().toString(); //get logged in username 
String [] dataUsers2 = line.split(" "); 
if (dataUsers2.length!=1){
	dataUsers = line.split(" ");}
else {
	dataUsers[0] = "";
	dataUsers[1] = "";
	dataUsers[2] = "";
}
%>
    <sec:authorize access="hasRole('admin')">
   		<sec:authentication property="principal"/>
 		<h3> This information is viewed only for users with admin role: <%=dataUsers[0]  %> <%=dataUsers[1]  %> <%=dataUsers[2]  %></h3>
	</sec:authorize>

		<div class="rigthPart">
			<c:if test="${infoMessage ne null}">
				<div class="alert alert-info" role="alert">
					${infoMessage}	
				</div>
			</c:if>
		</div>

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
		                            <li><a href="ViewItemsOfCart"><i class="fa fa-user"></i> <locale:message code="label.mycart"/></a></li>
		                            <li><a href="logout"><i class="fa fa-user"></i> <locale:message code="label.logout"/></a></li>
         					 </sec:authorize>		                    
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                        
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key"><locale:message code="label.currency"/>:</span><span class="value"><c:out value="${currentCurrency}"></c:out> </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">${currentCurrency}</a></li>
                                </ul>
                            </li> 

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
                			<sec:authorize access="hasRole('user') or isAnonymous()"> 
	                    		<div class="shopping-item">
	                      			 <a href="ViewItemsOfCart.html"><locale:message code="label.cart"/> - <span class="cart-amunt">${currentCurrencySymbol}<c:out value="${quantitiAndSum.sum}"></c:out></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><c:out value="${quantitiAndSum.quantity}"></c:out></span></a>
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
                        <li class="active"><a href="index"><locale:message code="label.home"/></a></li>
			       		<sec:authorize access="hasRole('admin')">
							<li><a href="addCategory">Add category</a></li>
	  					</sec:authorize>
	  					<sec:authorize access="hasRole('admin')">
							<li><a href="parametrizeTemplateStep0">Parametrize template</a></li>
	  					</sec:authorize>
<%-- 	  		            <sec:authorize access="hasRole('admin')">
	                        <c:forEach items="${requestScope.productCategory}" var="category">
				            	<li class="<c:out value="${category.selectedItem}"></c:out>"><a href="categoryCharacteristic?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
				            </c:forEach>
	            		</sec:authorize> --%>
                       	<sec:authorize access="hasRole('admin')">
							<li><a href="new">Add product</a></li>
	  					</sec:authorize>
                       	<sec:authorize access="isAnonymous() or hasRole('user')">
		                    <c:forEach items="${requestScope.productCategory}" var="category">
				            	<li class="<c:out value="${category.selectedItem}"></c:out>"><a href="product?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
				            </c:forEach>
			           	</sec:authorize>
			           	<sec:authorize access="hasRole('admin')">
		                    <c:forEach items="${requestScope.productCategory}" var="category">
				            	<li class="<c:out value="${category.selectedItem}"></c:out>"><a href="productAdmin?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
				            </c:forEach>
			           	</sec:authorize>
<%-- 	  				<sec:authorize access="isAnonymous() or hasRole('user')"> --%>			           		
	  					<sec:authorize access="hasRole('user') or isAnonymous()">
                         	<li><a href="ViewItemsOfCart"><locale:message code="label.cart"/></a></li>
                        </sec:authorize>
                        <sec:authorize access="isAnonymous() or hasRole('user')">
                        <li><a href="contact"><locale:message code="label.contact"/></a></li>
                        </sec:authorize>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
    
    <div class="slider-area">
        <div class="zigzag-bottom"></div>
        <div id="slide-list" class="carousel carousel-fade slide" data-ride="carousel">
            
            <div class="slide-bulletz">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <ol class="carousel-indicators slide-indicators">
                                <li data-target="#slide-list" data-slide-to="0" class="active"></li>
                                <li data-target="#slide-list" data-slide-to="1"></li>
                                <li data-target="#slide-list" data-slide-to="2"></li>
                            </ol>                            
                        </div>
                    </div>
                </div>
            </div>

            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <div class="single-slide">
                        <div class="slide-bg slide-one"></div>
                        <div class="slide-text-wrapper">
                            <div class="slide-text">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-6">
                                            <div class="/index?lang=frcontent">
                                                <h2><locale:message code="label.WeAreAwesome"/></h2>
													<p><locale:message code="label.eElectronics1"/></p>
                                                <a href="" class="readmore"><locale:message code="label.LearnMore"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="single-slide">
                        <div class="slide-bg slide-two"></div>
                        <div class="slide-text-wrapper">
                            <div class="slide-text">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-6">
                                            <div class="slide-content">
                                                <h2><locale:message code="label.WeAreGreat"/></h2>
                                                <p><locale:message code="label.eElectronics2"/></p>
                                                <a href="" class="readmore"><locale:message code="label.LearnMore"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="single-slide">
                        <div class="slide-bg slide-three"></div>
                        <div class="slide-text-wrapper">
                            <div class="slide-text">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-md-offset-6">
                                            <div class="slide-content">
                                                <h2><locale:message code="label.WeAreSuperb"/></h2>
                                                <p><locale:message code="label.eElectronics3"/></p>
                                                <a href="" class="readmore"><locale:message code="label.LearnMore"/></a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>        
    </div> <!-- End slider area -->

    <div class="promo-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-refresh"></i>
                        <p><locale:message code="label.30DaysReturn"/></p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-truck"></i>
                        <p><locale:message code="label.FreeShipping"/></p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-lock"></i>
                        <p><locale:message code="label.SecurePayments"/></p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="single-promo">
                        <i class="fa fa-gift"></i>
                        <p><locale:message code="label.NewProducts"/></p>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End promo area -->
    
    <div class="maincontent-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="latest-product">
                        <h2 class="section-title">Latest Products</h2>
                            <div class="product-carousel">
                                <c:forEach items="${requestScope.latestProducts}" var="latestProducts">
                                    <div class="single-product">
                                        <div class="product-f-image">
                                            <img src="img/<c:out value="${latestProducts.image1Path}"></c:out>" alt="">
                                            <div class="product-hover">
                                                <a href="${context}/addNewProductToCart?
description=<c:out value="${latestProducts.description}"></c:out>
&name=<c:out value="${latestProducts.name}"></c:out>
&characteristic1=<c:out value="${latestProducts.characteristic1}"></c:out>
&characteristic2=<c:out value="${latestProducts.characteristic2}"></c:out>
&characteristic3=<c:out value="${latestProducts.characteristic3}"></c:out>
&characteristic4=<c:out value="${latestProducts.characteristic4}"></c:out>
&characteristic6=<c:out value="${latestProducts.characteristic6}"></c:out>
&characteristic7=<c:out value="${latestProducts.characteristic7}"></c:out>
&rating=<c:out value="${latestProducts.rating}"></c:out>
&stockStatus=<c:out value="${latestProducts.stockStatus}"></c:out>
&image1Path=<c:out value="${latestProducts.image1Path}"></c:out>
&price=<c:out value="${latestProducts.intCharacteristic1}"></c:out>
&productId=<c:out value="${latestProducts.productId}"></c:out>"
                                                    class="add-to-cart-link">
                                                    <i class="fa fa-shopping-cart"></i>
                                                    Add to cart
                                                </a>
                                                <a href="#" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                            </div>
                                        </div>

                                        <h2>
                                            <a href="singleProduct?description=<c:out value="${latestProducts.description}"></c:out>
&comment=<c:out value="${latestProducts.comment}"></c:out>
&name=<c:out value="${latestProducts.name}"></c:out>
&intCharacteristic1=<c:out value="${latestProducts.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${latestProducts.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${latestProducts.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${latestProducts.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${latestProducts.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${latestProducts.characteristic1}"></c:out>
&characteristic2=<c:out value="${latestProducts.characteristic2}"></c:out>
&characteristic3=<c:out value="${latestProducts.characteristic3}"></c:out>
&characteristic4=<c:out value="${latestProducts.characteristic4}"></c:out>
&characteristic5=<c:out value="${latestProducts.characteristic5}"></c:out>
&characteristic6=<c:out value="${latestProducts.characteristic6}"></c:out>
&characteristic7=<c:out value="${latestProducts.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${latestProducts.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${latestProducts.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${latestProducts.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${latestProducts.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${latestProducts.boolCharacteristic5}"></c:out>
&rating=<c:out value="${latestProducts.rating}"></c:out>
&stockStatus=<c:out value="${latestProducts.stockStatus}"></c:out>
&image1Path=<c:out value="${latestProducts.image1Path}"></c:out>
&image2Path=<c:out value="${latestProducts.image2Path}"></c:out>
&image3Path=<c:out value="${latestProducts.image3Path}"></c:out>
&image4Path=<c:out value="${latestProducts.image4Path}"></c:out>
&image5Path=<c:out value="${latestProducts.image5Path}"></c:out>
&image6Path=<c:out value="${latestProducts.image6Path}"></c:out>
&price=<c:out value="${latestProducts.price}"></c:out>
&productId=<c:out value="${latestProducts.productId}"></c:out>
&categoryId=<c:out value="${latestProducts.categoryFk.categoryId}"></c:out>"
                                            >
                                                <c:out value="${latestProducts.characteristic1}"></c:out> <c:out
                                                value="${latestProducts.description}"></c:out>
                                            </a>
                                        </h2>

                                        <div class="product-carousel-price">
                                            <ins>$<c:out value="${latestProducts.price}"></c:out></ins> <del>$<c:out value="${latestProducts.oldprice}"></c:out></del>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End main content area -->
    
    <div class="brands-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="brand-wrapper">
                        <h2 class="section-title"><locale:message code="label.Brands"/></h2>
                        <div class="brand-list">
                            <img src="img/services_logo__1.jpg" alt="">
                            <img src="img/services_logo__2.jpg" alt="">
                            <img src="img/services_logo__3.jpg" alt="">
                            <img src="img/services_logo__4.jpg" alt="">
                            <img src="img/services_logo__1.jpg" alt="">
                            <img src="img/services_logo__2.jpg" alt="">
                            <img src="img/services_logo__3.jpg" alt="">
                            <img src="img/services_logo__4.jpg" alt="">                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End brands area -->
    
<div class="product-widget-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Top Sellers</h2>
                        <a href="" class="wid-view-more">View All</a>
                        <c:forEach items="${requestScope.topSellers}" var="topSellers">
                            <div class="single-wid-product">
                                <a href="singleProduct?description=<c:out value="${topSellers.description}"></c:out>
&comment=<c:out value="${topSellers.comment}"></c:out>
&name=<c:out value="${topSellers.name}"></c:out>
&intCharacteristic1=<c:out value="${topSellers.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${topSellers.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${topSellers.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${topSellers.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${topSellers.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${topSellers.characteristic1}"></c:out>
&characteristic2=<c:out value="${topSellers.characteristic2}"></c:out>
&characteristic3=<c:out value="${topSellers.characteristic3}"></c:out>
&characteristic4=<c:out value="${topSellers.characteristic4}"></c:out>
&characteristic5=<c:out value="${topSellers.characteristic5}"></c:out>
&characteristic6=<c:out value="${topSellers.characteristic6}"></c:out>
&characteristic7=<c:out value="${topSellers.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${topSellers.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${topSellers.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${topSellers.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${topSellers.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${topSellers.boolCharacteristic5}"></c:out>
&rating=<c:out value="${topSellers.rating}"></c:out>
&stockStatus=<c:out value="${topSellers.stockStatus}"></c:out>
&image1Path=<c:out value="${topSellers.image1Path}"></c:out>
&image2Path=<c:out value="${topSellers.image2Path}"></c:out>
&image3Path=<c:out value="${topSellers.image3Path}"></c:out>
&image4Path=<c:out value="${topSellers.image4Path}"></c:out>
&image5Path=<c:out value="${topSellers.image5Path}"></c:out>
&image6Path=<c:out value="${topSellers.image6Path}"></c:out>
&price=<c:out value="${topSellers.price}"></c:out>
&productId=<c:out value="${topSellers.productId}"></c:out>
&categoryId=<c:out value="${topSellers.categoryFk.categoryId}"></c:out>"
                                >
                                    <img src="img/<c:out value="${topSellers.image1Path}"></c:out>" alt="" class="product-thumb">
                                </a>
                                <h2>
                                    <a href="singleProduct?description=<c:out value="${topSellers.description}"></c:out>
&comment=<c:out value="${topSellers.comment}"></c:out>
&name=<c:out value="${topSellers.name}"></c:out>
&intCharacteristic1=<c:out value="${topSellers.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${topSellers.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${topSellers.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${topSellers.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${topSellers.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${topSellers.characteristic1}"></c:out>
&characteristic2=<c:out value="${topSellers.characteristic2}"></c:out>
&characteristic3=<c:out value="${topSellers.characteristic3}"></c:out>
&characteristic4=<c:out value="${topSellers.characteristic4}"></c:out>
&characteristic5=<c:out value="${topSellers.characteristic5}"></c:out>
&characteristic6=<c:out value="${topSellers.characteristic6}"></c:out>
&characteristic7=<c:out value="${topSellers.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${topSellers.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${topSellers.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${topSellers.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${topSellers.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${topSellers.boolCharacteristic5}"></c:out>
&rating=<c:out value="${topSellers.rating}"></c:out>
&stockStatus=<c:out value="${topSellers.stockStatus}"></c:out>
&image1Path=<c:out value="${topSellers.image1Path}"></c:out>
&image2Path=<c:out value="${topSellers.image2Path}"></c:out>
&image3Path=<c:out value="${topSellers.image3Path}"></c:out>
&image4Path=<c:out value="${topSellers.image4Path}"></c:out>
&image5Path=<c:out value="${topSellers.image5Path}"></c:out>
&image6Path=<c:out value="${topSellers.image6Path}"></c:out>
&price=<c:out value="${topSellers.price}"></c:out>
&productId=<c:out value="${topSellers.productId}"></c:out>
&categoryId=<c:out value="${topSellers.categoryFk.categoryId}"></c:out>"
                                    >
                                        <c:out value="${topSellers.characteristic1}"></c:out> <c:out value="${topSellers.description}"></c:out>
                                    </a>
                                </h2>
                                <div class="product-wid-rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product-wid-price">
                                    <ins>$<c:out value="${topSellers.price}"></c:out></ins> <del>$<c:out value="${topSellers.oldprice}"></c:out></del>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Recently Viewed</h2>
                        <a href="#" class="wid-view-more">View All</a>
                        <c:forEach items="${requestScope.recentlyViewed}" var="recentlyViewed">
                            <div class="single-wid-product">
                                <a href="singleProduct?description=<c:out value="${recentlyViewed.description}"></c:out>
&comment=<c:out value="${recentlyViewed.comment}"></c:out>
&name=<c:out value="${recentlyViewed.name}"></c:out>
&intCharacteristic1=<c:out value="${recentlyViewed.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${recentlyViewed.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${recentlyViewed.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${recentlyViewed.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${recentlyViewed.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${recentlyViewed.characteristic1}"></c:out>
&characteristic2=<c:out value="${recentlyViewed.characteristic2}"></c:out>
&characteristic3=<c:out value="${recentlyViewed.characteristic3}"></c:out>
&characteristic4=<c:out value="${recentlyViewed.characteristic4}"></c:out>
&characteristic5=<c:out value="${recentlyViewed.characteristic5}"></c:out>
&characteristic6=<c:out value="${recentlyViewed.characteristic6}"></c:out>
&characteristic7=<c:out value="${recentlyViewed.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${recentlyViewed.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${recentlyViewed.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${recentlyViewed.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${recentlyViewed.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${recentlyViewed.boolCharacteristic5}"></c:out>
&rating=<c:out value="${recentlyViewed.rating}"></c:out>
&stockStatus=<c:out value="${recentlyViewed.stockStatus}"></c:out>
&image1Path=<c:out value="${recentlyViewed.image1Path}"></c:out>
&image2Path=<c:out value="${recentlyViewed.image2Path}"></c:out>
&image3Path=<c:out value="${recentlyViewed.image3Path}"></c:out>
&image4Path=<c:out value="${recentlyViewed.image4Path}"></c:out>
&image5Path=<c:out value="${recentlyViewed.image5Path}"></c:out>
&image6Path=<c:out value="${recentlyViewed.image6Path}"></c:out>
&price=<c:out value="${recentlyViewed.price}"></c:out>
&productId=<c:out value="${recentlyViewed.productId}"></c:out>
&categoryId=<c:out value="${recentlyViewed.categoryFk.categoryId}"></c:out>"
                                >
                                    <img src="img/<c:out value="${recentlyViewed.image1Path}"></c:out>" alt="" class="product-thumb">
                                </a>
                                <h2>
                                    <a href="singleProduct?description=<c:out value="${recentlyViewed.description}"></c:out>
&comment=<c:out value="${recentlyViewed.comment}"></c:out>
&name=<c:out value="${recentlyViewed.name}"></c:out>
&intCharacteristic1=<c:out value="${recentlyViewed.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${recentlyViewed.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${recentlyViewed.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${recentlyViewed.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${recentlyViewed.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${recentlyViewed.characteristic1}"></c:out>
&characteristic2=<c:out value="${recentlyViewed.characteristic2}"></c:out>
&characteristic3=<c:out value="${recentlyViewed.characteristic3}"></c:out>
&characteristic4=<c:out value="${recentlyViewed.characteristic4}"></c:out>
&characteristic5=<c:out value="${recentlyViewed.characteristic5}"></c:out>
&characteristic6=<c:out value="${recentlyViewed.characteristic6}"></c:out>
&characteristic7=<c:out value="${recentlyViewed.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${recentlyViewed.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${recentlyViewed.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${recentlyViewed.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${recentlyViewed.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${recentlyViewed.boolCharacteristic5}"></c:out>
&rating=<c:out value="${recentlyViewed.rating}"></c:out>
&stockStatus=<c:out value="${recentlyViewed.stockStatus}"></c:out>
&image1Path=<c:out value="${recentlyViewed.image1Path}"></c:out>
&image2Path=<c:out value="${recentlyViewed.image2Path}"></c:out>
&image3Path=<c:out value="${recentlyViewed.image3Path}"></c:out>
&image4Path=<c:out value="${recentlyViewed.image4Path}"></c:out>
&image5Path=<c:out value="${recentlyViewed.image5Path}"></c:out>
&image6Path=<c:out value="${recentlyViewed.image6Path}"></c:out>
&price=<c:out value="${recentlyViewed.price}"></c:out>
&productId=<c:out value="${recentlyViewed.productId}"></c:out>
&categoryId=<c:out value="${recentlyViewed.categoryFk.categoryId}"></c:out>"
                                    >
                                        <c:out value="${recentlyViewed.characteristic1}"></c:out> <c:out value="${recentlyViewed.description}"></c:out>
                                    </a>
                                </h2>
                                <div class="product-wid-rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="product-wid-price">
                                    <ins>$<c:out value="${recentlyViewed.price}"></c:out></ins> <del>$<c:out value="${recentlyViewed.oldprice}"></c:out></del>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Top New</h2>
                        <a href="#" class="wid-view-more">View All</a>
                        <div class="single-wid-product">
                            <c:forEach items="${requestScope.topNew}" var="topNew">
                                <div class="single-wid-product">
                                    <a href="singleProduct?description=<c:out value="${topNew.description}"></c:out>
&comment=<c:out value="${topNew.comment}"></c:out>
&name=<c:out value="${topNew.name}"></c:out>
&intCharacteristic1=<c:out value="${topNew.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${topNew.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${topNew.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${topNew.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${topNew.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${topNew.characteristic1}"></c:out>
&characteristic2=<c:out value="${topNew.characteristic2}"></c:out>
&characteristic3=<c:out value="${topNew.characteristic3}"></c:out>
&characteristic4=<c:out value="${topNew.characteristic4}"></c:out>
&characteristic5=<c:out value="${topNew.characteristic5}"></c:out>
&characteristic6=<c:out value="${topNew.characteristic6}"></c:out>
&characteristic7=<c:out value="${topNew.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${topNew.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${topNew.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${topNew.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${topNew.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${topNew.boolCharacteristic5}"></c:out>
&rating=<c:out value="${topNew.rating}"></c:out>
&stockStatus=<c:out value="${topNew.stockStatus}"></c:out>
&image1Path=<c:out value="${topNew.image1Path}"></c:out>
&image2Path=<c:out value="${topNew.image2Path}"></c:out>
&image3Path=<c:out value="${topNew.image3Path}"></c:out>
&image4Path=<c:out value="${topNew.image4Path}"></c:out>
&image5Path=<c:out value="${topNew.image5Path}"></c:out>
&image6Path=<c:out value="${topNew.image6Path}"></c:out>
&price=<c:out value="${topNew.price}"></c:out>
&productId=<c:out value="${topNew.productId}"></c:out>
&categoryId=<c:out value="${topNew.categoryFk.categoryId}"></c:out>"
                                    >
                                        <img src="img/<c:out value="${topNew.image1Path}"></c:out>" alt="" class="product-thumb">
                                    </a>
                                    <h2>
                                        <a href="singleProduct?description=<c:out value="${topNew.description}"></c:out>
&comment=<c:out value="${topNew.comment}"></c:out>
&name=<c:out value="${topNew.name}"></c:out>
&intCharacteristic1=<c:out value="${topNew.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${topNew.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${topNew.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${topNew.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${topNew.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${topNew.characteristic1}"></c:out>
&characteristic2=<c:out value="${topNew.characteristic2}"></c:out>
&characteristic3=<c:out value="${topNew.characteristic3}"></c:out>
&characteristic4=<c:out value="${topNew.characteristic4}"></c:out>
&characteristic5=<c:out value="${topNew.characteristic5}"></c:out>
&characteristic6=<c:out value="${topNew.characteristic6}"></c:out>
&characteristic7=<c:out value="${topNew.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${topNew.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${topNew.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${topNew.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${topNew.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${topNew.boolCharacteristic5}"></c:out>
&rating=<c:out value="${topNew.rating}"></c:out>
&stockStatus=<c:out value="${topNew.stockStatus}"></c:out>
&image1Path=<c:out value="${topNew.image1Path}"></c:out>
&image2Path=<c:out value="${topNew.image2Path}"></c:out>
&image3Path=<c:out value="${topNew.image3Path}"></c:out>
&image4Path=<c:out value="${topNew.image4Path}"></c:out>
&image5Path=<c:out value="${topNew.image5Path}"></c:out>
&image6Path=<c:out value="${topNew.image6Path}"></c:out>
&price=<c:out value="${topNew.price}"></c:out>
&productId=<c:out value="${topNew.productId}"></c:out>
&categoryId=<c:out value="${topNew.categoryFk.categoryId}"></c:out>"
                                        >
                                            <c:out value="${topNew.characteristic1}"></c:out> <c:out value="${topNew.description}"></c:out>
                                        </a>
                                    </h2>
                                    <div class="product-wid-rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>
                                    <div class="product-wid-price">
                                        <ins>$<c:out value="${topNew.price}"></c:out></ins> <del>$<c:out value="${topNew.oldprice}"></c:out></del>
                                    </div>
                                </div>
                            </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End product widget area -->
    
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
   
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    
    <!-- jQuery sticky menu -->
     
    <script src="js/jquery.sticky.js"></script>
<!--     <script src="js/jquery.easing.1.3.min.js"></script> -->
    <script src="js/main.js"></script> -->    
    <!--jQuery easing
    <script src="js/jquery.easing.1.3.min.js"></script>
    
    Main Script
    <script src="js/main.js"></script> -->
  </body>
</html>
