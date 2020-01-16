<style>
/*
Credit to W3Schools for the table stying format (https://www.w3schools.com/css/css_table.asp)
*/
#messages {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#messages td, #messages th {
  border: 1px solid #ddd;
  padding: 8px;
}

#messages tr:nth-child(even){background-color: #f2f2f2;}

#messages tr:hover {background-color: #ddd;}

#messages th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #42b0f5;
  color: white;
}
</style>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
</head>
<body>

<?php

	$this->load->library('session');

	//Create the menu as needed
	if(empty($_SESSION['username']))
	{
		//login
		print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/Message/index'>Login</a>";
		print "<br>";
	}
	else{

		$username = $_SESSION['username'];

		//Logout
		print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/logout'>Logout</a>";
		print "&nbsp;&nbsp;&nbsp;";

		//Messages
		print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/view/$username'>Messages</a>";
		print "&nbsp;&nbsp;&nbsp;";
	
		//Feed
		print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/feed/$username'>Feed</a>";		
		print "&nbsp;&nbsp;&nbsp;";

		//Post
		print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/Message/index'>Post</a>";		
		print "&nbsp;&nbsp;&nbsp;";

		//Search
		print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/Search/index'>Search</a>";		
		print "<br>";
	}

?>

<table id = "messages">
<th> User </th>
<th> Message </th>
<?php

defined('BASEPATH') OR exit('No direct script access allowed');

//Print the results using a for each loop in order of id, username and text
foreach ($results as $row) {?>
	<tr>
	  <td><?php echo $row['user_username']; ?></td>
	  <td><?php echo $row['text']; ?></td>
	</tr>
  <?php }
  

?>
</table>
</body>
</html>