<%-- 
    Document   : Home_categories
    Created on : Nov 5, 2016, 10:46:59 AM
    Author     : deepika
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Categories Page</title>


<link rel="stylesheet" href="styles/home_categories_css.css" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Bitter' rel='stylesheet'>
</head>


<style>

#myid
{
  font-family: Georgia, "Times New Roman", Times, serif; 
  font-size: 150%;
  margin: 05px auto;
  float:left;
  margin-top: 20px;
  margin-left: 25px;
}

body
{
    
    /* background-image: url("http://wallpapercave.com/wp/o5kkKdN.jpg"); */
        background-image: url("http://domnod.com/img/IT_EComm.jpg");
}
.form-style-5{
    max-width: 500px;
    padding: 10px 20px;
    background: #f4f7f8;
    margin: 10px auto;
    padding: 20px;
    background: #f4f7f8;
    border-radius: 8px;
    font-family: Georgia, "Times New Roman", Times, serif;
}
.form-style-5 fieldset{
    border: none;
}
.form-style-5 legend {
    font-size: 1.4em;
    margin-bottom: 10px;
}
.form-style-5 label {
    display: block;
    margin-bottom: 8px;
}
.form-style-5 input[type="text"],
.form-style-5 input[type="password"],
.form-style-5 input[type="date"],
.form-style-5 input[type="datetime"],
.form-style-5 input[type="email"],
.form-style-5 input[type="number"],
.form-style-5 input[type="search"],
.form-style-5 input[type="time"],
.form-style-5 input[type="url"],

.form-style-5 textarea,
.form-style-5 p,
.form-style-5 a,
.form-style-5 select {
    font-family: Georgia, "Times New Roman", Times, serif;
    background: rgba(255,255,255,.1);
    border: none;
    border-radius: 4px;
    font-size: 16px;
    margin: 0;
    outline: 0;
    padding: 7px;
    width: 100%;
    box-sizing: border-box; 
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box; 
    background-color: #e8eeef;
    color:#8a97a0;
    -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
    margin-bottom: 30px;
    
}
.form-style-5 input[type="text"]:focus,
.form-style-5 input[type="password"]:focus,
.form-style-5 input[type="date"]:focus,
.form-style-5 input[type="datetime"]:focus,
.form-style-5 input[type="email"]:focus,
.form-style-5 input[type="number"]:focus,
.form-style-5 input[type="search"]:focus,
.form-style-5 input[type="time"]:focus,
.form-style-5 input[type="url"]:focus,
.form-style-5 textarea:focus,
.form-style-5 p:focus,
.form-style-5 a:focus,
.form-style-5 select:focus{
    background: #d2d9dd;
}
.form-style-5 select{
    -webkit-appearance: menulist-button;
    height:35px;
}
.form-style-5 .number {
    background: #1abc9c;
    color: #fff;
    height: 80px;
    width: 80px;
    display: inline-block;
    font-size: 0.8em;
    margin-right: 4px;
    line-height: 30px;
    text-align: center;
    text-shadow: 0 1px 0 rgba(255,255,255,0.2);
    border-radius: 15px 15px 15px 0px;
}

.form-style-5 input[type="submit"],
.form-style-5 input[type="reset"],
.form-style-5 input[type="button"]
{
    position: relative;
    float:left;
    display: block;
    padding: 19px 39px 18px 39px;
    color: #FFF;
    margin: 0 auto;
    background: #1abc9c;
    font-size: 18px;
    text-align: center;
    font-style: normal;
    width: 50%;
    border: 1px solid #16a085;
    border-width: 1px 1px 3px;
    margin-bottom: 10px;
}
.form-style-5 input[type="submit"]:hover,
.form-style-5 input[type="reset"]:hover,
.form-style-5 input[type="button"]:hover
{
    background: #109177;
}

</style>


<body>

	<%@include file="header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>

	<h1 id="myid">
		Clothing and Accessories Closet <br>
		<br>
		<!--<img src="http://www.alcalingua.com/sites/all/libraries/otros/twitter.png" alt="no image" width="150" height="150" /> -->
	</h1>
	<br>


	<section class="form-style-5">
	<form name="login_form" onsubmit="return validate_login();"
		action="/ClothingCloset/itemdisplay/displayAllItems" method="POST">
		<fieldset>
			<legend>
				<span class="number">1</span> Accessories and clothing Info
			</legend>
			<table>

				<tr>
					<td><img
						src="http://www.allfashionnews.net/wp-content/uploads/2015/02/Stylish-Look-with-Belt-for-Men.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Belts'><span>Belts</span></a></td>

					<td><img
						src="http://scene7.zumiez.com/is/image/zumiez/cat_max/Ray-Ban-Justin-Sunglasses-_247488.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Sunglasses'><span>Sunglasses</span></a></td>
				</tr>

				<tr>
					<td><img
						src="http://mhicz.com/wp-content/uploads/2016/05/baseball-caps-11.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Caps'><span>Caps</span></a></td>

					<td><img
						src="http://imgsplanet.com/pics/main/53/397428-wallet.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Wallets'><span>Wallets</span></a></td>
				</tr>

				<tr>
					<td><img
						src="http://clothcountry.com/wp-content/uploads/2015/10/ETC-Men-Pack-of-2-Pique-Polo-T-shirts_70560d8db27a71e2d848aebfe7be5303_images.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=T-Shirts'><span>T-Shirts</span></a></td>

					<td><img
						src="http://basicsman.com/wp-content/uploads/2015/06/MG_0521.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Formal Shirts'><span>Formal Shirts</span></a></td>
				</tr>

				<tr>
					<td><img
						src="http://www.patagonia.com/dis/dw/image/v2/ABBM_PRD/on/demandware.static/-/Sites-patagonia-master/default/dw8ca88bd8/images/hi-res/25940_HMB.jpg?sw=500&sh=500&sfrm=png"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Sweat Shirts'><span>Sweat Shirts</span></a></td>

					<td><img
						src="https://s-media-cache-ak0.pinimg.com/736x/62/d5/74/62d574659e7bcd28e34b1f567a53491f.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Hoods'><span>Hoods</span></a></td>
				</tr>

				<tr>
					<td><img
						src="https://macys-o.scene7.com/is/image/MCY/products/2/optimized/3879022_fpx.tif?bgc=255,255,255&wid=224&qlt=90,0&layer=comp&op_sharpen=0&resMode=bicub&op_usm=0.7,1.0,0.5,0&fmt=jpeg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Blazers'><span>Blazers</span></a></td>

					<td><img
						src="https://ae01.alicdn.com/kf/HTB19eNlLpXXXXawXpXXq6xXFXXXy/2016-Kids-Girls-Swimwear-Professional-Children-One-Piece-Swimsuit-Baby-Bathing-Suits-Racing-Competition-Tight-Swimming.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Swimwears'><span>Swim
								wears</span></a></td>
				</tr>

				<tr>
					<td><img
						src="http://g.nordstromimage.com/ImageGallery/store/product/Zoom/4/_11685764.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Jeans'><span>Jeans</span></a></td>

					<td><img
						src="http://www.dickssportinggoods.com/graphics/product_images/pDSP1-22297242v750.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Shorts'><span>Shorts</span></a></td>
				</tr>

				<tr>
					<td><img
						src="http://demandware.edgesuite.net/sits_pod20-adidas/dw/image/v2/aaqx_prd/on/demandware.static/-/Sites-adidas-products/en_US/dw799956a3/zoom/AY8401_21_model.jpg?sw=2000&sfrm=jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=TrackPants'><span>Track
								Pants</span></a></td>

					<td><img
						src="https://img.grouponcdn.com/deal/7AP7zd68Qcme2Q8NrKti/s3-2400x1440/v1/c700x420.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Jeggings'><span>Jeggings</span></a></td>
				</tr>

				<tr>
					<td><img
						src="http://4.imimg.com/data4/FC/AA/MY-2376142/women-shrugs-250x250.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='inside_categories.jsp'><span>Shrugs</span></a></td>

					<td><img
						src="http://www.latestfashiontoday.com/wp-content/uploads/2014/06/Green-dresses.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Kurtas'><span>Kurtas</span></a></td>
				</tr>

				<tr>
					<td><img
						src="https://n4.sdlcdn.com/imgs/a/w/p/Mateshwari-Textiles-Designer-Exclusive-Latest-SDL639362155-1-48c56.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Sarees'><span>Sarees</span></a></td>

					<td><img
						src="http://images.voonik.com/32423601/manvaa-multi-crepe-printed-unstitched-dress-materia-product.jpg?1475472234"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Dress Materials'><span>Dress Materials</span></a></td>
				</tr>
				<tr>
					<td><img
						src="http://www.rusclothing.com/images/thumbnails/300/383/product/1/pp-shawl-1536.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Shawls'><span>Shawls</span></a></td>

					<td><img
						src="http://cf.ltkcdn.net/mens-fashion/images/std/45837-425x282-Brown_leather_shoes.jpg"
						alt="no image" width="50" height="50" /></td>

					<td><a href='displayAllItems?categoryName=Shoes'><span>Shoes</span></a></td>
				</tr>


			</table>
		</fieldset>
	</form>
	</section>
	<br>
	<br>
	<br>
	<br>
	<br>



</body>
</html>


