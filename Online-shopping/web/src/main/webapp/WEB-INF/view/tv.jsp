<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>
<!DOCTYPE html> 
<html> 
<head>
 <c:set var="context" value="${pageContext.request.contextPath}" />
    <meta charset="ISO-8859-1">
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
    
    <!-- Google Fonts -->
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
    <script type="text/javascript">

   </script>
 
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
	                          	    <li><a href="${context}/login.jsp"><i class="fa fa-heart"></i> <locale:message code="label.login"/></a></li>
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
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key"><locale:message code="label.language"/> :</span><span class="value"><locale:message code="label.languageFull1"/> </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="javascript:setParam('lang', 'en');" id="baseUrl"><locale:message code="label.languageFull1"/></a></li>
                                    <li><a href="javascript:setParam('lang', 'fr');" id="baseUrl"><locale:message code="label.languageFull2"/></a></li>
                                    <li><a href="#">German</a></li>
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
	                      			 <a href="ViewItemsOfCart.html">Cart - <span class="cart-amunt"><c:out value="${quantitiAndSum.sum}"></c:out></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><c:out value="${quantitiAndSum.quantity}"></c:out></span></a>
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
			                    <li class="<c:out value="${category.selectedItem}"></c:out>"><a href="tv?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
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
                        	<form class="form-inline" action="${context}/tv" method="get">
							  <div class="form-group">
							    <label for="priceLower"><locale:message code="label.priceLow"/></label>
							    <input type="text" class="form-control" id="priceLower" placeholder="from" name="priceLower" value="<%= request.getSession().getAttribute("priceLower") %>">
							  </div>
							  <div class="form-group">
							    <label for="priceHighter"><locale:message code="label.priceHight"/></label>
					<!--		  	 Latest jQuery form server   <input type="text" class="form-control" id="priceHighter" name="priceHighter" placeholder="to" value="<%= request.getSession().getAttribute("priceHighter") %>">  -->
							 	<input type="text" class="form-control" id="priceHighter" name="priceHighter" placeholder="to" value="<%= request.getSession().getAttribute("priceHighter") %>">  
							  <input type="hidden" class="form-control" id="category" name="category" placeholder="to" value="<%= request.getSession().getAttribute("categoryId") %>"> 
							  </div>
							  <button type="submit" class="btn btn-default"><locale:message code="label.find"/></button>
							</form>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <c:forEach items="${requestScope.products}" var="product">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                        <a href="singleProduct?description=<c:out value="${product.description}"></c:out>
&name=<c:out value="${product.name}"></c:out>
&characteristic1=<c:out value="${product.characteristic1}"></c:out>
&characteristic2=<c:out value="${product.characteristic2}"></c:out>
&characteristic3=<c:out value="${product.characteristic3}"></c:out>
&characteristic4=<c:out value="${product.characteristic4}"></c:out>
&characteristic6=<c:out value="${product.characteristic6}"></c:out>
&characteristic7=<c:out value="${product.characteristic7}"></c:out> 
&rating=<c:out value="${product.rating}"></c:out>
&stockStatus=<c:out value="${product.stockStatus}"></c:out>
&imagePath=<c:out value="${product.imagePath}"></c:out>
&price=<c:out value="${product.price}"></c:out>
&productId=<c:out value="${product.productId}"></c:out>">
                        <img src="img/<c:out value="${product.imagePath}"></c:out>" alt=""></a>
                        </div>
							<h2><a><c:out value="${product.name}"></c:out> <c:out value="${product.description}"></c:out></a></h2>
						<div class="product-carousel-price">
                            <ins>$<c:out value="${product.price}"></c:out></ins> <del>$<c:out value="${product.oldprice}"></c:out></del>
                        </div>  
                        <sec:authorize access="isAuthenticated()">  
	                        <div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="${context}/addNewProductToCart?
										description=<c:out value="${product.description}"></c:out>
&name=<c:out value="${product.name}"></c:out>
&characteristic1=<c:out value="${product.characteristic1}"></c:out>
&characteristic2=<c:out value="${product.characteristic2}"></c:out>
&characteristic3=<c:out value="${product.characteristic3}"></c:out>
&characteristic4=<c:out value="${product.characteristic4}"></c:out>
&characteristic6=<c:out value="${product.characteristic6}"></c:out>
&characteristic7=<c:out value="${product.characteristic7}"></c:out>
&rating=<c:out value="${product.rating}"></c:out>
&stockStatus=<c:out value="${product.stockStatus}"></c:out>
&imagePath=<c:out value="${product.imagePath}"></c:out>
&price=<c:out value="${product.price}"></c:out>
&productId=<c:out value="${product.productId}"></c:out>">Add to cart</a>
								</div> 
                        </sec:authorize>                      
                    </div>
                </div>
                </c:forEach>  
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href='' 
							 onclick=" this.href='?number=1&priceLower='+document.getElementById('priceLower').value+'&priceHighter='+document.getElementById('priceHighter').value" id="add-product-save-link" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
							<c:forEach items="${requestScope.numberOfPage}" var="number">
							<li><a href='' 
							 onclick=" this.href='?number=${number.numberOfPageId}&priceLower='+document.getElementById('priceLower').value+'&priceHighter='+document.getElementById('priceHighter').value+'&category='+document.getElementById('category').value" id="add-product-save-link">${number.numberOfPageId}</a>
							 </li>
							 </c:forEach>
                        <li>
                          <a href='' 
							 onclick=" this.href='?number=2&priceLower='+document.getElementById('priceLower').value+'&priceHighter='+document.getElementById('priceHighter').value" id="add-product-save-link" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>                        
        </div>
    </div>
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
	                          	    <li><a href="${context}/login.jsp"><i class="fa fa-heart"></i> <locale:message code="label.login"/></a></li>
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
                            <li><a href="tv">LED TV</a></li>
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
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>
</body>
</html>