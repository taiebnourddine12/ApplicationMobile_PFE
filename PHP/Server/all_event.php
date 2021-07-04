
<?php
$con=mysqli_connect("localhost","root","","panacimwipext");	

//counter = $_POST["counter"];
$SerialNumber = '107323203645D7FG3002';
//$Work_Order = $_POST["Work_Order"];
//$Part_Number = $_POST["Part_Number"];
//$Station_ID = $_POST["Station_ID"];
//$Line_ID = $_POST["Line_ID"];
//$Process_Layer = $_POST["Process_Layer"];
//$Dating = $_POST["Dating"];
//$Master_SN = $_POST["Master_SN"];
//$SerialNumber_Position = $_POST["SerialNumber_Position"];
//$Status = $_POST["Status"];
//$Setup_Name = $_POST["Setup_Name"];
//$UserName = $_POST["UserName"];
 
$sql = "select * from all_event ";
 
$query = mysqli_query($con,$sql);
 
$result = array();
 
while($row = mysqli_fetch_array($query)){
array_push($result,array(
	'counter'					=>	$row[0],
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