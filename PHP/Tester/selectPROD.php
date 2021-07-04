<?php
$con=mysqli_connect("localhost","root","","mirror_central");	

$result = array();
$result['data'] = array();
$query = mysqli_query($con, "SELECT * FROM prod ORDER BY ID");



while ($row = mysqli_fetch_array($query)) {
  $index['ID'] 					= $row['0'];
  $index['Date'] 				= $row['1'];
  $index['Poste'] 				= $row['2'];
  
  $index['H1 Pass'] 			= $row['3'];
  $index['H1 Fail'] 			= $row['4'];
  $index['H1 Total'] 			= $row['5'];
  $index['H1 Taux de Defaux'] 	= $row['6'];
  $index['H1 Cadence'] 			= $row['7'];
  
  $index['H2 Pass'] 			= $row['8'];
  $index['H2 Fail'] 			= $row['9'];
  $index['H2 Total'] 			= $row['10'];
  $index['H2 Taux de Defaux'] 	= $row['11'];
  $index['H2 Cadence'] 			= $row['12'];
  
  $index['H3 Pass'] 			= $row['13'];
  $index['H3 Fail'] 			= $row['14'];
  $index['H3 Total'] 			= $row['15'];
  $index['H3 Taux de Defaux'] 	= $row['16'];
  $index['H3 Cadence'] 			= $row['17'];
  
  $index['H4 Pass'] 			= $row['18'];
  $index['H4 Fail'] 			= $row['19'];
  $index['H4 Total'] 			= $row['20'];
  $index['H4 Taux de Defaux'] 	= $row['21'];
  $index['H4 Cadence'] 			= $row['22'];
  
  $index['H5 Pass'] 			= $row['23'];
  $index['H5 Fail'] 			= $row['24'];
  $index['H5 Total'] 			= $row['25'];
  $index['H5 Taux de Defaux'] 	= $row['26'];
  $index['H5 Cadence'] 			= $row['27'];
  
  $index['H6 Pass'] 			= $row['28'];
  $index['H6 Fail'] 			= $row['29'];
  $index['H6 Total'] 			= $row['30'];
  $index['H6 Taux de Defaux'] 	= $row['31'];
  $index['H6 Cadence'] 			= $row['32'];
  
  $index['H7 Pass'] 			= $row['33'];
  $index['H7 Fail'] 			= $row['34'];
  $index['H7 Total'] 			= $row['35'];
  $index['H7 Taux de Defaux'] 	= $row['36'];
  $index['H7 Cadence'] 			= $row['37'];
  
  $index['H8 Pass'] 			= $row['38'];
  $index['H8 Fail'] 			= $row['39'];
  $index['H8 Total'] 			= $row['40'];
  $index['H8 Taux de Defaux'] 	= $row['41'];
  $index['H8 Cadence'] 			= $row['42'];
  
  $index['Taux de Defaux Total'] = $row['43'];
  $index['Cadence Total'] 		 = $row['44'];
  $index['Cadence Théorique'] 	 = $row['45'];
  $index['Actual H'] 			 = $row['46'];
  
array_push($result['data'], $index);
  
}


  $result['success'] = '1';

echo json_encode($result);
?>
