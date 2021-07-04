<?php

$con=mysqli_connect("localhost","root","","panacimwipext");	

$date1=$_POST["Dating1"];
$date2=$_POST["Dating2"];
$Station_Name = $_POST["Station_Name"];

//$date2="2021-01-04 12:31:05";
//$date1="2021-01-04 12:30:52";
//$Station_Name = "FCT 4D";

$sql="SELECT *
FROM all_event
INNER JOIN station
ON all_event.Station_ID=station.Station_ID
where (station.Station_Name = '$Station_Name') and (all_event.Dating between'$date1' and '$date2') ";
 
$query = mysqli_query($con,$sql);

$result = array();
  
while($row = mysqli_fetch_array($query)){
array_push($result,array(
	'SerialNumber'				=>	$row[1],
	'Station_ID'				=>	$row[4],
	'Dating'					=>	$row[7],
	'Status'					=>	$row[10]
	
	
));
}

echo json_encode(array("result"=>$result));

mysqli_close($con);
 
?>