<?php
defined('BASEPATH') OR exit('No direct script access allowed');


class Users_model extends CI_model
{
	//Connect to the database
	//Load session library
	public function __construct()
	{
		parent::__construct();
		$this->load->library('session');
		$this->load->database();
	}
	
	//Check the user name and password entered
	//If they exist in the Users table return true, otherwise return false
	public function checkLogin($username, $pass)
	{

		$pass = sha1($pass);
		$sql = "SELECT username FROM Users WHERE username = ? AND password = ?";
		$query = $this->db->query($sql, array($username, $pass));
		

		return !empty($query->result_array());
	}

	//Check if the $follower is following $followed
	public function isFollowing($follower, $followed)
	{
		$sql = "SELECT * FROM User_Follows WHERE follower_username = ? AND followed_username = ?";
		$query = $this->db->query($sql, array($follower, $followed));
		

		return !empty($query->result_array());
	}

	//Inserts in to User_Follows table
	//Logged in user now follows $followed
	public function follow($followed)
	{
		$user = $_SESSION['username'];

		$sql = "INSERT INTO User_Follows (follower_username, followed_username) VALUES (?, ?)";
		$query = $this->db->query($sql, array($user, $followed));

	}
}


?>
