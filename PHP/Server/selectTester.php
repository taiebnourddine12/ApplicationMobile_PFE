<?php
$con=mysqli_connect("localhost","root","","panacimwipext");	

$result = array();
$result['data'] = array();
$query = mysqli_query($con, "SELECT * FROM station");



while ($row = mysqli_fetch_array($query)) {
  
  $index['Station_Name'] 		= $row['1'];
  $index['Description'] 		= $row['2'];
  $index['Line_ID'] 			= $row['3'];
  $index['Staion_type'] 		= $row['4'];
  $index['Station_IP'] 			= $row['5'];
  
  
  
array_push($result['data'], $index);
  
}


  $result['success'] = '1';

echo json_encode($result);
?>
