<?php 
		$con=mysqli_connect("localhost","root","","panacimwipext");	
		$username = $_POST["Username"];
		$password = $_POST["Password"];

		$sql = "SELECT * FROM login WHERE  Username = '$username' AND Password = '$password'";
		$result = mysqli_query($con,$sql);
		
		if($result->num_rows > 0){
			echo "logged in successfully" ;
		}else{
  			 echo "user not found";
}
?>