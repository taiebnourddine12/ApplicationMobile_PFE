<?php
$con=mysqli_connect("localhost","root","","mirror_central");	

$result = array();
$result['data'] = array();
$query = mysqli_query($con, "SELECT * FROM dashboard ORDER BY ID");



while ($row = mysqli_fetch_array($query)) {
  $index['ID'] 					= $row['0'];
  $index['Date'] 				= $row['1'];
  $index['OF'] 					= $row['2'];
  $index['PRF'] 				= $row['3'];
  $index['Matricule'] 			= $row['4'];
  $index['Poste'] 				= $row['5'];
  $index['H1 Pass'] 			= $row['6'];
  $index['H1 Fail'] 			= $row['7'];
  $index['H1 Total'] 			= $row['8'];
  $index['H1 Taux de Defaux'] 	= $row['9'];
  $index['H1 Cadence'] 			= $row['10'];
  
  $index['H2 Pass'] 			= $row['11'];
  $index['H2 Fail'] 			= $row['12'];
  $index['H2 Total'] 			= $row['13'];
  $index['H2 Taux de Defaux'] 	= $row['14'];
  $index['H2 Cadence'] 			= $row['15'];
  
  $index['H3 Pass'] 			= $row['16'];
  $index['H3 Fail'] 			= $row['17'];
  $index['H3 Total'] 			= $row['18'];
  $index['H3 Taux de Defaux'] 	= $row['19'];
  $index['H3 Cadence'] 			= $row['20'];
  
  $index['H4 Pass'] 			= $row['21'];
  $index['H4 Fail'] 			= $row['22'];
  $index['H4 Total'] 			= $row['23'];
  $index['H4 Taux de Defaux'] 	= $row['24'];
  $index['H4 Cadence'] 			= $row['25'];
  
  $index['H5 Pass'] 			= $row['26'];
  $index['H5 Fail'] 			= $row['27'];
  $index['H5 Total'] 			= $row['28'];
  $index['H5 Taux de Defaux'] 	= $row['29'];
  $index['H5 Cadence'] 			= $row['30'];
  
  $index['H6 Pass'] 			= $row['31'];
  $index['H6 Fail'] 			= $row['32'];
  $index['H6 Total'] 			= $row['33'];
  $index['H6 Taux de Defaux'] 	= $row['34'];
  $index['H6 Cadence'] 			= $row['35'];
  
  $index['H7 Pass'] 			= $row['36'];
  $index['H7 Fail'] 			= $row['37'];
  $index['H7 Total'] 			= $row['38'];
  $index['H7 Taux de Defaux'] 	= $row['39'];
  $index['H7 Cadence'] 			= $row['40'];
  
  $index['H8 Pass'] 			= $row['41'];
  $index['H8 Fail'] 			= $row['42'];
  $index['H8 Total'] 			= $row['43'];
  $index['H8 Taux de Defaux'] 	= $row['44'];
  $index['H8 Cadence'] 			= $row['45'];
  
  $index['Taux de Defaux Total'] = $row['46'];
  $index['Cadence Total'] 		 = $row['47'];
  $index['Cadence Théorique'] 	 = $row['48'];
  $index['Actual H'] 			 = $row['49'];
  
  
array_push($result['data'], $index);
  
}


  $result['success'] = '1';

echo json_encode($result);
?>
