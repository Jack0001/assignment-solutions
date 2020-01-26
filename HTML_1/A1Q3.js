var currentPlayer = "x";
var finished = false;
var filled1 = false
var filled2 = false
var filled3 = false
var filled4 = false
var filled5 = false
var filled6 = false
var filled7 = false
var filled8 = false
var filled9 = false

function createGameBoard()
{
  for ( var i = 0; i < 9; i++)
  {
    document.getElementById("box4").style.clear = "left";
    document.getElementById("box7").style.clear = "left";
  }
}

function fillBox(number)
{
  var clickedBox = document.getElementById("box" + number)
if (!finished)
{
  if (number == 1 && !filled1)
  {
    box1.innerText = currentPlayer;
    filled1 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 2 && !filled2)
  {
    box2.innerText = currentPlayer;
    filled2 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 3 && !filled3)
  {
    box3.innerText = currentPlayer;
    filled3 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 4 && !filled4)
  {
    box4.innerText = currentPlayer;
    filled4 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 5 && !filled5)
  {
    box5.innerText = currentPlayer;
    filled5 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 6 && !filled6)
  {
    box6.innerText = currentPlayer;
    filled6 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 7 && !filled7)
  {
    box7.innerText = currentPlayer;
    filled7 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 8 && !filled8)
  {
    box8.innerText = currentPlayer;
    filled8 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
  if (number == 9 && !filled9)
  {
    box9.innerText = currentPlayer;
    filled9 = true;
    if (currentPlayer == "x")
    {currentPlayer = "o"}
    else
    {currentPlayer = "x"}
  }
    
    
    if (!finished)
    {
    GameOver()
    }
  }
}


function GameOver()
{
  if(box1.innerText == "o" && box2.innerText == "o" && box3.innerText == "o")
  {
    finished = true;

    box1.style.backgroundColor = "red"
    box2.style.backgroundColor = "red"
    box3.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box4.innerText == "o" && box5.innerText == "o" && box6.innerText == "o")
  {
    finished = true;

    box4.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box6.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box7.innerText == "o" && box8.innerText == "o" && box9.innerText == "o")
  {
    finished = true;

    box7.style.backgroundColor = "red"
    box8.style.backgroundColor = "red"
    box9.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box1.innerText == "o" && box4.innerText == "o" && box7.innerText == "o")
  {
    finished = true;

    box1.style.backgroundColor = "red"
    box4.style.backgroundColor = "red"
    box7.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box2.innerText == "o" && box5.innerText == "o" && box8.innerText == "o")
  {
    finished = true;

    box2.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box8.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box3.innerText == "o" && box6.innerText == "o" && box9.innerText == "o")
  {
    finished = true;

    box3.style.backgroundColor = "red"
    box6.style.backgroundColor = "red"
    box9.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box1.innerText == "o" && box5.innerText == "o" && box9.innerText == "o")
  {
    finished = true;

    box1.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box9.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }
  else if (box3.innerText == "o" && box5.innerText == "o" && box7.innerText == "o")
  {
    finished = true;

    box3.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box7.style.backgroundColor = "red"

    alert("Player O is the winner");
    location.reload();
  }

  if(box1.innerText == "x" && box2.innerText == "x" && box3.innerText == "x")
  {
    finished = true;

    box1.style.backgroundColor = "red"
    box2.style.backgroundColor = "red"
    box3.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box4.innerText == "x" && box5.innerText == "x" && box6.innerText == "x")
  {
    finished = true;

    box4.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box6.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box7.innerText == "x" && box8.innerText == "x" && box9.innerText == "x")
  {
    finished = true;

    box7.style.backgroundColor = "red"
    box8.style.backgroundColor = "red"
    box9.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box1.innerText == "x" && box4.innerText == "x" && box7.innerText == "x")
  {
    finished = true;

    box1.style.backgroundColor = "red"
    box4.style.backgroundColor = "red"
    box7.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box2.innerText == "x" && box5.innerText == "x" && box8.innerText == "x")
  {
    finished = true;

    box2.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box8.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box3.innerText == "x" && box6.innerText == "x" && box9.innerText == "x")
  {
    finished = true;

    box3.style.backgroundColor = "red"
    box6.style.backgroundColor = "red"
    box9.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box1.innerText == "x" && box5.innerText == "x" && box9.innerText == "x")
  {
    finished = true;

    box1.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box9.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if (box3.innerText == "x" && box5.innerText == "x" && box7.innerText == "x")
  {
    finished = true;

    box3.style.backgroundColor = "red"
    box5.style.backgroundColor = "red"
    box7.style.backgroundColor = "red"

    alert("Player X is the winner");
    location.reload();
  }
  else if(filled1 && filled2 && filled3 && filled4 && filled5 && filled6 && filled7 && filled8 && filled9)
  {
    finished = true;
    alert("Player X and Player O drew");
    location.reload();
  }
}
