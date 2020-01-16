<?php
defined('BASEPATH') OR exit('No direct script access allowed');
?><!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
</head>
<body>

<?php
class Message extends CI_controller
{
	//Load URL helper and session library
	public function __construct()
	{
		parent::__construct();
		$this->load->library('session');
		$this->load->helper("url");
	}
	
	//Redirect user to Login view if not logged in
	public function index()
	{
		if (empty($_SESSION['username']))
		{
			redirect('http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/login', 'refresh');
			
		}
		else
		{
			$this->load->view('Post');
		}
	}

	//Redirect the user to Login view if not logged in
	//Clean the $message input in case of XSS attack
	public function doPost()
	{
		if (empty($_SESSION['username']))
		{
			redirect('http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/login', 'refresh');
		}
		else
		{
			
			$message = $this->input->post('message');
			$message = $this->security->xss_clean($message);
			$username = $_SESSION['username'];
			$this->load->model('Messages_model');
			$this->Messages_model->insertMessages($username, $message);
			redirect('http://raptor.kent.ac.uk/proj/co539c/microblog/jo343/ci/index.php/User/view/'.$username, 'refresh');

		}
	}

}
?>

</body>
</html>