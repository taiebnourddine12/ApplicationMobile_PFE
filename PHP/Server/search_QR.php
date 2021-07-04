<?php
$server_nm = "localhost";
$connection = array("Database"=>"panacimwipext","UID"=>"root","PWD"=>"");
$con=sqlsrv_connect($server_nm, $connection);	


$sql = "select * from all_event";
 
$query = sqlsrv_query($con,$sql);
 
$result = array();
 
while($row = sqlsrv_fetch_array($query)){
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

 
sqlsrv_close($con);
 
?>

<?php
$serverName = "serverName\instanceName";
$connectionInfo = array( "Database"=>"panacimwipext", "UID"=>"consult", "PWD"=>"consult");
$conn = sqlsrv_connect( $serverName, $connectionInfo );
if( $conn === false ) {
    die( print_r( sqlsrv_errors(), true));
}

$sql = "SELECT * FROM all_event";
$stmt = sqlsrv_query( $conn, $sql );
if( $stmt === false) {
    die( print_r( sqlsrv_errors(), true) );
}

while( $row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_ASSOC) ) {
      echo $row['LastName'].", ".$row['FirstName']."<br />";
}

sqlsrv_free_stmt( $stmt);
?>