<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>
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
                  <meta http-equiv="Cache-Control" content="no-cache">
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

    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                            <sec:authorize access="isAnonymous()">
                          		    <li><a href="registration"><i class="fa fa-user"></i> Registration</a></li>
	                          	    <li><a href="${context}/login"><i class="fa fa-heart"></i> Login</a></li>
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
                            <%-- <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">USD</a></li>
                                    <li><a href="#">INR</a></li>
                                    <li><a href="#">GBP</a></li>
                                </ul>
                            </li> --%>

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
<%--                        <c:forEach items="${requestScope.quantitiAndSum}" var="quantitiAndSum">
                			<sec:authorize access="isAuthenticated()"> 
	                    		<div class="shopping-item">
	                      			 <a href="ViewItemsOfCart.html"><locale:message code="label.cart"/> - <span class="cart-amunt"><c:out value="${quantitiAndSum.sum}"></c:out></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><c:out value="${quantitiAndSum.quantity}"></c:out></span></a>
	                  		     </div>
                    		</sec:authorize>
                    	</c:forEach>  --%>
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
						<li>
							<a href="index"><locale:message code="label.home"/></a>
						</li>
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
							<li class="active"><a href="new">Add product</a></li>
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
	  					<sec:authorize access="hasRole('user')">
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
					<div class="col-xs-3">
						<label for="productDescriptData" class="control-label">StringDescription1:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="description" cssStyle="color: red" />
						<sf:textarea id="productDescriptData" path="description"
							class="form-control" name="description" rows="1" cols="50"></sf:textarea>
					</div>
				</div>

				<div class="form-group">
				
					<div class="col-xs-3"><label for="productNameData" class="control-label"><%= request.getAttribute("categoryCharacteristicStr1") %>:</label>
					</div>
					<div class="col-xs-5">
							
							<sf:errors path="characteristic1" cssStyle="color: red" />
						<sf:select path="characteristic1" items="${characteristic1}"
										itemValue="id" itemLabel="name"/>
					<%--<sf:input id="name" type="text" value="" path="name"
							class="form-control" /> --%>
					</div>
				</div>

				<!-- Product Category -->
				<div class="form-group" hidden="true">
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
						<label for="productCharacteristic1" class="control-label"><%= request.getAttribute("categoryCharacteristicStr2") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:select path="characteristic2" items="${characteristic2}"
										itemValue="id" itemLabel="name" />
						<sf:errors path="characteristic2" cssStyle="color: red" />
						<%--<sf:input id="productCharacteristic1" path="characteristic1"
							class="form-control" type="text" name="characteristic1" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic2" class="control-label"><%= request.getAttribute("categoryCharacteristicStr3") %>:</label>
					</div>
					<div class="col-xs-5">
					<sf:select path="characteristic3" items="${characteristic3}"
										itemValue="id" itemLabel="name" />
						<sf:errors path="characteristic3" cssStyle="color: red" />
						<%--<sf:input id="productCharacteristic2" path="characteristic2"
							class="form-control" type="text" name="characteristic2" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic3" class="control-label"><%= request.getAttribute("categoryCharacteristicStr4") %>:</label>
					</div>
					<div class="col-xs-5">
					<sf:select path="characteristic4" items="${characteristic4}"
										itemValue="id" itemLabel="name" />
						<sf:errors path="characteristic4" cssStyle="color: red" />
						<%--<sf:input id="productCharacteristic3" path="characteristic3"
							class="form-control" type="text" name="characteristic3" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic4" class="control-label"><%= request.getAttribute("categoryCharacteristicStr5") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic5" cssStyle="color: red" />
						<sf:select path="characteristic5" items="${characteristic5}"
										itemValue="id" itemLabel="name" />
					<%--	<sf:input id="productCharacteristic4" path="characteristic4"
							class="form-control" type="text" name="characteristic4" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productCharacteristic6" class="control-label"><%= request.getAttribute("categoryCharacteristicStr6") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic6" cssStyle="color: red" />
						<sf:select path="characteristic6" items="${characteristic6}"
										itemValue="id" itemLabel="name" />
						<%--<sf:input id="productCharacteristic6" path="characteristic6"
							class="form-control" type="text" name="characteristic6" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="productStockStatus" class="control-label"><%= request.getAttribute("categoryCharacteristicStr7") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="characteristic7" cssStyle="color: red" />
						<sf:select path="characteristic7" items="${characteristic7}"
										itemValue="id" itemLabel="name" />
						<%--<sf:input id="productStockStatus" path="stock_status"
							class="form-control" type="text" name="stock_status" /> --%>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="intCharacteristicData2" class="control-label"><%= request.getAttribute("categoryCharacteristicInt1") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="intCharacteristic1" cssStyle="color: red" />
						<sf:input id="intCharacteristicData2" path="intCharacteristic1" class="form-control"
							type="text" name="intCharacteristic1"         
							value="" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-xs-3">
						<label for="intCharacteristicData2" class="control-label"><%= request.getAttribute("categoryCharacteristicInt2") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="intCharacteristic2" cssStyle="color: red" />
						<sf:input id="intCharacteristicData2" path="intCharacteristic2" class="form-control"
							type="text" name="intCharacteristic2" value="" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="intCharacteristicData3" class="control-label"><%= request.getAttribute("categoryCharacteristicInt3") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="intCharacteristic3" cssStyle="color: red" />
						<sf:input id="intCharacteristicData3" path="intCharacteristic3" class="form-control"
							type="text" name="intCharacteristic3" value="" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="intCharacteristicData4" class="control-label"><%= request.getAttribute("categoryCharacteristicInt4") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="intCharacteristic4" cssStyle="color: red" />
						<sf:input id="intCharacteristicData4" path="intCharacteristic4" class="form-control"
							type="text" name="intCharacteristic4" value="" />
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="intCharacteristicData5" class="control-label"><%= request.getAttribute("categoryCharacteristicInt5") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:errors path="intCharacteristic5" cssStyle="color: red" />
						<sf:input id="intCharacteristicData5" path="intCharacteristic5" class="form-control"
							type="text" name="intCharacteristic5" value="" />
					</div>
				</div>
 
  				<div class="form-group">
					<div class="col-xs-3">
						<label for="boolCharacteristicData1" class="control-label"><%= request.getAttribute("categoryCharacteristicBool1") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:radiobutton path="boolCharacteristic1" value="True" /> Yes
						<sf:radiobutton path="boolCharacteristic1" value="False" /> No
						<sf:errors path="boolCharacteristic1" cssStyle="color: red" />
					</div>
				</div>
 
  				<div class="form-group">
					<div class="col-xs-3">
						<label for="boolCharacteristicData2" class="control-label"><%= request.getAttribute("categoryCharacteristicBool2") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:radiobutton path="boolCharacteristic2" value="True" /> Yes
						<sf:radiobutton path="boolCharacteristic2" value="False" /> No
						<sf:errors path="boolCharacteristic2" cssStyle="color: red" />
					</div>
				</div>
 
  				<div class="form-group">
					<div class="col-xs-3">
						<label for="boolCharacteristicData3" class="control-label"><%= request.getAttribute("categoryCharacteristicBool3") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:radiobutton path="boolCharacteristic3" value="True" /> Yes
						<sf:radiobutton path="boolCharacteristic3" value="False" /> No
						<sf:errors path="boolCharacteristic3" cssStyle="color: red" />
					</div>
				</div>
 
  				<div class="form-group">
					<div class="col-xs-3">
						<label for="boolCharacteristicData4" class="control-label"><%= request.getAttribute("categoryCharacteristicBool4") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:radiobutton path="boolCharacteristic4" value="True" /> Yes
						<sf:radiobutton path="boolCharacteristic4" value="False" /> No
						<sf:errors path="boolCharacteristic4" cssStyle="color: red" />
					</div>
				</div>
 
  				<div class="form-group">
					<div class="col-xs-3">
						<label for="boolCharacteristicData5" class="control-label"><%= request.getAttribute("categoryCharacteristicBool5") %>:</label>
					</div>
					<div class="col-xs-5">
						<sf:radiobutton path="boolCharacteristic5" value="True" /> Yes
						<sf:radiobutton path="boolCharacteristic5" value="False" /> No
						<sf:errors path="boolCharacteristic5" cssStyle="color: red" />
					</div>
				</div>
 
				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile">Product image 1: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile" name="productImage1">
						<p class="help-block">Load an image for the product.</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile2">Product image 2: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile2" name="productImage2">
						<p class="help-block">Load an image for the product.</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile3">Product image 3: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile3" name="productImage3">
						<p class="help-block">Load an image for the product.</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile4">Product image 4: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile4" name="productImage4">
						<p class="help-block">Load an image for the product.</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile5">Product image 5: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile5" name="productImage5">
						<p class="help-block">Load an image for the product.</p>
					</div>
				</div>

				<div class="form-group">
					<div class="col-xs-3">
						<label for="inputFile6">Product image 6: </label>
					</div>
					<div class="col-xs-5">
						<input type="file" id="inputFile6" name="productImage6">
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
                       <h2 class="footer-wid-title"><locale:message code="label.userNavigation"/> </h2>
                        <ul>
                            <sec:authorize access="isAnonymous()">
                          		    <li><a href="registration"><i class="fa fa-user"></i> Registration</a></li>
	                          	    <li><a href="${context}/login"><i class="fa fa-heart"></i> Login</a></li>
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
