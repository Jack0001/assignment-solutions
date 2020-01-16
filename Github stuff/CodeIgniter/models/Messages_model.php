<!DOCTYPE html>
<html>

<head>
</head>

<body>

<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Messages_model extends CI_model
{
	//Connect to the database
	public function __construct(){$this->load->database();}

	//Get all messages by a specific person from the Messages table and return the result
	public function getMessagesByPoster($name) {
		$sql = "SELECT * FROM Messages WHERE user_username = ? ORDER BY posted_at";
		$query = $this->db->query($sql, array($name));
		return $query->result_array(); 
	}
	
	
	//Search messages in the Messages table and return messages with a string like the parameter
	public function searchMessages($string)
	{
		$sql = "SELECT * FROM Messages WHERE text LIKE ?";
		$query = $this->db->query($sql, array("%$string%"));
		return $query->result_array(); 
	}

	//Insert message given in to Messages table for the user given
	public function insertMessages($poster, $string)
	{
		$sql = "INSERT INTO Messages (user_username, text, posted_at) VALUES (?, ?, now())";
		$query = $this->db->query($sql, array($poster, $string));
	}

	//Get the messages from the followed users of the user given
	public function getFollowedMessages($name)
	{
		$sql = "SELECT * FROM Messages WHERE user_username IN (SELECT followed_username from User_Follows WHERE follower_username = ?) ORDER BY posted_at";
		$query = $this->db->query($sql, array($name));
		return $query->result_array();
	}
}
?>

<body>
</html>
