<!DOCTYPE html>
<head>
</head>
<body>
<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Search extends CI_Controller {

	
	//Loads the Search view
	public function index()
	{
		$this->load->view('Search');
	}

	//Loads the Messages_model, gets the search data and sends it to the searchMessages function
	//If there are no results, print "No rows found", otherwise print the results using the ViewMessages view
	public function doSearch()
	{
		$this->load->model('Messages_model');
		$input = $this->input->get('search');
		$data = $this->Messages_model->searchMessages($input);
		
		if(count($data) == 0) { echo "No rows found"; return; }
		$viewData = array("results" => $data);

		
		$this->load->view('ViewMessages', $viewData);
	}

}
?>
</body>
</html>	

