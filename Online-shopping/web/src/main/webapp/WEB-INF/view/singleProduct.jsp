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
              <link rel="stylesheet" href="<c:url value="/css/flexslider.css" />" type="text/css" media="screen" />
              <link rel="stylesheet" href="<c:url value="/css/owl.carousel.css" />" rel="stylesheet">
              <link rel="stylesheet" href="<c:url value="/css/styleMain.css" />" rel="stylesheet"> 
              <link rel="stylesheet" href="<c:url value="/css/responsive.css" />" rel="stylesheet"> 

              <script src="https://code.jquery.com/jquery-1.9.1.js"></script>
              <script src="js/payments.js"> </script>
              
              <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
	<script src="js/simpleCart.min.js"> </script>
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	
	  <style>
		.letter {
		    text-transform: uppercase;
		}
		
		.flexslider {
		    width: 300px;
		    height: 520px;
		}
		
		 .flexslider .slides img {
		    width: 300
		    height: 520px;
		} 
		
		img {
		    max-width: 220%;
		    height: auto;
		}
		
		/*
/* Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/



ul.total_price li.last_price {
  width: 50%;
  float: left;
}
ul.total_price li.last_price {
  width: 50%;
  float: left;
}
ul.total_price li.last_price  h4 {
  font-size: 1em;
}
a.order {
  background:#DF4782;
  padding: 10px 20px;
  font-size: 1em;
  color: #fff;
  text-decoration: none;
  display: block;
  font-weight: 600;
  text-align: center;
  margin: 3em 0;
}
a.order:hover{
	background:#df4782;
}
.cart-item-info h3 span {
  display: block;
  font-size: 0.9em;
  margin-top: 1em;
}
.delivery {
  margin-top: 3em;
}
.total-item {
  margin-top: 2em;
  padding-bottom: 2em;
}
.total-item h3 {
  color: #31C2DB;
  font-size: 1em;
  margin-bottom: 1em;
}
.total-item h4 {
  font-size: .9em;
  color: #31C2DB;
  display: inline-block;
  margin-right: 10%;
}
a.cpns {
  background:#df4782;
  color: #fff;
  padding: 10px;
  font-size: 0.8em;
  font-weight: 600;
}
.total-item p {
  font-size: 0.9em;
  margin-top: 1em;
  color: #727272;
}
.total-item p a {
  color: rgb(223, 71, 130);
  font-size: 1em;
}
/*--responsive design--*/
@media (max-width:1024px){
.header_right {
  width: 30%;
  margin-top: 1em;
}
.logo {
  padding: 16px;
}
.banner_right {
  width: 50%;
}
ul.list1 a {
  font-size: 0.9em;
}
.logo a h6 {
  letter-spacing: 4px;
}
.logo a h2 {
  font-size: 3.6em;
}
.content_box {
  padding: 2em 0 3em;
}
.search input[type="text"] {
   width: 84.2%;
}
.welcome_box h2 {
  font-size: 1.3em;
}
.banner_right h1 {
  font-size:2.8em;
}
.wmuSliderPrev {
	left: 54em;
}
.banner_right p {
	font-size: 1em;
}
.header-top {
	padding: 0.7em 0 2em;
}
.mens-toolbar .sort {
  width: 21.5%;
}
.btn_form form input[type="submit"] {
  font-size: 13px;
  padding: 8px 12px;
  margin-top: 1em;
}
.span_2_of_a1 h1 {
  font-size: 1.3em;
}  
.welcome_box {
	padding:4em 1.4em;
}
.welcome_box p {
	font-size: 16px;
}
ul.nav li a, ul.category_nav li a{
  font-size: .8em;
}  
h3.menu_head {
  padding: 2em 0 2em 2em;
}  
.tags {
	padding: 1em;
}
.view .mask, .view .content {
	top: 8em;
	left: 4.5em;
}
p.title, .price{
	font-size: .8em;
}
ul.tags_links li {
	margin: 6px 1px;
}
ul.brand_icons li {
	width: 12.2%;
}
ul.instagram_grid li {
	width: 15.781%;
}
i.fb {
	width:313px;
	height: 130px;
}
i.tw {
	width:313px;
	height: 130px;
}
i.pin {
	width:313px;
	height: 130px;
}
p.f_text, p.email{
	font-size: .8em;
}
.etalage_zoom_area div {
    width:350px !important;
    height:350px !important;
}
ul.size li {
	margin: 0 1px 0 0;
}
.contact_logo {
	left: 4em;
}
h5.empty {
  margin: -27px 0 0 0;
}
.search_footer input[type="text"] {
  width: 91%;
}
ul.cart p {
  font-size: 11px;
}
}
@media (max-width:991px){
.bannertop_box {
  width: 40%;
}
 .logo {
  padding: 25px 53px;
}
.footer-grid:nth-child(4) {
  margin: 0;
  width: 25%;
}
.search input[type="submit"] {
  background-position: 13px 10px;
  padding: 6px 23px;
}
.search_footer input[type="text"] {
  font-weight: 600;
}
.search input[type="submit"]:hover {
  background-position: 13px 10px;
}
p.footer_desc {
  font-size: 0.9em;
}
.banner_right {
  margin-top: 2em;
}
.banner_btn {
  margin-top: 2.5em;
}
.col-md-3 {
  float: left;
  width: 25%;
  padding: 0;
}
.col-md-9 {
  float: right;
  width: 75%;
  padding-right: 0;
}
h3.m_1 {
  margin-top: 0em;
}
.span_1_of_3 {
  width: 31%;
}
a.item_1 {
  right: -6px;
}
h3.m_2 {
  margin-top: 2em;
}
.side_banner .banner_holder {
  position: absolute;
  left: 0em;
  top: 5em;
  width: 100%;
  text-align: center;
}
ul.brand_icons li {
  width: 15.4%;
  margin-right: 2em;
}
.content_box {
  padding: 2em 0 0em;
}
ul.instagram_grid li {
  width: 15.5%;
}
i.tw {
  width: 241px;
  height: 100px;
}
i.fb {
  width: 241px;
  height: 100px;
}
i.pin {
  width: 241px;
  height: 100px;
}
.login-right {
  padding: 0;
  margin-top: 2em;
}
.login-left p, .login-right p {
  margin: 0 0 1em 0;
}
.about_box{
  width: 40.5%;
  float: left;
}
.check_box {
  padding: 4em 0;
}
.cart-items {
  float: left;
  width: 69%;
  padding: 0;
}
a.cpns {
  padding: 4px 5px;
}
.cart-total {
  float: right;
  width: 25%;
}
.check_box {
  padding: 4em 0 2em;
}
}
@media (max-width:667px){
.banner_right {
   margin:0;
}
.price {
  float:none;
}
.side_banner .banner_holder {
  left: -21em;
}
.bannertop_box {
	width: 31%;
}
.header_right {
	width: 48%;
	margin-top: 3em;
}
.search input[type="text"] {
	width: 81.5%;
}
.welcome_box {
	display: none;
}
.banner_right p {
	font-size: .8em;
}
.btn_form form input[type="submit"] {
  font-size: 2.5em;
}
.header_right {
  margin-top: 1em;
}
.banner_right h1 {
	font-size: 1.4em;
}
.banner_btn {
	padding: 8px 15px;
	margin-top: 1em;
	font-size: .8em;
}
h3.menu_head {
	padding: 1em 0 1em 3em;
}
ul.brand_icons li {
	width: 10.2%;
}
.cart-left {
  float: none;
  margin-right: 0;
}
span.item_price {
  float: none;
}
a.item_1 {
  bottom: 65px;
}
ul.instagram_grid li {
	width: 15.2%;
}
i.fb {
	width: 198px;
	height: 90px;
}
i.tw {
	width: 197px;
	height: 90px;
}
i.pin {
	width: 198px;
	height: 90px;
}
.footer-grid {
	float: none;
	width: 100%;
	margin-right: 0;
	margin-bottom:2em;
}
.footer-grid:nth-child(4) {
  width: 100%;
}
.footer-grid h3 {
	margin-bottom: 0.5em;
}
.product_container {
	padding: 1em 0;
}
p.footer_desc {
	margin:0px 0 20px;
}
.footer{
	padding:2em 0 0;
}
.about_box{
	width: 31%;
}
p.cart_desc {
	font-size: 0.85em;
	margin-top: 10px;
}
.mens-toolbar .sort {
	width: 25.5%;
}
.span_2_of_a1 {
	width: 100%;
	margin-left: 0;
}
.span_1_of_a1 {
  width: 100%;
}
.labout {
  float: none;
  margin: 0;
}
.sap_tabs {
  padding: 2em 0 2em;
}
h3.like, h3.recent {
  font-size: 1.1em;
}  
}
@media (max-width:640px){
.bannertop_box {
  width: 40%;
    margin-bottom: 2em;
}
.search input[type="submit"] {
  background-position:12px 10px;
  padding: 6px 22px;
}
.side_banner .banner_holder {
  left: 0em;
}
.banner_img {
  width: 29%;
  margin: 0 auto;
}
.side_banner .banner_holder {
  top: 4em;
}
.tags {
  margin-top: 1em;
}
.content_box {
  padding: 2em 0 1em;
}
ul.brand_icons li {
  width: 16%;
  margin-right: 1em;
}
.btn_form form input[type="submit"] {
  font-size: 1.5em;
}
i.tw {
  width: 199px;
}
.about_box {
  width: 45%;
  margin-bottom: 1.5em;
}
.col-md-3 {
  float: none;
  width: 100%;
  padding:0 1em;
}
.col-md-9 {
  float: none;
  width: 100%;
  padding:0 1em;
}
.span_1_of_contact {
  float: none;
  width: 100%;
}
.contact_grid {
  float: none;
  width: 100%;
  margin-top: 2em;
}
.search input[type="submit"] {
  background-position: 15px 10px;
  padding: 6px 25px;
}
.search input[type="submit"]:hover {
  background-position: 15px 10px;
}
}
@media (max-width:568px){
.logo img {
  width: 110px;
}	
ul.social {
  margin-right: 1em;
}
.header_right {
  width: 55%;
}
.bannertop_box {
  width: 40%;
}
.banner_right h1 {
  font-size: 1.3em;
}
ul.quick_access li a, ul.login li a, ul.cart p, h5.empty{
  font-size: 11px;
}  
h3.m_1, h3.m_2{
  font-size: 1.1em;
}  
.brands {
  padding: 10px;
}
span.small {
  font-size: 15px;
}
ul.instagram_grid li img {
  border: 2px solid #fff;
}
ul.instagram_grid li {
  width: 14.9%;
}
.instagram_top {
  padding: 2em 0;
}
i.fb {
  width: 159px;
  height: 90px;
  display: block;
  background-size: 30%;
}
i.tw {
  width: 159px;
  height: 90px;
  display: block;
  background-size: 30%;
}
i.pin {
  width: 159px;
  height: 90px;
  display: block;
  background-size: 30%;
}
.side_banner .banner_holder {
  left: -14em;
}
h4.tag_head {
  font-size: 1em;
}  
.about_box{
  width: 39%;
}
.mens-toolbar .sort {
  width: 31.5%;
}
.cbp-vm-add {
  margin: 10px 0 0;
}  
.pages .limiter, .sort-by{
  font-size: 12px;
}  
.dreamcrub {
  margin: 2em 0 1em;
}
.mens-toolbar {
  margin-bottom: 1em;
}
.side_banner .banner_holder h3 {
  font-size: 30px;
  margin: 0;
}
.map iframe{
  height:200px;
}
.contact_logo img{
  width:110px;
}
.check_box {
  padding: 3em 0;
}
.cart-items h1 {
  font-size: 1.2em;
  margin-bottom: 1.5em;
}
.cart-item-info h3 {
  font-size: 0.95em;
}
.delivery {
  margin-top: 1em;
}
.delivery p, .delivery span{
  font-size:.8em;
}
}
@media (max-width:480px){
.logo a h2 {
  font-size: 3em;
}
.banner_img {
  width: 87%;
}
h5.empty a, ul.cart p a {
  letter-spacing: 1px;
}
.typo {
  padding: 2em 0;
}
h3.typo-title {
  font-size: 2em;
}
.last_1{
	display:none;
}
.header_right {
  width: 100%;
  margin-top: 0;
  float: none;
}
.container {
  padding:0 10px;
}
.copy {
  text-align: center;
}
.copy p {
  font-size: 12px;
}
.footer-grid h3 {
  font-size: 1.1em;
}  
.logo {
  margin: 0 0 1em 0;
  float: none;
  text-align: center;
  padding: 15px 53px;
}
i.cart_icon {
  width: 25px;
  height: 22px;
  float: left;
  background: url(../images/cart.png)no-repeat 0px 0px;
  margin-right: 10px;
}
ul.login {
  padding: 5px 5px;
}
ul.quick_access{
  padding:0px 5px 5px;
}
ul.quick_access li a, ul.login li a, ul.cart p, h5.empty {
  font-size: 13px;
}
ul.social {
  margin:0;
}
h5.empty {
  margin: 0;
}
.search input[type="text"] {
  width:85.5%;
  font-size: 11px;
}
.header_right {
  width:85%;
}
ul.social {
  margin-right: 0em;
}
.lang_list {
  float: right;
}
.bannertop_box {
  width:48%;
}
.banner_right p {
  display: none;
}
.banner_btn {
  padding: 5px 12px;
  margin-top: 01em;
  font-size: 11px;
}
.header-top {
  padding: 5px 0 5px;
}
ul.nav li a, ul.category_nav li a {
  padding: 10px 10px 10px 30px;
}
h3.menu_head {
  padding: 1em 0 1em 2em;
}
.side_banner .banner_holder {
  left: 0em;
  top: 4em;
}
ul.women_pagenation li a {
  font-size: .7em;
}
.product_image {
  border: 4px solid #fff;
}
.banner_right h1 {
  font-size: 0.95em;
  font-weight: 400;
}
.side_banner .banner_holder h3 {
	font-size: 30px;
}
.search input[type="submit"] {
  padding: 4px 15px;
  background: url('../images/search.png') no-repeat 7px 8px #333;
}  
.search input[type="submit"]:hover {
  background: url('../images/search.png') no-repeat 7px 8px #df4782;
}
h3.m_1 {
  font-size:1em;
}
span.item_price {
  font-size: .8em;
}  
a.item_1 {
  bottom: 55px;
}
.instagram_top {
  padding: 1em 0;
}
.span_1_of_3 {
  width: 48.6%;
}
p.title, .price {
  font-size: 12px;
}
h3.m_2 {
	font-size: 1em;
	margin-top: 2em;
}
ul.brand_icons li {
  width: 23%;
}
ul.instagram_grid li {
	width: 15.4%;
	margin-right: 4px;
}
.content_box {
  padding: 2em 0 0em;
}
.banner_img .img-responsive, .thumbnail > img, .thumbnail a > img, .carousel-inner > .item > img, .carousel-inner > .item > a > img {
  max-width: 39%;
  margin: 0 auto;
}
.register-top-grid div, .register-bottom-grid div {
  width: 100%;
}
.register-top-grid input[type="text"], .register-bottom-grid input[type="text"] {
  padding: 0.3em;
}
.row {
  margin-right: -10px;
  margin-left: -10px;
}
i.fb {
  width: 95px;
  height: 65px;
  display: block;
  background-size: 30%;
    margin: 0 auto;
}
i.tw {
  width: 95px;
  height: 65px;
  display: block;
  background-size: 30%;
    margin: 0 auto;
}
i.pin {
  width: 95px;
  height: 65px;
  background-size: 30%;
    margin: 0 auto;
}
.about_box{
	width:49%;
}
.category {
  margin-top: 1em;
}
.span_2_of_a1 h1 {
	font-size: 1.2em;
}
.sap_tabs {
	padding: 1em 0 2em;
}
h3.like, h3.recent {
	font-size:0.95em;
}
.btn_form form input[type="submit"] {
	font-size: 0.85em;
	padding: 10px 10px;
}
.mens-toolbar .sort {
	width: 52.5%;
}
.singel_right {
  margin-top: 1em;
}
.nbs-flexisel-nav-left, .nbs-flexisel-nav-right {
  margin-top: 5em;
}
p.comment-form-author {
  margin-bottom: 1em;
}
.span_1_of_contact {
  width: 100%;
  float: none;
}
.contact_grid {
  float: none;
  width: 100%;
  margin-top: 1.5em;
}
.map {
  margin-top: 1em;
}
}
@media (max-width: 320px){
.logo {
  margin: 0.5em 0 1em;
  padding: 15px 53px;
}
.banner_img {
  width: 100%;
}
.col-md-3 {
  padding: 0;
}
.bannertop_box {
  width: 100%;
  float: none;
    margin-top: 2em;
}
ul.brand_icons {
  text-align: center;
}
.side_banner .banner_holder {
  top: 2em;
}
h3.quick {
  font-size: 1.2em;
  margin-bottom: .3em;
}
.logo a h2 {
  font-size: 2.2em;
}
.logo a h6 {
  letter-spacing: 2px;
  font-size: 0.8em;
}
.search input[type="submit"] {
  padding: 4px 21px;
  background-position:12px 8px;
}
.search input[type="submit"]:hover {
  background-position:12px 8px;
}
.banner_right {
  width: 100%;
  float: none;
  text-align: center;
  margin: 1em 0;
}
.side_banner .banner_holder h3 {
  font-size: 18px;
  line-height: 26px;
}
.side_banner .banner_holder {
  top: 3em;
}
.tags {
  margin-top: 1em;
}
.tags {
  margin-top: 0em;
}
.row h3.m_1{
  margin-top: 0.5em;
  font-size: 1.6em;
}
a.item_1 {
  width: 30px;
  height: 30px;
  right: 2px;
  background-position:4px 4px;
}
ul.brand_icons li {
  width: 47%;
  margin-top: 1em;
}
.instagram h3 {
  font-size: 1.6em;
}
span.small {
  font-size: 11px;
}
ul.breadcrumbs li {
  font-size: 0.9em;
}
ul.breadcrumbs li.women {
  padding: 3px;
}
.product_container {
  padding: 10px 0;
}
.cbp-vm-view-list .cbp-vm-details {
  width: 51%;
  padding: 0;
  margin-top: 0;
}
.cbp-vm-view-list .cbp-vm-image {
  width: 50%;
}
.col-md-9.cart-items {
  padding: 0;
}
.cbp-vm-view-list .cbp-vm-add {
  float: none;
  display: block;
  text-align: center;
}
.cart-item-info h3 {
  font-size: 13px;
}
a.continue {
  padding: 8px 15px;
  font-size: 0.85em;
  margin-bottom: 2em;
}
.cart-sec {
  margin-bottom: 2em;
}
a.order {
  padding: 8px 15px;
  font-size: 0.95em;
  margin: 1em 0;
}
.col-md-3.cart-total {
  padding: 0;
}
.check_box {
  padding: 3em 0 1em;
}
.span_1_of_contact {
	width: 100%;
}
.lcontact {
	float:none;
	margin:0;
}
.span_2_of_contact_right {
	width: 100%;
}
.contact_grid {
	display: block;
	float: none;
}
.contact-form input[type="submit"] {
  padding: 4px 20px;
  font-size: 0.8em;
}
.register-top-grid div, .register-bottom-grid div {
	width: 98%;
	float: none;
}
.btn_form form input[type="submit"] {
  font-size: 0.7em;
  padding: 7px 7px;
}
h2.resp-accordion {
  font-size: 0.8em;
  padding: 10px 13px;
}
.acount-btn {
  font-size: 0.8em;
  padding: 0.5em 1em;
}
.pop_up h4 {
  font-size: 1.2em !important;
}
.cart-item {
  width: 100%;
  float: none;
  margin-right: 0;
}
.cart-item-info {
  width: 100%;
  float: none;
  margin-top: 1em;
}
.check_box {
  padding: 1.5em 0;
}
.delivery p, .delivery span {
  margin-top: 1em;
}
.about_box {
  width: 100%;
  margin: 1em 0;
}
.total-item {
  padding-bottom: 0;
}
.typo {
  padding: 1em 0;
}
h3.typo-title {
  font-size: 1.6em;
}
.grid_4 {
  margin-top: 22px;
}
.register-but form input[type="submit"] {
  padding: 0.5em 2em;
}
.contact-form input[type="text"] {
  padding: 6px 10px;
  width: 100%;
}
.contact-form textarea {
  width: 100%;
  height: 120px;
}
ul.category_nav li {
  padding-left: 0;
}
.link1 {
  margin-top: 0.6em;
}
.row h3.m_2 {
  font-size: 1.5em;
  margin-top: 1em;
}
p.quick_desc {
  font-size: .8em;
}
ul.previous li {
  margin-top: 1em;
}
ul.previous li a {
  font-size: 0.85em;
}
.contact-form label {
  font-size: 0.8em;
}
.span_2_of_contact_right h3 {
  font-size: 1.5em;
}
.contact_address, .contact_email {
  font-size: .8em;
}
.login-left h3, .login-right h3 {
  font-size: 1em;
}
.acount-btn, .login-right input[type="submit"] {
  padding: 0.3em 1.2em;
}
.register {
  padding: 1.5em 0;
}
.register-top-grid h3, .register-bottom-grid h3 {
  font-size: 1em;
}
.register-bottom-grid {
  margin-top: 4.5em;
}
.register-top-grid span, .register-bottom-grid span {
  font-size: 0.8em;
}
.register-but {
  margin-top: 0.5em;
}
ul.tab_list li a {
  font-size: 0.75em;
}
ul.list1 a {
  font-size: 0.85em;
}
.login-left p, .login-right p {
  font-size: .8em;
}
.login-right span {
  font-size: 0.9em;
}
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
                        <li><a href="index"><locale:message code="label.home"/></a></li>
                          	<c:forEach items="${requestScope.productCategory}" var="category">
			                    <li><a href="product?category=<c:out value="${category.categoryId}"></c:out>"><c:out value="${category.categoryName}"> </c:out></a></li>
                            </c:forEach>
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
	        <div class="new-product">
				<div class="col-md-5 zoom-grid">
					<div class="flexslider" >
						<ul class="slides">
							<li data-thumb="img/<%=request.getParameter("imagePath")%>">
								<div class="thumb-image"> <img src="img/<%=request.getParameter("imagePath")%>" data-imagezoom="true" class="img-responsive" alt="" /> </div>
							</li>
							<li data-thumb="img/tv/UE48J6300AU.jpg">
								<div class="thumb-image"> <img src="img/tv/UE48J6300AU.jpg" data-imagezoom="true" class="img-responsive" alt="" /> </div>
							</li>
							<li data-thumb="img/tv/UE32J4900AK.jpg">
							<div class="thumb-image"> <img src="img/tv/UE32J4900AK.jpg" data-imagezoom="true" class="img-responsive" alt="" /> </div>
							</li> 
							<li data-thumb="img/tv/UE40JU6610U.jpg">
							<div class="thumb-image"> <img src="img/tv/UE40JU6610U.jpg" data-imagezoom="true" class="img-responsive" alt="" /> </div>
							</li> 
						</ul>
					</div>

				</div>
				<div class="col-md-7 dress-info">
					<div class="dress-name">
						<h3><%=request.getParameter("characteristic1")%> <%=request.getParameter("description")%></h3>
						<span>$<%=request.getParameter("intCharacteristic1")%></span>
						<div class="clearfix"></div>
						<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo</p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever</p>
					</div>
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
					
					<sec:authorize access="hasRole('user') or isAnonymous()">
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
					
					
<!-- 					<div class="span span2">
						<p class="left">MADE IN</p>
						<p class="right">China</p>
						<div class="clearfix"></div>
					</div>
					<div class="span span3">
						<p class="left">COLOR</p>
						<p class="right">White</p>
						<div class="clearfix"></div>
					</div>
					<div class="span span4">
						<p class="left">SIZE</p>
						<p class="right"><span class="selection-box"><select class="domains valid" name="domains">
										   <option>M</option>
										   <option>L</option>
										   <option>XL</option>
										   <option>FS</option>
										   <option>S</option>
									   </select></span></p>
						<div class="clearfix"></div>
					</div> -->
<!-- 					<div class="purchase">
						<a href="#">Purchase Now</a>
						<div class="social-icons">
							<ul>
								<li><a class="facebook1" href="#"></a></li>
								<li><a class="twitter1" href="#"></a></li>
								<li><a class="googleplus1" href="#"></a></li>
							</ul>
						</div>
						<div class="clearfix"></div>
					</div> -->
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<div class="zigzag-bottom"></div>
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
