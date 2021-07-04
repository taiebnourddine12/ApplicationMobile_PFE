<?php 
	$con=mysqli_connect("localhost","root","","panacimwipext");	
	
	$Matricule = $_POST["Matricule"];
	$Username = $_POST["Username"];
	$Password = $_POST["Password"];
	
	

	$sql = "INSERT INTO admin(Matricule,Username,Password) VALUES ('$Matricule','$Username','$Password')";
	$result = mysqli_query($con,$sql);
	
	if($result) {
		echo "registered successfully";
	}
	else {
		echo "some error occured";
	}
?>