<?php
$con=mysqli_connect("localhost","root","","panacimwipext");	

$ID = $_POST['ID'];

$query = mysqli_query($con, "DELETE FROM login WHERE ID = '$ID' ");

echo json_encode($query);
?>
