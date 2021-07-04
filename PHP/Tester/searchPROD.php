<?php
$con=mysqli_connect("localhost","root","","x52 mirror");	


$Date = $_POST["Date"];
$Poste = $_POST["Poste"];


 
$sql = "select * from prod where Date='$Date' or  Poste='$Poste' " ;
 
$query = mysqli_query($con,$sql);
 
$result = array();
 

 
while($row = mysqli_fetch_array($query)){
array_push($result,array(
	'ID'				=>	$row[0],
	'Date'				=>	$row[1],
	
	'Poste'				=>	$row[2],
	'H1 Pass'			=>	$row[3],
	'H1 Fail'			=>	$row[4],
	'H1 Total'			=>	$row[5], 
	'H1 Taux de Defaux'	=>	$row[6], 
	'H1 Cadence'		=>	$row[7], 
	
	'H2 Pass'			=>	$row[8],
	'H2 Fail'			=>	$row[9],
	'H2 Total'			=>	$row[10], 
	'H2 Taux de Defaux'	=>	$row[11], 
	'H2 Cadence'		=>	$row[12], 
	
	'H3 Pass'			=>	$row[13],
	'H3 Fail'			=>	$row[14],
	'H3 Total'			=>	$row[15], 
	'H3 Taux de Defaux'	=>	$row[16], 
	'H3 Cadence'		=>	$row[17], 
	
	'H4 Pass'			=>	$row[18],
	'H4 Fail'			=>	$row[19],
	'H4 Total'			=>	$row[20], 
	'H4 Taux de Defaux'	=>	$row[21], 
	'H4 Cadence'		=>	$row[22], 
	
	'H5 Pass'			=>	$row[23],
	'H5 Fail'			=>	$row[24],
	'H5 Total'			=>	$row[25],
	'H5 Taux de Defaux'	=>	$row[26], 
	'H5 Cadence'		=>	$row[27], 	
	
	'H6 Pass'			=>	$row[28],
	'H6 Fail'			=>	$row[29],
	'H6 Total'			=>	$row[30], 
	'H6 Taux de Defaux'	=>	$row[31], 
	'H6 Cadence'		=>	$row[32], 
	
	'H7 Pass'			=>	$row[33],
	'H7 Fail'			=>	$row[34],
	'H7 Total'			=>	$row[35], 
	'H7 Taux de Defaux'	=>	$row[36], 
	'H7 Cadence'		=>	$row[37], 

	'H8 Pass'			=>	$row[38],
	'H8 Fail'			=>	$row[39],
	'H8 Total'			=>	$row[40], 
	'H8 Taux de Defaux'	=>	$row[41], 
	'H8 Cadence'		=>	$row[42], 
	
	'Taux de Defaux Total' => $row[43],
	'Cadence Total'		   => $row[44],
	'Cadence Théorique'	   => $row[45],
	'Actual H'		 	   => $row[46]
));
}
 
echo json_encode(array("result"=>$result));

 
mysqli_close($con);
 
?>