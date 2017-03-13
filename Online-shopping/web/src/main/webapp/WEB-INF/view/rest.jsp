<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="locale" %>
<!DOCTYPE html> 
<html> 

<style >
  .checkboxdemoSyncing .checkboxDemo1 div {
    clear: both; }

    .checkboxdemoSyncing legend {
      color: #3F51B5; }

      .checkboxdemoSyncing legend code {
        color: #3F51B5;
        font-weight: normal; }

        .checkboxdemoSyncing p {
          padding-left: 8px; }

          .checkboxdemoSyncing .info {
            padding-left: 13px; }

            .checkboxdemoSyncing div.standard {
              padding: 8px;
              padding-left: 25px; }

              .checkboxdemoSyncing fieldset.standard {
                border-style: solid;
                border-width: 0px;
                height: 100%; }

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

                md-checkbox.md-checked.green .md-icon {
                 background-color: rgba(255, 203, 100, 0.87);
                 margin: 0px;
                 cursor: pointer;
                 padding-left: 0px;
                 padding-right: 0;
                 line-height: 6px;
                 min-width: 10px;
                 min-height: 10px;
               }
               
               .switchdemoBasicUsage .inset {
               	  background-color: #555;
				  padding-left: 25px;
				  padding-top: 25px;
			   }

				.parent {
				margin-left: 14%;
			   } 
			   
             </style>
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

            </head>
            <body ng-app="payments"> 

              <div ng-controller="AppCtrl" layout="column" style="height:500px;" ng-cloak>

                <section layout="row" flex>

                  <md-sidenav
                  class="md-sidenav-left"
                  md-component-id="left"
                  md-is-locked-open="$mdMedia('gt-md')"
                  md-whiteframe="4">

                    <md-toolbar class="md-theme-indigo">
                      <h1 class="md-toolbar-tools" style="background-color: #4BC19E">Search</h1>
                    </md-toolbar>

                    <md-content layout-padding ng-controller="LeftCtrl">    
                      <form method="get"  action="input5.php" class="form-horizontal">
                        <div layout="column">
                          <div layout="row" layout-align="center">
                           <md-input-container >
                             <label for="testInput" >Price lower</label>
                             <input type="text" ng-model="user.title" md-autofocus="" name="priceLower">
                           </md-input-container>
                           <md-input-container >
                             <label for="testInput" >Price highter</label>
                             <input type="text" id="testInput" ng-model="user.email" md-autofocus="" name="priceHighter">
                           </md-input-container>
                         </div>
                         <div layout="row" layout-align="center">
                            <md-input-container >
                               <label for="testInput" >Price lower</label>
                               <input type="text" id="testInput" ng-model="data" md-autofocus="">
                             </md-input-container>
                             <md-input-container >
                               <label for="testInput" >Price highter</label>
                               <input type="text" id="testInput" ng-model="data" md-autofocus="" ng-value="name">
                             </md-input-container>
                           </div>
                         </div>
                         <input type="hidden" class="form-control" id="category"
                         name="category" placeholder="to"
                         value="<">
                         <div ng-controller="NewAppCtrl as ctrl" class="md-padding checkboxdemoSyncing" ng-cloak style="min-height:100px">
                          <div layout="row" layout-wrap>
                            <div flex="100" flex-gt-sm="150" layout="column">
                              <div>
                              <!--
                                In IE, we cannot apply flex directly to <fieldset>
                                @see https://github.com/philipwalton/flexbugs#9-some-html-elements-cant-be-flex-containers
                              -->
                              <fieldset class="standard" >
                                <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>Characteristic1</font></H5> </legend>
                                <div layout="row" layout-wrap flex>
                                  <div flex="50" ng-repeat="item in items">
                                    <md-checkbox class="green" ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                      {{ item }} <span ng-if="exists(item)">selected</span>
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
                                  <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>Characteristic2</font></H5> </legend>
                                  <div layout="row" layout-wrap flex>
                                    <div flex="50" ng-repeat="item in items">
                                      <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox>
                        <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                        {{ item }} <span ng-if="exists(item)">selected</span>
                                      </md-checkbox> -->
                                    </div>
                                  </div>
                                </fieldset>
							    <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>One</font></H5> </legend>
                                <div layout-align="center none" class="parent">
				                  <md-switch ng-model="data.cb1" aria-label="Switch 1">
					                <div align="center">  Switch 1: {{ data.cb1 }}</div>
					              </md-switch>
					            </div>
							    <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>Two</font></H5> </legend>
                                <div layout-align="center none" class="parent">
				                  <md-switch ng-model="data.cb1" aria-label="Switch 2">
					                <div align="center">  Switch 2: {{ data.cb1 }}</div>
					              </md-switch>
					            </div>
							    <legend class="demo-legend"><H5 class="md-title"><font size="3" color=#000000>Three</font></H5> </legend>
                                <div layout-align="center none" class="parent">
				                  <md-switch ng-model="data.cb1" aria-label="Switch 3">
					                <div align="center">  Switch 3: {{ data.cb1 }}</div>
					              </md-switch>
					            </div>
								
                                <input type="hidden" class="form-control" id="category" name="characteristic1" value="{{x}}">
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

                  <md-content flex layout-padding>
                    <div layout="column" layout-align="top center">
                      <p>
                        The left sidenav will 'lock open' on a medium (>=960px wide) device.
                      </p>
                      <p>
                        The right sidenav will focus on a specific child element.
                      </p>
                      <div>
                        <md-button ng-click="toggleLeft()"
                          class="md-primary" hide-gt-md>
                          Toggle left
                        </md-button>
                      </div>
                      <div>
                        <md-button ng-click="toggleRight()"
                        ng-hide="isOpenRight()"
                        class="md-primary">
                        Toggle right
                        </md-button>
                      </div>
                    </div>
                    <div flex></div>
                  </md-content>

                  <md-sidenav class="md-sidenav-right md-whiteframe-7dp" md-component-id="right">
                    <md-toolbar class="md-theme-light">
                      <h1 class="md-toolbar-tools" style="background-color: #4BC19E">Sidenav Right</h1>
                    </md-toolbar>
                    <md-content ng-controller="RightCtrl" layout-padding>
                      <form method="get"  action="input5.php" class="form-horizontal">
                        <div class="form-group">
                         <label for="priceLower" class="col-sm-3 control-label" width="60px">Price</label>
                           <div class="col-sm-4">
                             <input type="text" 
                             class="form-control" id="priceLower" placeholder="from"
                             name="priceLower"
                             value=""">
                           </div>
                           <div class="col-sm-4">
                            <input type="text" class="form-control" id="priceHighter"
                            name="priceHighter" placeholder="to"
                            value="">
                          </div>
                        </div>
                        <div class="form-group">

                        <input type="hidden" class="form-control" id="category"
                        name="category" placeholder="to"
                        value="<"></div>

                        <div class="form-group">
                          Characteristic 1
                          <select name="characteristics1" id="characteristics1">
                          </select>
                        </div>

                       <div ng-controller="NewAppCtrl as ctrl" class="md-padding checkboxdemoSyncing" ng-cloak style="min-height:270px">
                        <div layout="row" layout-wrap>
                          <div flex="100" flex-gt-sm="150" layout="column">
                            <div>
                              <!--
                                In IE, we cannot apply flex directly to <fieldset>
                                @see https://github.com/philipwalton/flexbugs#9-some-html-elements-cant-be-flex-containers
                              -->
                              <fieldset class="standard" >
                                <legend class="demo-legend"><H1><font size="3" color=#000000>Characteristic1</font></H1> </legend>
                                <div layout="row" layout-wrap flex>
                                  <div flex="50" ng-repeat="item in items">
                                    <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                      {{ item }} <span ng-if="exists(item)">selected</span>
                                    </md-checkbox>
                      <!--               <md-checkbox ng-checked="exists(item, selected)" ng-click="toggle(item, selected)">
                                      {{ item }} <span ng-if="exists(item)">selected</span>
                                    </md-checkbox> -->
                                  </div>
                                </div>
                              </fieldset>
                            </div>
                          </div>
                          {{x}} and {{z}} and {{m}}
                          <div flex="100" ng-repeat="account in ctrl.accounts">
                            <!-- <div ng-init="ctrl.edit($event, account)"></div>  -->
                            <h2 class="md-title">Selected Items</h2>
                            <span >{{account.title}}</span>
                          </div>
                        </div>
                      </div>
                         <md-input-container class="md-block">
                         <button type="submit" class="btn btn-default">
                           <locale:message code="label.find" />
                         </button>
                    </form>
                      <md-button ng-click="close()" class="md-primary">
                        Close Sidenav Right
                      </md-button>
                    </md-content>
                  </md-sidenav>
                </section>
              </div>
            </body>
          </html>