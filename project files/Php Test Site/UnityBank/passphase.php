<?php 
include ( "./passphase/connectpassphase.php" );
?>

<?php 
include ( "./passphase/security.php" );
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Passphrase</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="passphase/css/reset.css" type="text/css" media="all">
  <link rel="stylesheet" href="passphase/css/layout.css" type="text/css" media="all">
  <link rel="stylesheet" href="passphase/css/style.css" type="text/css" media="all">
  <script type="text/javascript" src="passphase/js/jquery-1.6.js" ></script>
  <script type="text/javascript" src="passphase/js/cufon-yui.js"></script>
  <script type="text/javascript" src="passphase/js/cufon-replace.js"></script>  
  		<script type="text/javascript" src="passphase/js/Questrial_400.font.js"></script>
  <script type="text/javascript" src="passphase/js/bgSlider.js" ></script>
  <script type="text/javascript" src="passphase/js/script.js" ></script>
  <script type="text/javascript" src="passphase/js/pages.js"></script>
  <script type="text/javascript" src="passphase/js/jquery.easing.1.3.js"></script>
  <script type="text/javascript" src="passphase/js/bg.js" ></script>
  <script type="text/javascript" src="passphase/js/forms.js"></script>
  <script type="text/javascript" src="passphase/js/jcarousellite.js"></script>
  <script type="text/javascript" src="passphase/js/jquery.mousewheel.js"></script>
  <script type="text/javascript" src="passphase/js/atooltip.jquery.js"></script>
 
  <!--[if lt IE 9]>
  	<script type="text/javascript" src="js/html5.js"></script>
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="all">
  <![endif]-->
	<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0"  alt="" /></a>
		</div>
	<![endif]-->
</head>

<body>
<div class="spinner"></div>
<div id="bgSlider"></div>
<div class="extra">
	<div class="main">
		<div class="box">
			<!--header -->
			<header>
				<nav class="menu">
					<ul id="menu">
						<li><a href="#!/page_About"><span></span><strong>About</strong></a></li>
						<li><a href="#!/page_Contact"><span></span><strong>Contact Us</strong></a></li>
					</ul>
				</nav>
			</header>
			<!--header end-->
			
			<?php 
            // User Login Code
            if (isset($_POST["passphrase"])){
            $key = "1234567891234567"; //16 Character Key
			$passphrase = $_POST['passphrase'];
			$passphrase = Security::encrypt($passphrase, $key);
            $sql = mysql_query("SELECT pass_id FROM passtb WHERE passphrase='$passphrase' LIMIT 1"); // Query
            //check for their existence
            $userCount = mysql_num_rows($sql); //Count the number of rows returned
            if ($userCount == 1){
            while($row = mysql_fetch_array($sql)){
	        $id = $row["pass_id"];
	        }
	        //$_SESSION["user_login"] = $user_login;
	        header("location: index.php");
	        exit();
	        } else {
			 session_start();
             session_destroy();
             echo 'That information is incorrect, try again';
			 header("Location: index.php");
             exit();			
            }
            }
            ?>
			<div>
			<table>
	        <tr>
			    <td width=40% valing="top">
				     <h2>Enter Passphrase</h2>
				     <form action="passphase.php" method="POST">
					 <input type="text" name="passphrase" size="52" placeholder="Passphrase" /> <br/><br/>
					 <input type="submit" name="preg" value="Submit" >
					 </form>					 
				</td>
			</tr>
			</div>
       </table>
			<!--content -->
			<article id="content">
				<ul>
					<li id="page_About">
						<div class="box1">
							<div class="inner">
								<a href="#" class="close" data-type="close"><span></span></a>
								<div class="wrapper">
									<div class="col1">
										<h2>About Passphase</h2>
										<p class="quot">The most ingenious software security idea to come from Africa. - Forbes <img src="images/quot2.png" alt=""></p>
										<p class="pad_bot1">Enter the Pass-phrase provided by the Passphase application on your device and click submit to proceed.</p>
										<p class="color1">Enter the Pass-phrase quickly because it changes every 60secs!</p>
									</div>
									<div class="col1 pad_left1">
										<h2>About Us</h2>
										<div class="scroll">
											<ul>
												<li>
													<p><strong>Passphase</strong> •	An information security company, that desires to address the problems our customers face<br>
													and continually perfect these solutions so as to maintain the efficiency and effectiveness of the solutions. </p>
												</li>
												<li>
													<p>Continually improving security of new and existing systems since the summer of 2014. Do you want more information on our products? Visit Our Website www.passphase.org .</p>
												</li>
											</ul>
										</div>
										<a href="#" class="prev"><span></span></a>
										<a href="#" class="next"><span></span></a>
									</div>
								</div>
							</div>
						</div>
					</li>
					<li id="page_Contact">
						<div class="box1">
							<div class="inner">
								<a href="#" class="close" data-type="close"><span></span></a>
								<div class="wrapper">
									<div class="col1">
										<h2>Contact Info</h2>
										<p><strong>Harare Institute of Technology <br>		
                                        P.O. Box BE 277 
                                        Belvedere
                                        Harare Zimbabwe
</strong></p>
										<p class="address">
												Telephone:<br>
												E-mail:</p>
										<p class="pad_bot1">
												+263 775 0555 11<br>
												
												<a href="mailto:" class="color1">mail@passphase.org</a></p>
									</div>
								</div>
								<div class="wrapper">
									<h2>Contact Form</h2>
									<form id="ContactForm">
									<div>
										<div class="wrapper"><input class="input" type="text" value="Name"  onblur="if(this.value=='') this.value='Name'" onFocus="if(this.value =='Name' ) this.value=''" ></div>
										<div class="wrapper"><input class="input" type="text" value="Email"  onblur="if(this.value=='') this.value='Email'" onFocus="if(this.value =='Email' ) this.value=''" ></div>
										<div class="textarea_box"><textarea cols="1" rows="1" onBlur="if(this.value=='') this.value='Message'" onFocus="if(this.value =='Message' ) this.value=''"  >Message</textarea></div>
										<a href="#" class="color1" onClick="document.getElementById('ContactForm').submit()">Send</a>
										<a href="#" class="color1" onClick="document.getElementById('ContactForm').reset()">Clear</a>
									</div>
									</form>
								</div>
							</div>
						</div>
					</li>
					<li id="page_More">
						<div class="box1">
							<div class="inner">
								<a href="#" class="close" data-type="close"><span></span></a>
								<div class="wrapper">
									<h2>Read more</h2>
									<p><strong>Lorem ipsum dolor sit amet, consectetur</strong> adipisicing elit, sed do eiusmod tempor inciddunt ut labore et dolore magna aliqua nostrud exercitation. Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolorreprehenderit in voluptate velit esse cillum dolore. Duis aute irure dolorreprehenderit in voluptate.</p>
									<div class="wrapper pad_bot1">
										<figure class="left marg_right1"><img src="images/page2_img1.jpg" alt=""></figure>
										<p class="pad_bot1"><strong>Ullamco laboris nisi</strong> ut aliquip ex ea commodo consequat. Duis aute irure dolorreprehenderit in voluptate velit esse cillum dolore.</p>
										<p class="pad_bot1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor inciddunt ut.</p>
									</div>
									<p class="pad_bot1"><strong>At vero eos et accusamus et iusto odio dignissimos</strong> ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia.</p>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor inciddunt ut labore et dolore magna aliqua nostrud exercitation. Ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolorreprehenderit in voluptate velit esse cillum dolore. Duis aute irure dolorreprehenderit in voluptate.</p>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</article>
			<!--content end-->
		</div>
	</div>
	<div class="block"></div>
</div>
<div class="bg1">
	<div class="main">
			<!--footer -->
			<footer>
				<div class="col_1">
					<div class="wrapper">
						<div class="bg_spinner"></div>
						<ul class="pagination">
							<li class="current">Background: &nbsp; <a href="passphase/images/bg_img1.jpg">1</a></li>
						</ul>
					</div>
				</div>
				<div class="col_2">
					<span>Passphase</span> Copyright 2014<br>
					</div>
			</footer>
			<!--footer end-->
	</div>
</div>
<script>
$(window).load(function() {	
	$('.spinner').fadeOut();
	$('body').css({overflow:'inherit'})
})
</script>
</body>
</html>