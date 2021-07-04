
<?php
$con=mysqli_connect("localhost","root","","panacimwipext");	

 
$sql = "select * from all_event where Counter = 1 ";
 
$query = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($query)){
array_push($result,array(
	'Counter'					=>	$row[0],
	'SerialNumber'				=>	$row[1],
	'Work_Order'				=>	$row[2],
	'Part_Number'				=>	$row[3],
	'Station_ID'				=>	$row[4],
	'Line_ID'					=>	$row[5],
	'Process_Layer'				=>	$row[6],
	'Dating'					=>	$row[7],
	'Master_SN'					=>	$row[8],
	'SerialNumber_Position'		=>	$row[9],
	'Status'					=>	$row[10],
	'Setup_Name'				=>	$row[11],
	'UserName'					=>	$row[12],
	
));
}
 
echo json_encode(array("result"=>$result));

 
mysqli_close($con);
 
?>