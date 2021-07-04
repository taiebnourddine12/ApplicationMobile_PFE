<?php
$con=mysqli_connect("localhost","root","","mirror_central");	

$Date = $_POST["Date"];
$OF = $_POST["OF"];
$PRF = $_POST["PRF"];
$Matricule = $_POST["Matricule"];
$Poste = $_POST["Poste"];
 
$sql = "select * from dashboard where (PRF='$PRF' AND Matricule='$Matricule' AND OF='$OF' AND Date='$Date') OR (PRF='$PRF' AND Matricule='$Matricule') OR (Matricule='$Matricule' AND OF='$OF') OR (PRF='$PRF' AND OF='$OF')OR PRF='$PRF' OR Matricule='$Matricule' OR OF='$OF' or Date='$Date' or  Poste='$Poste'" ;
 
$query = mysqli_query($con,$sql);
 
$result = array();
 

 
while($row = mysqli_fetch_array($query)){
array_push($result,array(
	'ID'				=>	$row[0],
	'Date'				=>	$row[1],
	'OF'				=>	$row[2],
	'PRF'				=>	$row[3],
	'Matricule'			=>	$row[4],
	'Poste'				=>	$row[5],
	'H1 Pass'			=>	$row[6],
	'H1 Fail'			=>	$row[7],
	'H1 Total'			=>	$row[8], 
	'H1 Taux de Defaux'	=>	$row[9], 
	'H1 Cadence'		=>	$row[10], 
	
	'H2 Pass'			=>	$row[11],
	'H2 Fail'			=>	$row[12],
	'H2 Total'			=>	$row[13], 
	'H2 Taux de Defaux'	=>	$row[14], 
	'H2 Cadence'		=>	$row[15], 
	
	'H3 Pass'			=>	$row[16],
	'H3 Fail'			=>	$row[17],
	'H3 Total'			=>	$row[18], 
	'H3 Taux de Defaux'	=>	$row[19], 
	'H3 Cadence'		=>	$row[20], 
	
	'H4 Pass'			=>	$row[21],
	'H4 Fail'			=>	$row[22],
	'H4 Total'			=>	$row[23], 
	'H4 Taux de Defaux'	=>	$row[24], 
	'H4 Cadence'		=>	$row[25], 
	
	'H5 Pass'			=>	$row[26],
	'H5 Fail'			=>	$row[27],
	'H5 Total'			=>	$row[28],
	'H5 Taux de Defaux'	=>	$row[29], 
	'H5 Cadence'		=>	$row[30], 	
	
	'H6 Pass'			=>	$row[31],
	'H6 Fail'			=>	$row[32],
	'H6 Total'			=>	$row[33], 
	'H6 Taux de Defaux'	=>	$row[34], 
	'H6 Cadence'		=>	$row[35], 
	
	'H7 Pass'			=>	$row[36],
	'H7 Fail'			=>	$row[37],
	'H7 Total'			=>	$row[38], 
	'H7 Taux de Defaux'	=>	$row[39], 
	'H7 Cadence'		=>	$row[40], 

	'H8 Pass'			=>	$row[41],
	'H8 Fail'			=>	$row[42],
	'H8 Total'			=>	$row[43], 
	'H8 Taux de Defaux'	=>	$row[44], 
	'H8 Cadence'		=>	$row[45], 
	
	'Taux de Defaux Total' => $row[46],
	'Cadence Total'		   => $row[47],
	'Cadence Théorique'	   => $row[48],
	'Actual H'		 	   => $row[49]
));
}
 
echo json_encode(array("result"=>$result));

 
mysqli_close($con);
 
?>