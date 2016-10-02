<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List" %>
<%@ page import="com.superinc.europe.onlineshopping.gu.entities.dto.*" %>
<%@ page import="javax.servlet.http.HttpServletRequest.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eElectronics - HTML eCommerce Template</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
   <body>
   <%! String s = "";
       String d = "";%>
      <% List<Bucket> list =  (List<Bucket>) request.getAttribute ("cart");
      if (list.isEmpty()){
			d = "hidden";
			s = "";
		}
      else {d = ""; s = "hidden";}
      %>
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <sec:authorize access="isAnonymous()">
                          		    <li><a href="registration"><i class="fa fa-user"></i> Registration</a></li>
	                          	    <li><a href="${context}/login.jsp"><i class="fa fa-heart"></i> Login</a></li>
                             </sec:authorize>
	  						 <sec:authorize access="isAuthenticated()">  
		                            <li><a href="ViewItemsOfCart"><i class="fa fa-user"></i> My Cart</a></li>
		                            <li><a href="logout"><i class="fa fa-user"></i> Log out</a></li>
         					 </sec:authorize>	
                        </ul>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">French</a></li>
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
                        <h1><a href="index">e<span>Electronics</span></a></h1>
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
                        <li><a href="index">Home</a></li>
                        <li><a href="tv">Tv</a></li>
                    		<sec:authorize access="isAuthenticated()">
                         		<li class="active"><a href="ViewItemsOfCart">Cart</a></li>
                         	</sec:authorize>
                        <li><a href="contact">Contact</a></li>
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
                        <h2>Shopping Cart</h2>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Page title area -->
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
               <div class="col-md-4">
                    <div class="single-sidebar">
                    </div>   
                </div> 
                <sec:authorize access="isAuthenticated()">   
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="woocommerce">
                            <form method="get" action="addPurchase">
                      
                                <table class="shop_table cart" <%= d %>>
                                    <thead>
                                        <tr>
                                            <th class="product-remove">&nbsp;</th>
                                            <th class="product-thumbnail">&nbsp;</th>
                                            <th class="product-name">Product</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-subtotal">Uniq number</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${requestScope.cart}" var="cart">
                                        <tr class="cart_item">
                                            <td class="product-remove">
                                                <a title="Remove this item" class="remove" href="deleteFromCart?deleteByDescription=<c:out value="${cart.description}"></c:out>">×</a> 
                                            </td>

                                            <td class="product-thumbnail">
                                                <a href="single-product.html"><img width="145" height="145" alt="poster_1_up" class="shop_thumbnail" src="img/<c:out value="${cart.imagePath}"></c:out>"></a>
                                            </td>

                                            <td class="product-name">
                                                <a href="single-product.html"><c:out value="${cart.name}"></c:out> <c:out value="${cart.description}"></c:out></a> 
                                            </td>

                                            <td class="product-price">
                                                <span class="amount"><c:out value="${cart.price}"></c:out></span> 
                                            </td>

                                           <td class="product-quantity">
                                                <div class="quantity buttons_added">
                                                    <a href="decreaseQuantity?goodsId=<c:out value="${cart.goodsId}"></c:out>"><img width="19" height="19" alt="poster_1_up" class="shop_thumbnail" src="img/dicreaseButton.jpg"></a>
                                                    <span class="input-text qty text"> <c:out value="${cart.quantity}"></c:out> </span> 
                                                    <a href="increaseQuantity?goodsId=<c:out value="${cart.goodsId}"></c:out>"><img width="19" height="19" alt="poster_1_up" class="shop_thumbnail" src="img/increaseButton.jpg"></a>
                                                </div>
                                            </td>  
                                            <td class="product-subtotal">
                                                <span class="amount"><c:out value="${cart.goodsId}"></c:out></span> 
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        <tr> 
                                            <td class="actions" colspan="6">
                                                <div class="coupon">
                                                <!--     <label for="coupon_code">Coupon:</label>
                                                    <input type="text" placeholder="Coupon code" value="" id="coupon_code" class="input-text" name="coupon_code"> -->
                                               <!--      <input type="submit" value="Apply Coupon" name="apply_coupon" class="button"> -->
                                                </div>
                                                <input type="submit" value="order" name="cart" class="button">
                                              <!--  <input type="submit" value="Proceed to Checkout" name="proceed" class="checkout-button button alt wc-forward"> -->
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </form>
                            
                            <div class="quantity buttons_added" <%= s %>>
                                 <a><img width="600" height="300" alt="poster_1_up" class="shop_thumbnail" src="img/empty-cart2.jpg"></a>
                            <br>
                            </div>
                            
                            <div class="quantity buttons_added">
								<form action="${context}/tv">
									<button class="button" value="1" name="calc_shipping" type="submit">Return to shop</button>
								</form>
                            </div>

                        </div>                      
                    </div>                   
                </div>
                </sec:authorize>
            </div>
        </div>
    </div>

    <div class="footer-top-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div class="footer-about-us">
                        <h2>e<span>Electronics</span></h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perferendis sunt id doloribus vero quam laborum quas alias dolores blanditiis iusto consequatur, modi aliquid eveniet eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit, debitis, quisquam. Laborum commodi veritatis magni at?</p>
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">User Navigation </h2>
                        <ul>
                            <sec:authorize access="isAnonymous()">
                          		    <li><a href="registration"><i class="fa fa-user"></i> Registration</a></li>
	                          	    <li><a href="${context}/login.jsp"><i class="fa fa-heart"></i> Login</a></li>
                             </sec:authorize>
	  						 <sec:authorize access="isAuthenticated()">  
		                            <li><a href="ViewItemsOfCart"><i class="fa fa-user"></i> My Cart</a></li>
		                            <li><a href="logout"><i class="fa fa-user"></i> Log out</a></li>
         					 </sec:authorize>	
                        </ul>                              
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">Categories</h2>
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
                        <p>&copy; 2015 eElectronics. All Rights Reserved. Coded with <i class="fa fa-heart"></i> by <a href="http://leshaminskiy.by" target="_blank">Alexey Druzik</a></p>
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