<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>
<!DOCTYPE html> 
<html> 
<head>
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

			  <!-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
              
		      <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
              <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
              <script src="js/payments.js"> </script>
 <c:set var="context" value="${pageContext.request.contextPath}" />
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eElectronics - HTML eCommerce Template</title>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

    
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
    

    
 


 
   <style>
   	.letter {
	    text-transform: uppercase;
	}
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1375px;}
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #F5F5F5;
      height: 100%;
      width: 300px;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 300px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;}
    }
    
    .md-button.md-icon-button {
    margin: 0 0.6rem;
    height: 4.8rem;
    min-width: 0;
    line-height: 4.8rem;
    padding-left: 0;
    padding-right: 0;
    width: 4.8rem;
	}
	
	@media (min-width: 768px)
	bootstrap.min.css:5
	.col-sm-9 {
	width: 110%;
	}
  </style>
 
</head>
<body ng-app="payments"> 

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
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key"><locale:message code="label.currency"/> :</span><span class="value"><c:out value="${currentCurrency}"></c:out> </span><b class="caret"></b></a>
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
    
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2><locale:message code="label.shop"/></h2>
                    <!--    -->	<form class="form-inline" action="${context}/product" method="get" hidden="true">
							  <div class="form-group">
							    <label for="priceLower"><locale:message code="label.priceLow"/></label>
<%-- 							<% String intCharacteristicMin1 = (String) request.getSession().getAttribute("intCharacteristicMin1"); if (intCharacteristicMin1 == null) {intCharacteristicMin1 = "";} %>
							    <% String intCharacteristicMax1 = (String) request.getSession().getAttribute("intCharacteristicMax1"); if (intCharacteristicMax1 == null) {intCharacteristicMax1 = "";} %> --%>
							    <% String intCharacteristicMin1 = (String) request.getSession().getAttribute("intCharacteristicMin1");%>
							    <% String intCharacteristicMax1 = (String) request.getSession().getAttribute("intCharacteristicMax1");%>
							    <% String intCharacteristicMin2 = (String) request.getSession().getAttribute("intCharacteristicMin2");%>
							    <% String intCharacteristicMax2 = (String) request.getSession().getAttribute("intCharacteristicMax2");%>
							    <% String intCharacteristicMin3 = (String) request.getSession().getAttribute("intCharacteristicMin3");%>
							    <% String intCharacteristicMax3 = (String) request.getSession().getAttribute("intCharacteristicMax3");%>
							    <% String intCharacteristicMin4 = (String) request.getSession().getAttribute("intCharacteristicMin4");%>
							    <% String intCharacteristicMax4 = (String) request.getSession().getAttribute("intCharacteristicMax4");%>
							    <% String intCharacteristicMin5 = (String) request.getSession().getAttribute("intCharacteristicMin5");%>
							    <% String intCharacteristicMax5 = (String) request.getSession().getAttribute("intCharacteristicMax5");%>
							    <input type="text" class="form-control" id="intCharacteristicMin1" placeholder="from" name="intCharacteristicMin1" value="<%= intCharacteristicMin1 %>">
								<input type="text" class="form-control" id="intCharacteristicMin2" placeholder="from" name="intCharacteristicMin2" value="<%= intCharacteristicMin2 %>">
								<input type="text" class="form-control" id="intCharacteristicMin3" placeholder="from" name="intCharacteristicMin3" value="<%= intCharacteristicMin3 %>">
								<input type="text" class="form-control" id="intCharacteristicMin4" placeholder="from" name="intCharacteristicMin4" value="<%= intCharacteristicMin4 %>">
								<input type="text" class="form-control" id="intCharacteristicMin5" placeholder="from" name="intCharacteristicMin5" value="<%= intCharacteristicMin5 %>">
							  </div>
							  <div class="form-group">
							    <label for="priceHighter"><locale:message code="label.priceHight"/></label>
							  	 Latest jQuery form server   
							  	<input type="text" class="form-control" id="intCharacteristicMax1" name="intCharacteristicMax1" placeholder="to" value="<%= intCharacteristicMax1 %>"> 
							 	<input type="text" class="form-control" id="intCharacteristicMax2" name="intCharacteristicMax2" placeholder="to" value="<%= intCharacteristicMax2 %>">  
								<input type="text" class="form-control" id="intCharacteristicMax3" name="intCharacteristicMax3" placeholder="to" value="<%= intCharacteristicMax3 %>">  
								<input type="text" class="form-control" id="intCharacteristicMax4" name="intCharacteristicMax4" placeholder="to" value="<%= intCharacteristicMax4 %>">  
								<input type="text" class="form-control" id="intCharacteristicMax5" name="intCharacteristicMax5" placeholder="to" value="<%= intCharacteristicMax5 %>">  
													  
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
        <div class="container-fluid" >
          <div ng-controller="AppCtrl"  style="height:48px;" ng-cloak >
 				  <!--  is-locked-open="$media('min-width: 1000px')"-->
                  <md-sidenav
                  class="md-sidenav-right"
                  md-component-id="right"
                  md-is-locked-open="lockLeft && $mdMedia('gt-md')"

                  md-whiteframe="4">

                    <md-content layout-padding ng-controller="RightCtrl">    
                         <div ng-controller="NewAppCtrl as ctrl" class="md-padding checkboxdemoSyncing" ng-cloak style="min-height:100px">
                          <div layout="row" layout-wrap>
                            <div flex="100" flex-gt-sm="150" layout="column">
                              <div>
                              <!--
                                In IE, we cannot apply flex directly to <fieldset>
                                @see https://github.com/philipwalton/flexbugs#9-some-html-elements-cant-be-flex-containers
                              -->
                        <form method="get"  action="product?" class="form-horizontal">
                        <div layout="column">
                        <input hidden="true" type="text" id="boolCharacteristic1" name="boolCharacteristic1" value="{{customUserParam.boolCharacteristic1}}">
                        <input hidden="true" type="text" id="boolCharacteristic2" name="boolCharacteristic2" value="{{customUserParam.boolCharacteristic2}}">
                        <input hidden="true" type="text" id="boolCharacteristic3" name="boolCharacteristic3" value="{{customUserParam.boolCharacteristic3}}">
                        <input hidden="true" type="text" id="boolCharacteristic4" name="boolCharacteristic4" value="{{customUserParam.boolCharacteristic4}}">
                        <input hidden="true" type="text" id="boolCharacteristic5" name="boolCharacteristic5" value="{{customUserParam.boolCharacteristic5}}">
                        <input hidden="true" type="text" id="selectedCharacteristic1" name="selectedCharacteristic1" value="{{selected1}}">
                        <input hidden="true" type="text" id="selectedCharacteristic2" name="selectedCharacteristic2" value="{{selected2}}">
                        <input hidden="true" type="text" id="selectedCharacteristic3" name="selectedCharacteristic3" value="{{selected3}}">
                        <input hidden="true" type="text" id="selectedCharacteristic4" name="selectedCharacteristic4" value="{{selected4}}">
                        <input hidden="true" type="text" id="selectedCharacteristic5" name="selectedCharacteristic5" value="{{selected5}}">
                        <input hidden="true" type="text" id="selectedCharacteristic6" name="selectedCharacteristic6" value="{{selected6}}">
                        <input hidden="true" type="text" id="selectedCharacteristic7" name="selectedCharacteristic7" value="{{selected7}}">
                        <legend class="demo-legend" ${categoryCharacteristicEnableIntStatus1}><H5 class="md-title" ><font size="3" color=#000000>${categoryCharacteristicIntLang1}</font></H5> </legend>        
                          <div layout="row" ${categoryCharacteristicEnableIntStatus1}  layout-align="center" >
                           <md-input-container>
                             <label for="testInput1">Min</label>
                             <input type="text" id="intCharacteristicMin1" ng-model="customUserParam.intCharacteristicMin1" md-autofocus="false" name="intCharacteristicMin1" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))"><!-- name="priceLower" -->
                           </md-input-container>
                           <md-input-container >
                             <label for="testInput2">Max</label>
                             <input type="text" id="intCharacteristicMax1" ng-model="customUserParam.intCharacteristicMax1" md-autofocus="false" name="intCharacteristicMax1" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                           </md-input-container>
                         </div>
                         <legend class="demo-legend" ${categoryCharacteristicEnableIntStatus2}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicIntLang2}</font></H5> </legend>
                         <div layout="row" ${categoryCharacteristicEnableIntStatus2} layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin2" ng-model="customUserParam.intCharacteristicMin2" md-autofocus="false" name="intCharacteristicMin2" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax2" ng-model="customUserParam.intCharacteristicMax2" md-autofocus="false" name="intCharacteristicMax2" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                             </md-input-container>
                           </div>
                           <legend class="demo-legend" ${categoryCharacteristicEnableIntStatus3}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicIntLang3}</font></H5> </legend>
                         <div layout="row" ${categoryCharacteristicEnableIntStatus3} layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin3" ng-model="customUserParam.intCharacteristicMin3" md-autofocus="false" name="intCharacteristicMin3" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax3" ng-model="customUserParam.intCharacteristicMax3" md-autofocus="false" name="intCharacteristicMax3" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                             </md-input-container>
                           </div>
                           <legend class="demo-legend" ${categoryCharacteristicEnableIntStatus4}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicIntLang4}</font></H5> </legend>
                         <div layout="row" ${categoryCharacteristicEnableIntStatus4} layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin4" ng-model="customUserParam.intCharacteristicMin4" md-autofocus="false" name="intCharacteristicMin4" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax4" ng-model="customUserParam.intCharacteristicMax4" md-autofocus="false" name="intCharacteristicMax4" onchange="this.value = parseFloat(this.value.replace(/,/g, '.'))">
                             </md-input-container>
                           </div>
                         <legend class="demo-legend" ${categoryCharacteristicEnableIntStatus5}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicIntLang5}</font></H5> </legend>
                         <div layout="row" ${categoryCharacteristicEnableIntStatus5} layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin5" ng-model="customUserParam.intCharacteristicMin5" md-autofocus="false" onchange="this.value = Math.round(this.value.replace(/,/g, '.'))" name="intCharacteristicMin5">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax5" ng-model="customUserParam.intCharacteristicMax5" md-autofocus="false" onchange="this.value = Math.round(this.value.replace(/,/g, '.'))" name="intCharacteristicMax5">
                             </md-input-container>
                           </div>
                         </div>
                         <!--  --><input type="hidden" class="form-control" id="category"
                         name="category" placeholder="to"
                         value="<%= request.getSession().getAttribute("categoryId") %>">
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus1}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang1}</font></H5> </legend>
                                  <div layout="row" ${categoryCharacteristicEnableStrStatus1} layout-wrap flex>
                                    <div flex="50" ng-repeat="item in items1">
                                      <md-checkbox ng-checked="exists2(item, selected1)" ng-click="toggle2(item, selected1)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset> 
                            </div>
                          </div>
                        </div>
                        <div layout="row" layout-wrap>
                          <div flex="100" flex-gt-sm="150" layout="column">
                            <div>
                                <!--
                                  In IE, we cannot apply flex directly to <fieldset>
                                  @see https://github.com/philipwalton/flexbugs#9-some-html-elements-cant-be-flex-containers
                                -->
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus2}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang2}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex ${categoryCharacteristicEnableStrStatus2}>
                                    <div flex="50" ng-repeat="item in items2">
                                      <md-checkbox ng-checked="exists2(item, selected2)" ng-click="toggle2(item, selected2)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset> 
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus3}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang3}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex ${categoryCharacteristicEnableStrStatus3}>
                                    <div flex="50" ng-repeat="item in items3">
                                      <md-checkbox ng-checked="exists2(item, selected3)" ng-click="toggle2(item, selected3)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset>  
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus4}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang4}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex ${categoryCharacteristicEnableStrStatus4}>
                                    <div flex="50" ng-repeat="item in items4">
                                      <md-checkbox ng-checked="exists2(item, selected4)" ng-click="toggle2(item, selected4)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset> 
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus5}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang5}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex ${categoryCharacteristicEnableStrStatus5}>
                                    <div flex="50" ng-repeat="item in items5">
                                      <md-checkbox ng-checked="exists2(item, selected5)" ng-click="toggle2(item, selected5)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset> 
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus6}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang6}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex ${categoryCharacteristicEnableStrStatus6}>
                                    <div flex="50" ng-repeat="item in items6">
                                      <md-checkbox ng-checked="exists2(item, selected6)" ng-click="toggle2(item, selected6)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset> 
                                <fieldset class="standard" >
                                  <legend class="demo-legend" ${categoryCharacteristicEnableStrStatus7}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStrLang7}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex ${categoryCharacteristicEnableStrStatus7}>
                                    <div flex="50" ng-repeat="item in items7">
                                      <md-checkbox ng-checked="exists2(item, selected7)" ng-click="toggle2(item, selected7)">
                                        {{ item }} <span ng-if="exists2(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset>
          					    <legend class="demo-legend" ${categoryCharacteristicEnableBoolStatus1}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBoolLang1}</font></H5> </legend>
                                <div layout-align="center none" class="parent" ${categoryCharacteristicEnableBoolStatus1}>
				                  <md-switch ng-model="customUserParam.boolCharacteristic1" aria-label="Switch 2" ng-click="updateBoolChar1()">
					                <div align="center">  </div>
					              </md-switch>
					            </div>
							    <legend class="demo-legend" ${categoryCharacteristicEnableBoolStatus2}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBoolLang2}</font></H5> </legend>
                                <div layout-align="center none" class="parent" ${categoryCharacteristicEnableBoolStatus2}>
				                  <md-switch ng-model="customUserParam.boolCharacteristic2" aria-label="Switch 2" ng-click="updateBoolChar2()">
					                <div align="center">  </div>
					              </md-switch>
					            </div>
							    <legend class="demo-legend" ${categoryCharacteristicEnableBoolStatus3}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBoolLang3}</font></H5> </legend>
                                <div layout-align="center none" class="parent" ${categoryCharacteristicEnableBoolStatus3}>
				                  <md-switch ng-model="customUserParam.boolCharacteristic3" aria-label="Switch 3" ng-click="updateBoolChar3()">
					                <div align="center">  </div>
					              </md-switch>
					            </div>
					            <legend class="demo-legend" ${categoryCharacteristicEnableBoolStatus4}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBoolLang4}</font></H5> </legend>
                                <div layout-align="center none" class="parent" ${categoryCharacteristicEnableBoolStatus4}>
				                  <md-switch ng-model="customUserParam.boolCharacteristic4" aria-label="Switch 4" ng-click="updateBoolChar4()">
					                <div align="center">  </div>
					              </md-switch>
					            </div>
					            <legend class="demo-legend" ${categoryCharacteristicEnableBoolStatus5}><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBoolLang5}</font></H5> </legend>
                                <div layout-align="center none" class="parent" ${categoryCharacteristicEnableBoolStatus5}>
				                  <md-switch ng-model="customUserParam.boolCharacteristic5" aria-label="Switch 5" ng-click="updateBoolChar5()">
					                <div align="center">  </div>
					              </md-switch>
					            </div>
								
                               <!-- <input type="hidden" class="form-control" id="category" name="characteristic1" value="{{x}}"> --> 
                              </div>
                            </div>
                          </div>
                        </div>
                        <md-input-container class="md-block">
                        <button type="submit" class="btn btn-default">
                          <locale:message code="label.find" />
                        </button>
                      </form>

                      <md-button ng-click="close()" class="md-primary" hide-gt-md>
                        Close Sidenav Left
                      </md-button>
                      <p hide show-gt-md>
                        This sidenav is locked open on your device. To go back to the default behavior,
                        narrow your display.
                      </p>
                    </md-content>
                  </md-sidenav>

					<div style="background-color: #00000;" height=30px align="right"><!-- #4BC19E -->
                        <md-button class="md-icon-button md-primary" aria-label="Settings" ng-click="toggleRight()"
                          class="md-primary">
                          <md-icon md-svg-icon="img/icons/ic_search_black_24px.svg"></md-icon>
                        </md-button>
					</div>
              </div>
  <div class="row content">
				
				<div class="col-sm-9">


			           	

        <div class="container">
            <div class="row">
                <c:forEach items="${requestScope.products}" var="product">
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                        <sec:authorize access="isAnonymous() or hasRole('user')">
                        <a href="singleProduct?description=<c:out value="${product.description}"></c:out>
&name=<c:out value="${product.name}"></c:out>
&intCharacteristic1=<c:out value="${product.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${product.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${product.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${product.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${product.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${product.characteristic1}"></c:out>
&characteristic2=<c:out value="${product.characteristic2}"></c:out>
&characteristic3=<c:out value="${product.characteristic3}"></c:out>
&characteristic4=<c:out value="${product.characteristic4}"></c:out>
&characteristic5=<c:out value="${product.characteristic5}"></c:out>
&characteristic6=<c:out value="${product.characteristic6}"></c:out>
&characteristic7=<c:out value="${product.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${product.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${product.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${product.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${product.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${product.boolCharacteristic5}"></c:out>
&rating=<c:out value="${product.rating}"></c:out>
&stockStatus=<c:out value="${product.stockStatus}"></c:out>
&image1Path=<c:out value="${product.image1Path}"></c:out>
&image2Path=<c:out value="${product.image2Path}"></c:out>
&image3Path=<c:out value="${product.image3Path}"></c:out>
&image4Path=<c:out value="${product.image4Path}"></c:out>
&image5Path=<c:out value="${product.image5Path}"></c:out>
&image6Path=<c:out value="${product.image6Path}"></c:out>
&price=<c:out value="${product.price}"></c:out>
&productId=<c:out value="${product.productId}"></c:out>
&categoryId=<%= request.getSession().getAttribute("categoryId") %>">        
                        <img src="img/<c:out value="${product.image1Path}"></c:out>" alt=""></a></sec:authorize>
                        
                                                <sec:authorize access="hasRole('admin')">
                        <a href="singleProductAdmin?description=<c:out value="${product.description}"></c:out>
&name=<c:out value="${product.name}"></c:out>
&intCharacteristic1=<c:out value="${product.intCharacteristic1}"></c:out>
&intCharacteristic2=<c:out value="${product.intCharacteristic2}"></c:out>
&intCharacteristic3=<c:out value="${product.intCharacteristic3}"></c:out>
&intCharacteristic4=<c:out value="${product.intCharacteristic4}"></c:out>
&intCharacteristic5=<c:out value="${product.intCharacteristic5}"></c:out>
&characteristic1=<c:out value="${product.characteristic1}"></c:out>
&characteristic2=<c:out value="${product.characteristic2}"></c:out>
&characteristic3=<c:out value="${product.characteristic3}"></c:out>
&characteristic4=<c:out value="${product.characteristic4}"></c:out>
&characteristic5=<c:out value="${product.characteristic5}"></c:out>
&characteristic6=<c:out value="${product.characteristic6}"></c:out>
&characteristic7=<c:out value="${product.characteristic7}"></c:out>
&boolCharacteristic1=<c:out value="${product.boolCharacteristic1}"></c:out>
&boolCharacteristic2=<c:out value="${product.boolCharacteristic2}"></c:out>
&boolCharacteristic3=<c:out value="${product.boolCharacteristic3}"></c:out>
&boolCharacteristic4=<c:out value="${product.boolCharacteristic4}"></c:out>
&boolCharacteristic5=<c:out value="${product.boolCharacteristic5}"></c:out>
&rating=<c:out value="${product.rating}"></c:out>
&stockStatus=<c:out value="${product.stockStatus}"></c:out>
&image1Path=<c:out value="${product.image1Path}"></c:out>
&image2Path=<c:out value="${product.image2Path}"></c:out>
&image3Path=<c:out value="${product.image3Path}"></c:out>
&image4Path=<c:out value="${product.image4Path}"></c:out>
&image5Path=<c:out value="${product.image5Path}"></c:out>
&image6Path=<c:out value="${product.image6Path}"></c:out>
&price=<c:out value="${product.price}"></c:out>
&productId=<c:out value="${product.productId}"></c:out>
&categoryId=<%= request.getSession().getAttribute("categoryId") %>">        
                        <img src="img/<c:out value="${product.image1Path}"></c:out>" alt=""></a></sec:authorize>
                        
                        </div>
							<h2><a><c:out value="${product.name}"></c:out> <c:out value="${product.description}"></c:out></a></h2>
						<div class="product-carousel-price">
                            <ins>$<c:out value="${product.price}"></c:out></ins> <del>$<c:out value="${product.price}"></c:out></del>
                        </div>  
                        <sec:authorize access="hasRole('user') or isAnonymous()">  
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
										&image1Path=<c:out value="${product.image1Path}"></c:out>
										&price=<c:out value="${product.intCharacteristic1}"></c:out>
										&productId=<c:out value="${product.productId}"></c:out>">Add to cart
									</a>
								</div> 
                        </sec:authorize>   
                        <sec:authorize access="hasRole('admin')">  
	                        <div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="${context}/deleteProduct?
										category=<%= request.getSession().getAttribute("categoryId") %>
										&number=1
										&productId=<c:out value="${product.productId}"></c:out>">Delete product
									</a>
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
							 onclick=" this.href='?number=1&intCharacteristicMin1='+document.getElementById('intCharacteristicMin1').value
									 +'&intCharacteristicMax1='+document.getElementById('intCharacteristicMax1').value
									 +'&intCharacteristicMin2='+document.getElementById('intCharacteristicMin2').value
									 +'&intCharacteristicMax2='+document.getElementById('intCharacteristicMax2').value
									 +'&intCharacteristicMin3='+document.getElementById('intCharacteristicMin3').value
									 +'&intCharacteristicMax3='+document.getElementById('intCharacteristicMax3').value
									 +'&intCharacteristicMin4='+document.getElementById('intCharacteristicMin4').value
									 +'&intCharacteristicMax4='+document.getElementById('intCharacteristicMax4').value
									 +'&intCharacteristicMin5='+document.getElementById('intCharacteristicMin5').value
									 +'&intCharacteristicMax5='+document.getElementById('intCharacteristicMax5').value
									 +'&category='+document.getElementById('category').value
									 +'&selectedCharacteristic1='+document.getElementById('selectedCharacteristic1').value
									 +'&selectedCharacteristic2='+document.getElementById('selectedCharacteristic2').value
									 +'&selectedCharacteristic3='+document.getElementById('selectedCharacteristic3').value
									 +'&selectedCharacteristic4='+document.getElementById('selectedCharacteristic4').value
									 +'&selectedCharacteristic5='+document.getElementById('selectedCharacteristic5').value
									 +'&selectedCharacteristic6='+document.getElementById('selectedCharacteristic6').value
									 +'&selectedCharacteristic7='+document.getElementById('selectedCharacteristic7').value
									 +'&boolCharacteristic1='+document.getElementById('boolCharacteristic1').value
									 +'&boolCharacteristic2='+document.getElementById('boolCharacteristic2').value
									 +'&boolCharacteristic3='+document.getElementById('boolCharacteristic3').value
									 +'&boolCharacteristic4='+document.getElementById('boolCharacteristic4').value
									 +'&boolCharacteristic5='+document.getElementById('boolCharacteristic5').value" id="add-product-save-link" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
							<c:forEach items="${requestScope.numberOfPage}" var="number">
							<li><a href='' 
							 onclick=" this.href='?number=${number.numberOfPageId}&intCharacteristicMin1='+document.getElementById('intCharacteristicMin1').value+'&intCharacteristicMax1='+document.getElementById('intCharacteristicMax1').value
							 +'&intCharacteristicMin2='+document.getElementById('intCharacteristicMin2').value
							 +'&intCharacteristicMax2='+document.getElementById('intCharacteristicMax2').value
							 +'&intCharacteristicMin3='+document.getElementById('intCharacteristicMin3').value
							 +'&intCharacteristicMax3='+document.getElementById('intCharacteristicMax3').value
							 +'&intCharacteristicMin4='+document.getElementById('intCharacteristicMin4').value
							 +'&intCharacteristicMax4='+document.getElementById('intCharacteristicMax4').value
							 +'&intCharacteristicMin5='+document.getElementById('intCharacteristicMin5').value
							 +'&intCharacteristicMax5='+document.getElementById('intCharacteristicMax5').value
							 +'&category='+document.getElementById('category').value
							 +'&selectedCharacteristic1='+document.getElementById('selectedCharacteristic1').value
							 +'&selectedCharacteristic2='+document.getElementById('selectedCharacteristic2').value
							 +'&selectedCharacteristic3='+document.getElementById('selectedCharacteristic3').value
							 +'&selectedCharacteristic4='+document.getElementById('selectedCharacteristic4').value
							 +'&selectedCharacteristic5='+document.getElementById('selectedCharacteristic5').value
							 +'&selectedCharacteristic6='+document.getElementById('selectedCharacteristic6').value
							 +'&selectedCharacteristic7='+document.getElementById('selectedCharacteristic7').value
							 +'&boolCharacteristic1='+document.getElementById('boolCharacteristic1').value
							 +'&boolCharacteristic2='+document.getElementById('boolCharacteristic2').value
							 +'&boolCharacteristic3='+document.getElementById('boolCharacteristic3').value
							 +'&boolCharacteristic4='+document.getElementById('boolCharacteristic4').value
							 +'&boolCharacteristic5='+document.getElementById('boolCharacteristic5').value" id="add-product-save-link">${number.numberOfPageId}</a>
							 </li>
							 </c:forEach>
                        <li>
                          <a href='' 
							 onclick=" this.href='?number=2&intCharacteristicMin1='+document.getElementById('intCharacteristicMin1').value
								 +'&intCharacteristicMax1='+document.getElementById('intCharacteristicMax1').value
								 +'&intCharacteristicMin2='+document.getElementById('intCharacteristicMin2').value
								 +'&intCharacteristicMax2='+document.getElementById('intCharacteristicMax2').value
								 +'&intCharacteristicMin3='+document.getElementById('intCharacteristicMin3').value
								 +'&intCharacteristicMax3='+document.getElementById('intCharacteristicMax3').value
								 +'&intCharacteristicMin4='+document.getElementById('intCharacteristicMin4').value
								 +'&intCharacteristicMax4='+document.getElementById('intCharacteristicMax4').value
								 +'&intCharacteristicMin5='+document.getElementById('intCharacteristicMin5').value
								 +'&intCharacteristicMax5='+document.getElementById('intCharacteristicMax5').value
								 +'&category='+document.getElementById('category').value
								 +'&selectedCharacteristic1='+document.getElementById('selectedCharacteristic1').value
								 +'&selectedCharacteristic2='+document.getElementById('selectedCharacteristic2').value
								 +'&selectedCharacteristic3='+document.getElementById('selectedCharacteristic3').value
								 +'&selectedCharacteristic4='+document.getElementById('selectedCharacteristic4').value
								 +'&selectedCharacteristic5='+document.getElementById('selectedCharacteristic5').value
								 +'&selectedCharacteristic6='+document.getElementById('selectedCharacteristic6').value
								 +'&selectedCharacteristic7='+document.getElementById('selectedCharacteristic7').value
								 +'&boolCharacteristic1='+document.getElementById('boolCharacteristic1').value
								 +'&boolCharacteristic2='+document.getElementById('boolCharacteristic2').value
								 +'&boolCharacteristic3='+document.getElementById('boolCharacteristic3').value
								 +'&boolCharacteristic4='+document.getElementById('boolCharacteristic4').value
								 +'&boolCharacteristic5='+document.getElementById('boolCharacteristic5').value" id="add-product-save-link" aria-label="Next">
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