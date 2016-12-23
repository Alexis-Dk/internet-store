<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
    <![endif]   response.sendRedirect("login.jsp"); %>   -->
    
  </head>
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
		                            <li><a href="logout"><i class="fa fa-user"></i> Log out</a></li>
         					 </sec:authorize>		                    
                        </ul>
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">USD</a></li>
                                    <li><a href="#">INR</a></li>
                                    <li><a href="#">GBP</a></li>
                                </ul>
                            </li>

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
                           	<sec:authorize access="hasRole('admin')">
		                        <c:forEach items="${requestScope.productCategory}" var="category">
					            	<li class="<c:out value="${category.selectedItem}"></c:out>"><a href="categoryCharacteristic?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
					            </c:forEach>
			           		</sec:authorize>
                        	<sec:authorize access="isAnonymous() or hasRole('user')">
		                        <c:forEach items="${requestScope.productCategory}" var="category">
					            	<li class="<c:out value="${category.selectedItem}"></c:out>"><a href="product?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
					            </c:forEach>
			           		</sec:authorize>
                       	<sec:authorize access="hasRole('admin')">
							<li class="active"><a href="admin">Admin page</a></li>
	  					</sec:authorize>
	  					<sec:authorize access="hasRole('admin')">
							<li><a href="addCategory">Add category</a></li>
	  					</sec:authorize>
	  					<sec:authorize access="isAuthenticated()">
                        	<li><a href="ViewItemsOfCart">Cart</a></li>
                        </sec:authorize>
                        <li><a href="contact">Contact</a></li>
                    </ul>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
        
    <div class="maincontent-area">
		<div id="addProductForm">

				<div class="form-group">
					<div class="col-xs-3"></div>
					<div class="col-xs-5">
						<br>
						<h3>Add product form</h3>
					</div>
				</div>

			<div class="form-group">
				<div class="col-xs-3"></div>
				<div class="col-xs-5">
					<br>
					<table>
						<tr>
							<td><label for="productCategoryData" class="control-label">Category:</label>
							</td>
							<td width="250"></td>
							<td>
								<form action="neww?" method="GET">
									<select name="categoryId" id="categoryId"
										onchange="this.form.submit()">
										<c:forEach items="${requestScope.productCategory}" var="category">
					                     <option   <c:out value="${category.selectedItem}"></c:out>   value="<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"></c:out></option>
		                            	</c:forEach>
									</select>
								</form>
							</td>
						</tr>
					</table>
				</div>
			</div>

			<sf:form class="form-horizontal" name="productDTO"
				modelAttribute="productDTO"
				action="${pageContext.request.contextPath}/new" method="POST"
				enctype="multipart/form-data" title="Add product form">
				<input type="hidden" name="command" value="saveproduct" />

				<div class="form-group">
					<div class="col-xs-3">
					</div>
					<div class="col-xs-5">
					</div>
				</div>

				<div class="form-group">
				
					<div class="col-xs-3"><label for="productNameData" class="control-label">Product
							Name:</label>
					</div>
					<div class="col-xs-5">
							
						<sf:errors path="name" cssStyle="color: red" />
						<sf:input id="name" type="text" value="" path="name"
							class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productPriceData" class="control-label">Product
							Price:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="price" cssStyle="color: red" />
						<sf:input id="productPriceData" path="price" class="form-control"
							type="text" name="price"         
							value="" />
							
							
					</div>
				</div>

				<!-- Product Category -->
				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCategoryData" class="control-label">Category:</label>
					</div>
					<div class="col-xs-5">
						<table>
							<tr>
							<%----%>	<td><sf:select path="department" items="${allDepartments}"
										itemValue="id" itemLabel="name" /></td> 
								<td><font color="red"> <sf:errors path="department"
											cssClass="error" />
								</font></td>
							</tr>
						</table>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCountData" class="control-label">Product
							count:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="count" cssStyle="color: red" />
						<sf:input id="productCountData" path="count" class="form-control"
							type="text" name="count" value="" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productDescriptData" class="control-label">Product
							description:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="description" cssStyle="color: red" />
						<sf:textarea id="productDescriptData" path="description"
							class="form-control" name="description" rows="1" cols="50"></sf:textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic1" class="control-label">Color:</label>
					</div>
					<div class="col-xs-5">
						<sf:select path="characteristic1" items="${characteristic1}"
										itemValue="id" itemLabel="name" />
						<sf:errors path="characteristic1" cssStyle="color: red" />
						<%--<sf:input id="productCharacteristic1" path="characteristic1"
							class="form-control" type="text" name="characteristic1" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic2" class="control-label">Socket:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic2" cssStyle="color: red" />
						<sf:input id="productCharacteristic2" path="characteristic2"
							class="form-control" type="text" name="characteristic2" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic3" class="control-label">Smart:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic3" cssStyle="color: red" />
						<sf:input id="productCharacteristic3" path="characteristic3"
							class="form-control" type="text" name="characteristic3" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic4" class="control-label">Screen
							resolution:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic4" cssStyle="color: red" />
						<sf:input id="productCharacteristic4" path="characteristic4"
							class="form-control" type="text" name="characteristic4" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic6" class="control-label">Aspect
							ratio:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic6" cssStyle="color: red" />
						<sf:input id="productCharacteristic6" path="characteristic6"
							class="form-control" type="text" name="characteristic6" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productStockStatus" class="control-label">Stock
							availability:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="stock_status" cssStyle="color: red" />
						<sf:input id="productStockStatus" path="stock_status"
							class="form-control" type="text" name="stock_status" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile">Product image: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile" name="productImage">
						<p class="help-block">Load an image for the product.</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3"></div>
					<div class="col-xs-5">
						<button type="submit" class="btn btn-danger">
							<span class="glyphicon glyphicon-floppy-disk"></span> Save
						</button>
					</div>
				</div>


			</sf:form>
		</div>





	</div> <!-- End main content area -->
    
    <div class="brands-area">

    </div> <!-- End brands area -->
    
    <div class="product-widget-area">

    </div> <!-- End product widget area -->
    
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
		                            <li><a href="logout"><i class="fa fa-user"></i> Log out</a></li>
         					 </sec:authorize>	
                        </ul>                        
                    </div>
                </div>
                
                <div class="col-md-3 col-sm-6">
                    <div class="footer-menu">
                        <h2 class="footer-wid-title">Categories</h2>
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
                        <p>&copy; 2015 eElectronics. All Rights Reserved. Coded with <i class="fa fa-heart"></i> by <a href="http://wpexpand.com" target="_blank">Alexey Druzik</a></p>
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
