<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
</head>
<body>
<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User extends CI_Controller {
	
	//Load the session library and the form helper
	public function __construct()
	{
		parent::__construct();
		$this->load->library('session');
		$this->load->helper('form');
	}

	//Load the Users_model
	//If the user logged in is not currently following the user that they are viewing messages for, then a follow button appears
	//If the logged in user is viewing themselves then dont display the button, a user cannot follow themselves
	//Loads the Messages_model, then runs the getMessagesByPoster function on the name entered
	//If there are no results, print "No rows found", otherwise print the results using the ViewMessages view

	public function view($name)
	{
		$this->load->model('Users_model');
		
		if ($_SESSION['username'] != $name)
		{
			$isFollowed = $this->Users_model->isFollowing($_SESSION['username'], $name);
			
			if(!$isFollowed)
			{
				
				print "<a href='http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/follow/$name'>Follow $name</a>";
				print "<br>";
			}
		}
		

		
		$this->load->model('Messages_model');
		$data = $this->Messages_model->getMessagesByPoster($name);

		if(count($data) == 0) { echo "No rows found"; return; }

		$viewData = array("results" => $data);
		$this->load->view('ViewMessages', $viewData); 
	  

	}
	
	//Loads the login view
	public function login()
	{
		$this->load->view("Login");	
	}

	//Logout the user by destroying the current session data
	public function logout()
	{
		$this->session->sess_destroy();
		redirect('http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/login', 'refresh');		
	}

	//Log the user in
	//Load the Users model, and retrieve the information using the POST
	public function doLogin()
	{
		$this->load->model('Users_model');
		$username = $this->input->post('username');
		$pass = $this->input->post('pass');
		$successful = $this->Users_model->checkLogin($username, $pass);

		if (!$successful)
		{
			$this->load->view("Login");
			echo("Wrong username/password");
		}
		else
		{
			$this->session->set_userdata('username', $username);
			$this->view($username);		
		}
	}

	//Load a feed of messages from followed users
	public function feed($name)
	{
		$this->load->model('Messages_model');
		$data = $this->Messages_model->getFollowedMessages($name);
		
		
		$viewData = array("results" => $data);

		$this->load->view('ViewMessages', $viewData);
	}


	//Loads the Users_model and invokes the follow function
	//Adds to the database that the current logged in user now follows $followed
	public function follow($followed)
	{
		$this->load->model('Users_model');
		$data = $this->Users_model->follow($followed);
		redirect('http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/view/'.$followed, 'refresh');
	}


}
?>

</body>
</html>

