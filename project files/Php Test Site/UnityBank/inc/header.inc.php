<?php 
include ( "./inc/connect.inc.php" );
session_start();
if(!isset($_SESSION["user_login"])){

} 
else
{
header("location: home.php");
}
?>

<!doctype html>
<html>
       <head>
	   <title>Unity Bank</title>
	   <link rel="stylesheet" type="text/css" href="./css/style.css"/>
	   </head>
	   <body>
	   <div class="headerMenu">
	         <div id="wrapper">
			       <div class="logo">
                    	 <img src="./img/unity_bank_logo.png">			  
				   </div>
				  <form id="search-form" action="" method="post" enctype="multipart/form-data">
						<fieldset>
							<div class="search-form">					
								<input type="text" name="search" value="Search..." onBlur="if(this.value=='') this.value='Type Keyword Here'" onFocus="if(this.value =='Type Keyword Here' ) this.value=''" />
								<a href="#" onClick="document.getElementById('search-form').submit()">Search</a>									
							</div>
						</fieldset>
					</form>
				  <div id="menu">
				        <a href="home.php" />Home</a>
                        <a href="about.php" />About</a>
                        <a href="logout.php" />Sign Out</a>					
				  </div>
	         </div>
	   </div>