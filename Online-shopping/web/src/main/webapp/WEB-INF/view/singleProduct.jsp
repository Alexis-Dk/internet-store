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
			  <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
              <meta http-equiv=Content-Type content="text/html;charset=UTF-8">
              <title>Internet-shop</title>
              <link rel="stylesheet" href="resources/styles/bootstrap.css">
              <link rel="stylesheet" href="resources/styles/style.css">
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
              <link rel="stylesheet" href="<c:url value="/css/flexslider.css" />" type="text/css" media="screen" />
              <link rel="stylesheet" href="<c:url value="/css/owl.carousel.css" />" rel="stylesheet">
              <link rel="stylesheet" href="<c:url value="/css/styleMain.css" />" rel="stylesheet"> 
              <link rel="stylesheet" href="<c:url value="/css/responsive.css" />" rel="stylesheet"> 

              <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
              <script src="js/customMenu.js"> </script>
              
              <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
	<script src="js/simpleCart.min.js"> </script>
	    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	
	    .letter {
		    text-transform: uppercase;
		}
	
	
	.dress-name {
	margin:50px 0;
}
.dress-name h3 {
    float: left;
    font-size: 19px;
    color: #000;
    font-weight: 500;
	    padding: 0;
}
.dress-name p {
    margin-top: 16px;
    font-size: 13px;
    line-height: 23px;
    color: #CAC9C9;
}
.dress-name span {
	float: right;
    color: #000000;
    font-size: 20px;
    letter-spacing: 1px;
    font-weight: 400;
}
p.left {
    float: left;
    font-size: 13px;
    color: #000;
    letter-spacing: 2px;
	margin-right:5%;
	width:70%;
}
p.right {
    float: left;
    font-size: 13px;
    color: #000;
    letter-spacing: 2px;
}
.span1 {
    margin: 18px 0;
    padding: 15px 0;
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
}
.span3 {
    margin: 18px 0;
    padding: 15px 0;
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
}
.span4 {
    border-bottom: 1px solid #Eee;
    padding-bottom: 18px;
} 
	
			.flexslider {
		    width: 350px;
		    height: auto;
		}
		
		 .flexslider .slides img {
		    width: 350px;
		    height: auto;
		} 
		
		img {
		    max-width: 220%;
		    height: 100%;	
		}
		
.new-product{
	width:100%;
	float:right;
	background:rgba(245, 243, 243, 0.27);
	min-height:80px;
	padding:0em;
}
	
	</style>
	
	
<!-- 	  <style>
		

		
		.flexslider {
		    width: 370px;
		    height: 550px;
		}
		
		 .flexslider .slides img {
		    width: 370
		    height: 550px;
		} 
		
		img {
		    max-width: 220%;
		    height: auto;
		}
		
.new-product{
	width:100%;
	float:right;
	background:rgba(245, 243, 243, 0.27);
	min-height:800px;
	padding:0em;
}

.dress-name {
	margin:50px 0;
}
.dress-name h3 {
    float: left;
    font-size: 19px;
    color: #000;
    font-weight: 500;
	    padding: 0;
}
.dress-name p {
    margin-top: 16px;
    font-size: 13px;
    line-height: 23px;
    color: #CAC9C9;
}
.dress-name span {
	float: right;
    color: #000000;
    font-size: 20px;
    letter-spacing: 1px;
    font-weight: 400;
}
p.left {
    float: left;
    font-size: 13px;
    color: #000;
    letter-spacing: 2px;
	margin-right:5%;
	width:50%;
}
p.right {
    float: left;
    font-size: 13px;
    color: #000;
    letter-spacing: 2px;
}
.span1 {
    margin: 18px 0;
    padding: 15px 0;
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
}
.span3 {
    margin: 18px 0;
    padding: 15px 0;
    border-top: 1px solid #eee;
    border-bottom: 1px solid #eee;
}
.span4 {
    border-bottom: 1px solid #Eee;
    padding-bottom: 18px;
} 
</style>
-->

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
	                      			 <a href="ViewItemsOfCart.html"><locale:message code="label.cart"/> - <span class="cart-amunt"><c:out value="${currentCurrencySymbol}"></c:out><c:out value="${quantitiAndSum.sum}"></c:out></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><c:out value="${quantitiAndSum.quantity}"></c:out></span></a>
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
                            <li class="active"><a><locale:message code="label.singleProduct"/></a></li>
                            <sec:authorize access="hasRole('user') or isAnonymous()">
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
		<div>
			<div id="map-canvas" style="height: 9px; width: 500px"></div>
		</div>
		<div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Search Products</h2>
                        <form action="">
                            <input type="text" placeholder="Search products...">
                            <input type="submit" value="Search">
                        </form>
                    </div>
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Products</h2>
                        <c:forEach items="${requestScope.randomProducts}" var="randomProducts">
                            <div class="thubmnail-recent">
                                <img src="img/<c:out value="${randomProducts.image1Path}"></c:out>" class="recent-thumb" alt="">
                                <h2>
                                    <a href="singleProduct?description=<c:out value="${randomProducts.description}"></c:out>
&comment=<c:out value="${randomProducts.comment}"></c:out>
&name=<c:out value="${randomProducts.name}"></c:out>
&intCharacteristic1=<c:out value="${randomProducts.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${randomProducts.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${randomProducts.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${randomProducts.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${randomProducts.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${randomProducts.characteristic1}"></c:out>
&characteristic2=<c:out value="${randomProducts.characteristic2}"></c:out>
&characteristic3=<c:out value="${randomProducts.characteristic3}"></c:out>
&characteristic4=<c:out value="${randomProducts.characteristic4}"></c:out>
&characteristic5=<c:out value="${randomProducts.characteristic5}"></c:out>
&characteristic6=<c:out value="${randomProducts.characteristic6}"></c:out>
&characteristic7=<c:out value="${randomProducts.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${randomProducts.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${randomProducts.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${randomProducts.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${randomProducts.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${randomProducts.boolCharacteristic5}"></c:out>
&rating=<c:out value="${randomProducts.rating}"></c:out>
&stockStatus=<c:out value="${randomProducts.stockStatus}"></c:out>
&image1Path=<c:out value="${randomProducts.image1Path}"></c:out>
&image2Path=<c:out value="${randomProducts.image2Path}"></c:out>
&image3Path=<c:out value="${randomProducts.image3Path}"></c:out>
&image4Path=<c:out value="${randomProducts.image4Path}"></c:out>
&image5Path=<c:out value="${randomProducts.image5Path}"></c:out>
&image6Path=<c:out value="${randomProducts.image6Path}"></c:out>
&price=<c:out value="${randomProducts.price}"></c:out>
&productId=<c:out value="${randomProducts.productId}"></c:out>
&categoryId=<c:out value="${randomProducts.categoryFk.categoryId}"></c:out>"
                                    >
                                        <c:out value="${randomProducts.characteristic1}"></c:out> <c:out value="${randomProducts.description}"></c:out>
                                    </a>
                                </h2>
                                <div class="product-sidebar-price">
                                    <ins>$<c:out value="${randomProducts.price}"></c:out></ins> <del>$<c:out value="${randomProducts.oldprice}"></c:out></del>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Recent Posts</h2>
                        <ul>
                            <c:forEach items="${requestScope.recentPosts}" var="recentPosts">
                                <li>
                                    <a href="singleProduct?description=<c:out value="${recentPosts.description}"></c:out>
&comment=<c:out value="${recentPosts.comment}"></c:out>
&name=<c:out value="${recentPosts.name}"></c:out>
&intCharacteristic1=<c:out value="${recentPosts.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${recentPosts.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${recentPosts.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${recentPosts.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${recentPosts.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${recentPosts.characteristic1}"></c:out>
&characteristic2=<c:out value="${recentPosts.characteristic2}"></c:out>
&characteristic3=<c:out value="${recentPosts.characteristic3}"></c:out>
&characteristic4=<c:out value="${recentPosts.characteristic4}"></c:out>
&characteristic5=<c:out value="${recentPosts.characteristic5}"></c:out>
&characteristic6=<c:out value="${recentPosts.characteristic6}"></c:out>
&characteristic7=<c:out value="${recentPosts.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${recentPosts.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${recentPosts.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${recentPosts.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${recentPosts.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${recentPosts.boolCharacteristic5}"></c:out>
&rating=<c:out value="${recentPosts.rating}"></c:out>
&stockStatus=<c:out value="${recentPosts.stockStatus}"></c:out>
&image1Path=<c:out value="${recentPosts.image1Path}"></c:out>
&image2Path=<c:out value="${recentPosts.image2Path}"></c:out>
&image3Path=<c:out value="${recentPosts.image3Path}"></c:out>
&image4Path=<c:out value="${recentPosts.image4Path}"></c:out>
&image5Path=<c:out value="${recentPosts.image5Path}"></c:out>
&image6Path=<c:out value="${recentPosts.image6Path}"></c:out>
&price=<c:out value="${recentPosts.price}"></c:out>
&productId=<c:out value="${recentPosts.productId}"></c:out>
&categoryId=<c:out value="${recentPosts.categoryFk.categoryId}"></c:out>"
                                    >
                                        <c:out value="${recentPosts.characteristic1}"></c:out> <c:out
                                            value="${recentPosts.description}"></c:out>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="product-breadcroumb">
                            <a href="index">Home</a>
                            <a href="product?category=${requestScope.category.categoryId}">${requestScope.category.categoryName}</a>
                            <a href=""><%=request.getParameter("characteristic1")%> <%=request.getParameter("description")%></a>
                        </div>
                         
                        <div class="row">
                           	
                           <div class="col-sm-6">
                                <div class="new-product">
								  <div class="col-md-5 zoom-grid">
								    <div class="flexslider" >
								      <ul class="slides">
								        <li data-thumb="img/<%=request.getParameter("image1Path")%>">
								          <div class="thumb-image"> <img src="img/<%=request.getParameter("image1Path")%>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
								        </li>
								        <li data-thumb="img/<%=request.getParameter("image2Path")%>">
								          <div class="thumb-image"> <img src="img/<%=request.getParameter("image2Path")%>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
								        </li>
								        <li data-thumb="img/<%=request.getParameter("image3Path")%>">
								          <div class="thumb-image"> <img src="img/<%=request.getParameter("image3Path")%>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
								        </li>
								        <li data-thumb="img/<%=request.getParameter("image4Path")%>">
								          <div class="thumb-image"> <img src="img/<%=request.getParameter("image4Path")%>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
								        </li>
								      </ul>
								    </div>
								
								  </div>
								  <div class="col-md-7 dress-info">
								    <div class="dress-name">
<%-- 								      <h3><%=request.getParameter("characteristic1")%> <%=request.getParameter("description")%></h3>
								      <span>$<%=request.getParameter("intCharacteristic1")%></span> --%>
								      <div class="clearfix"></div>
								
								
								  <script src="<c:url value="/js/imagezoom.js" />"></script>
								    <!-- FlexSlider -->
								    <script defer src="<c:url value="/js/jquery.flexslider.js" />"></script>
								    <script>
								      // Can also be used with $(document).ready()
								      $(window).load(function() {
								        $('.flexslider').flexslider({
								        animation: "slide",
								        controlNav: "thumbnails"
								        });
								      });
								    </script>
								  </div>
								</div>
							  </div>   
                            </div>

                            <div class="col-sm-6">
                                <div class="product-inner">
                                    <h2 class="product-name"><%=request.getParameter("characteristic1")%> <%=request.getParameter("description")%></h2>
                                    <div class="product-inner-price">
                                       <ins><c:out value="${currentCurrencySymbol}"></c:out><%=request.getParameter("price")%></ins> <del><c:out value="${currentCurrencySymbol}"></c:out><%=request.getParameter("price")%></del>
                                    </div>    
                                    
                                    <form action="${context}/addNewProductToCart?" class="cart">
                                         <div class="quantity">
                                            <input type="number" size="4" class="input-text qty text" title="Qty" value="1" name="quantity" min="1" step="1">
                                        </div> 
                                        <input hidden="true" name = "description" value="<%=request.getParameter("description")%>">
                                        <!-- <input hidden="true" name = "" value=""> -->
                                        <input hidden="true" name = "productId" value="<%=request.getParameter("productId")%>">
                                        <input hidden="true" name = "name" value="<%=request.getParameter("name")%>">
                                        <input hidden="true" name = "characteristic1" value="<%=request.getParameter("characteristic1")%>">
                                        <input hidden="true" name = "characteristic2" value="<%=request.getParameter("characteristic2")%>">
                                        <input hidden="true" name = "characteristic3" value="<%=request.getParameter("characteristic3")%>">
                                        <input hidden="true" name = "characteristic4" value="<%=request.getParameter("characteristic4")%>">
                                        <input hidden="true" name = "characteristic5" value="<%=request.getParameter("characteristic5")%>">
                                        <input hidden="true" name = "characteristic6" value="<%=request.getParameter("characteristic6")%>">
                                        <input hidden="true" name = "characteristic7" value="<%=request.getParameter("characteristic7")%>">
                                        <input hidden="true" name = "rating" value="<%=request.getParameter("rating")%>">
                                        <input hidden="true" name = "stockStatus" value="<%=request.getParameter("stockStatus")%>">
                                        <input hidden="true" name = "image1Path" value="<%=request.getParameter("image1Path")%>">
                                        <input hidden="true" name = "price" value="<%=request.getParameter("price")%>">

                                        <button class="add_to_cart_button" type="submit">Add to cart</button>
                                    </form>   
                                    
<%--                                     			<a class="add_to_cart_button" data-quantity="1"
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
												&image1Path=<%=request.getParameter("image1Path")%>
												&price=<%=request.getParameter("price")%>
												&productId=<%=request.getParameter("productId")%>">Add
												to cart</a> --%>
                                    
                                    <div class="product-inner-category">
                                        <p>Category: <a href="product?category=${requestScope.category.categoryId}"> ${requestScope.category.categoryName}</a>. Tags: <a href="">awesome</a>, <a href="">best</a>, <a href="">sale</a>. </p>
                                    </div> 
                                    
                                    <div role="tabpanel">
                                        <ul class="product-tab" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <h2>Product Description</h2>  
                                                <p><%=request.getParameter("comment")%>.</p>
                                             
<%-- 												 <div class="dress-name">
													<h3><%=request.getParameter("characteristic1")%> <%=request.getParameter("description")%></h3>
													<span>$<%=request.getParameter("intCharacteristic1")%></span>
													<div class="clearfix"></div>
												</div> --%>
												
												<div class="span span1" ${categoryCharacteristicEnableIntStatus1}>
													<p class="left">${categoryCharacteristicIntLang1}</p>
													<p class="right"><%=request.getParameter("intCharacteristic1")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableIntStatus2}>
													<p class="left">${categoryCharacteristicIntLang2}</p>
													<p class="right"><%=request.getParameter("intCharacteristic2")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableIntStatus3}>
													<p class="left">${categoryCharacteristicIntLang3}</p>
													<p class="right"><%=request.getParameter("intCharacteristic3")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableIntStatus4}>
													<p class="left">${categoryCharacteristicIntLang4}</p>
													<p class="right"><%=request.getParameter("intCharacteristic4")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableIntStatus5}>
													<p class="left">${categoryCharacteristicIntLang5}</p>
													<p class="right"><%=request.getParameter("intCharacteristic5")%></p>
													<div class="clearfix"></div>
												</div>
												
												<div class="span span2" ${categoryCharacteristicEnableStrStatus1}>
													<p class="left">${categoryCharacteristicStrLang1}</p>
													<p class="right"><%=request.getParameter("characteristic1")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableStrStatus2}>
													<p class="left">${categoryCharacteristicStrLang2}</p>
													<p class="right"><%=request.getParameter("characteristic2")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableStrStatus3}>
													<p class="left">${categoryCharacteristicStrLang3}</p>
													<p class="right"><%=request.getParameter("characteristic3")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableStrStatus4}>
													<p class="left">${categoryCharacteristicStrLang4}</p>
													<p class="right"><%=request.getParameter("characteristic4")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableStrStatus5}>
													<p class="left">${categoryCharacteristicStrLang5}</p>
													<p class="right"><%=request.getParameter("characteristic5")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableStrStatus6}>
													<p class="left">${categoryCharacteristicStrLang6}</p>
													<p class="right"><%=request.getParameter("characteristic6")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableStrStatus7}>
													<p class="left">${categoryCharacteristicStrLang7}</p>
													<p class="right"><%=request.getParameter("characteristic7")%></p>
													<div class="clearfix"></div>
												</div>
												
												<div class="span span3" ${categoryCharacteristicEnableBoolStatus1}>
													<p class="left">${categoryCharacteristicBoolLang1}</p>
													<p class="right"><%=request.getParameter("boolCharacteristic1")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableBoolStatus2}>
													<p class="left">${categoryCharacteristicBoolLang2}</p>
													<p class="right"><%=request.getParameter("boolCharacteristic2")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableBoolStatus3}>
													<p class="left">${categoryCharacteristicBoolLang3}</p>
													<p class="right"><%=request.getParameter("boolCharacteristic3")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span2" ${categoryCharacteristicEnableBoolStatus4}>
													<p class="left">${categoryCharacteristicBoolLang4}</p>
													<p class="right"><%=request.getParameter("boolCharacteristic4")%></p>
													<div class="clearfix"></div>
												</div>
												<div class="span span3" ${categoryCharacteristicEnableBoolStatus5}>
													<p class="left">${categoryCharacteristicBoolLang5}</p>
													<p class="right"><%=request.getParameter("boolCharacteristic5")%></p>
													<div class="clearfix"></div>
												</div>  
                                              
                                                 <!-- <p>Mauris placerat vitae lorem gravida viverra. Mauris in fringilla ex. Nulla facilisi. Etiam scelerisque tincidunt quam facilisis lobortis. In malesuada pulvinar neque a consectetur. Nunc aliquam gravida purus, non malesuada sem accumsan in. Morbi vel sodales libero.</p>
                                            --> </div> 
                                            <div role="tabpanel" class="tab-pane fade" id="profile">
                                                <h2>Reviews</h2>
                                                <div class="submit-review">
                                                    <p><label for="name">Name</label> <input name="name" type="text"></p>
                                                    <p><label for="email">Email</label> <input name="email" type="email"></p>
                                                    <div class="rating-chooser">
                                                        <p>Your rating</p>

                                                        <div class="rating-wrap-post">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                    </div>
                                                    <p><label for="review">Your review</label> <textarea name="review" id="" cols="30" rows="10"></textarea></p>
                                                    <p><input type="submit" value="Submit"></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="related-products-wrapper">
                            <h2 class="related-products-title">Related Products</h2>
                            <div class="related-products-carousel">
                                <c:forEach items="${requestScope.relatedProducts}" var="relatedProducts">
                                    <div class="single-product">
                                        <div class="product-f-image">
                                            <img src="img/<c:out value="${relatedProducts.image1Path}"></c:out>" alt="">
                                            <div class="product-hover">
                                                <a href="${context}/addNewProductToCart?
description=<c:out value="${relatedProducts.description}"></c:out>
&name=<c:out value="${relatedProducts.name}"></c:out>
&characteristic1=<c:out value="${relatedProducts.characteristic1}"></c:out>
&characteristic2=<c:out value="${relatedProducts.characteristic2}"></c:out>
&characteristic3=<c:out value="${relatedProducts.characteristic3}"></c:out>
&characteristic4=<c:out value="${relatedProducts.characteristic4}"></c:out>
&characteristic6=<c:out value="${relatedProducts.characteristic6}"></c:out>
&characteristic7=<c:out value="${relatedProducts.characteristic7}"></c:out>
&rating=<c:out value="${relatedProducts.rating}"></c:out>
&stockStatus=<c:out value="${relatedProducts.stockStatus}"></c:out>
&image1Path=<c:out value="${relatedProducts.image1Path}"></c:out>
&price=<c:out value="${relatedProducts.intCharacteristic1}"></c:out>
&productId=<c:out value="${relatedProducts.productId}"></c:out>"
                                                    class="add-to-cart-link">
                                                    <i class="fa fa-shopping-cart"></i>
                                                    Add to cart
                                                </a>
                                                <a href="#" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                            </div>
                                        </div>

                                        <h2>
                                            <a href="singleProduct?description=<c:out value="${relatedProducts.description}"></c:out>
&comment=<c:out value="${relatedProducts.comment}"></c:out>
&name=<c:out value="${relatedProducts.name}"></c:out>
&intCharacteristic1=<c:out value="${relatedProducts.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${relatedProducts.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${relatedProducts.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${relatedProducts.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${relatedProducts.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${relatedProducts.characteristic1}"></c:out>
&characteristic2=<c:out value="${relatedProducts.characteristic2}"></c:out>
&characteristic3=<c:out value="${relatedProducts.characteristic3}"></c:out>
&characteristic4=<c:out value="${relatedProducts.characteristic4}"></c:out>
&characteristic5=<c:out value="${relatedProducts.characteristic5}"></c:out>
&characteristic6=<c:out value="${relatedProducts.characteristic6}"></c:out>
&characteristic7=<c:out value="${relatedProducts.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${relatedProducts.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${relatedProducts.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${relatedProducts.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${relatedProducts.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${relatedProducts.boolCharacteristic5}"></c:out>
&rating=<c:out value="${relatedProducts.rating}"></c:out>
&stockStatus=<c:out value="${relatedProducts.stockStatus}"></c:out>
&image1Path=<c:out value="${relatedProducts.image1Path}"></c:out>
&image2Path=<c:out value="${relatedProducts.image2Path}"></c:out>
&image3Path=<c:out value="${relatedProducts.image3Path}"></c:out>
&image4Path=<c:out value="${relatedProducts.image4Path}"></c:out>
&image5Path=<c:out value="${relatedProducts.image5Path}"></c:out>
&image6Path=<c:out value="${relatedProducts.image6Path}"></c:out>
&price=<c:out value="${relatedProducts.price}"></c:out>
&productId=<c:out value="${relatedProducts.productId}"></c:out>
&categoryId=<c:out value="${relatedProducts.categoryFk.categoryId}"></c:out>"
                                            >
                                                <c:out value="${relatedProducts.characteristic1}"></c:out> <c:out value="${relatedProducts.description}"></c:out>
                                            </a>
                                        </h2>

                                        <div class="product-carousel-price">
                                            <ins>$<c:out value="${relatedProducts.price}"></c:out></ins> <del>$<c:out value="${relatedProducts.oldprice}"></c:out></del>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
    </div>

	
	
	
	
	
	
	
	
	
	
	
	<%-- <div class="zigzag-bottom"></div> --%>	
<%-- 		<div class="container">
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
 				<tr>
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
				</tr>
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
		</div> --%>
	

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

    <!-- Latest jQuery form server -->
    <!--  <script src="https://code.jquery.com/jquery.min.js"></script>  -->
    
    <!-- Bootstrap JS form CDN -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    
<!--     jQuery easing -->
     <script src="js/jquery.easing.1.3.min.js"></script> 
    
<!--     Main Script --> 
    <script src="js/main.js"></script>
</body>
</html>
