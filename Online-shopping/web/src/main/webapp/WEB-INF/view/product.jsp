<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

              <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
              <script src="js/payments.js"> </script>
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
    

    
 


 
   <style>
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
			                    <li class="<c:out value="${category.selectedItem}"></c:out>"><a href="product?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
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

                  <md-sidenav
                  class="md-sidenav-left"
                  md-component-id="left"
                  md-is-locked-open="$mdMedia('gt-md')"
                  md-whiteframe="4">

                    <md-content layout-padding ng-controller="LeftCtrl">    
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
                        <input hidden="true" type="text" id="selectedCharacteristic1" name="selectedCharacteristic1" value="{{selected1}}">
                        <input hidden="true" type="text" id="selectedCharacteristic2" name="selectedCharacteristic2" value="{{selected2}}">
                        <input hidden="true" type="text" id="selectedCharacteristic3" name="selectedCharacteristic3" value="{{selected3}}">
                        <input hidden="true" type="text" id="selectedCharacteristic4" name="selectedCharacteristic4" value="{{selected4}}">
                        <input hidden="true" type="text" id="selectedCharacteristic5" name="selectedCharacteristic5" value="{{selected5}}">
                        <input hidden="true" type="text" id="selectedCharacteristic6" name="selectedCharacteristic6" value="{{selected6}}">
                        <input hidden="true" type="text" id="selectedCharacteristic7" name="selectedCharacteristic7" value="{{selected7}}">
                        <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicInt1.categoryCharacteristicNameLanguageOne}</font></H5> </legend>        
                          <div layout="row" layout-align="center">
                           <md-input-container >
                             <label for="testInput1" >Min</label>
                             <input type="text" id="intCharacteristicMin1" ng-model="customUserParam.intCharacteristicMin1" md-autofocus="" name="intCharacteristicMin1" ><!-- name="priceLower" -->
                           </md-input-container>
                           <md-input-container >
                             <label for="testInput2" >Max</label>
                             <input type="text" id="intCharacteristicMax1" ng-model="customUserParam.intCharacteristicMax1" md-autofocus="" name="intCharacteristicMax1">
                           </md-input-container>
                         </div>
                         <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicInt2.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                         <div layout="row" layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin2" ng-model="customUserParam.intCharacteristicMin2" md-autofocus="" name="intCharacteristicMin2">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax2" ng-model="customUserParam.intCharacteristicMax2" md-autofocus="" name="intCharacteristicMax2">
                             </md-input-container>
                           </div>
                           <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicInt3.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                         <div layout="row" layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin3" ng-model="customUserParam.intCharacteristicMin3" md-autofocus="" name="intCharacteristicMin3">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax3" ng-model="customUserParam.intCharacteristicMax3" md-autofocus="" name="intCharacteristicMax3">
                             </md-input-container>
                           </div>
                           <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicInt4.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                         <div layout="row" layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin4" ng-model="customUserParam.intCharacteristicMin4" md-autofocus="" name="intCharacteristicMin4">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax4" ng-model="customUserParam.intCharacteristicMax4" md-autofocus="" name="intCharacteristicMax4">
                             </md-input-container>
                           </div>
                         <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicInt5.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                         <div layout="row" layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Min</label>
                               <input type="text" id="intCharacteristicMin5" ng-model="customUserParam.intCharacteristicMin5" md-autofocus="" name="intCharacteristicMin5">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Max</label>
                               <input type="text" id="intCharacteristicMax5" ng-model="customUserParam.intCharacteristicMax5" md-autofocus="" name="intCharacteristicMax5">
                             </md-input-container>
                           </div>
                         </div>
                         <!--  --><input type="hidden" class="form-control" id="category"
                         name="category" placeholder="to"
                         value="<%= request.getSession().getAttribute("categoryId") %>">
                                <fieldset class="standard" >
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr1.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr2.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr3.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr4.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr5.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr6.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicStr7.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
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
							    <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBool1.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                <div layout-align="center none" class="parent">
				                  <md-switch ng-model="data.cb1" aria-label="Switch 1">
					                <div align="center">  Switch 1: {{ data.cb1 }}</div>
					              </md-switch>
					            </div>
							    <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBool2.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                <div layout-align="center none" class="parent">
				                  <md-switch ng-model="data.cb1" aria-label="Switch 2">
					                <div align="center">  Switch 2: {{ data.cb1 }}</div>
					              </md-switch>
					            </div>
							    <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>${categoryCharacteristicBool3.categoryCharacteristicNameLanguageOne}</font></H5> </legend>
                                <div layout-align="center none" class="parent">
				                  <md-switch ng-model="data.cb1" aria-label="Switch 3">
					                <div align="center">  Switch 3: {{ data.cb1 }}</div>
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

					<div style="background-color: #00000;" height=30px><!-- #4BC19E -->
                        <md-button class="md-icon-button md-primary" aria-label="Settings" ng-click="toggleLeft()"
                          class="md-primary" hide-gt-md>
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
									 +'&selectedCharacteristic7='+document.getElementById('selectedCharacteristic7').value" id="add-product-save-link" aria-label="Previous">
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
							 " id="add-product-save-link">${number.numberOfPageId}</a>
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
								 +'&selectedCharacteristic7='+document.getElementById('selectedCharacteristic7').value" id="add-product-save-link" aria-label="Next">
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