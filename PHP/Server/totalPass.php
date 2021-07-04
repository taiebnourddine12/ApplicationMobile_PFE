<?php

$con=mysqli_connect("localhost","root","","panacimwipext");	


$Station_Name = $_POST["Station_Name"];

//$date1='2021-01-04 12:30';
//$date2='2021-01-04 13:35';
//$Station_Name = "LABELLING STATION";


$sql="SELECT *
FROM all_event
INNER JOIN station
ON all_event.Station_ID=station.Station_ID
where (station.Station_Name = '$Station_Name') ";
 
$query = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($query)){
array_push($result,array(
	'Station_Name'				=> 	$row[1],
	'SerialNumber'				=>	$row[1],
	'Station_ID'				=>	$row[4],
	'Dating'					=>	$row[7],
	'Status'					=>	$row[10]
	
	
));
}
 
echo json_encode(array("result"=>$result));

 
mysqli_close($con);
 
?>