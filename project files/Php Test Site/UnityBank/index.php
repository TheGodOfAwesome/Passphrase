<?session_start()?>
<?php include ( "./inc/indexheader.inc.php" );?>
<?php 
// User Login Code
if (isset($_POST["user_login"]) && isset($_POST["password_login"])){
$user_login = preg_replace('#[^A-Za-z0-9]#i', '', $_POST["user_login"]); //filter everything but numbers and letters
$password_login = preg_replace('#[^A-Za-z0-9]#i', '', $_POST["password_login"]); //filter everything but numbers and letters
$sql = mysql_query("SELECT id FROM users WHERE name='$user_login' AND password='$password_login' LIMIT 1"); // Query
 //check for their existence
 $userCount = mysql_num_rows($sql); //Count the number of rows returned
 if ($userCount == 1){
     while($row = mysql_fetch_array($sql)){
	 $id = $row["id"];
	 }
	   $_SESSION["user_login"] = $user_login;
	   header("location: passphase.php");
	   exit();
	 } else {
             echo 'That information is incorrect, try again';
             exit();			
            }
}
?>

	   <div>
	   <table>
	        <tr>
			    <td width=40% valing="top">
				     <h2>Sign In Below</h2>
				     <form action="index.php" method="POST">
                     <input type="text" name="user_login" size="52" placeholder="Username" /> <br/><br/>
					 <input type=password name="password_login" maxlength=5  size=5 placeholder="Password" /> <br/><br/>
					 <input type="submit" name="preg" value="Sign In" >
					 </form>					 
				</td>
			</tr>
       </table>
<?php include ( "./inc/footer.inc.php" );?>	   