<?php
$con=mysqli_connect("localhost","root","","panacimwipext");	

$result = array();
$result['data'] = array();
$query = mysqli_query($con, "SELECT * FROM admin ORDER BY ID");



while ($row = mysqli_fetch_array($query)) {
  $index['ID'] 					= $row['0'];
  $index['Username'] 			= $row['1'];
  $index['Matricule'] 			= $row['2'];
  $index['Password'] 			= $row['3'];
  
  
array_push($result['data'], $index);
  
}


  $result['success'] = '1';

echo json_encode($result);
?>
