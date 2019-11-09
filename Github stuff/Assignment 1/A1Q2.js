function createBoxes(element)
{
    container = document.getElementById("container")

    while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }

    number = element.value;

    for(i = 0; i < number; i++)
    {
        box = document.createElement("div");

        box.setAttribute("style", "display:inline-block; width: 20px; height: 20px; background:" + createRandomColor() + " ; margin-left: " + Math.pow(2, i) * 5 + "px" )


        
        document.getElementById("container").appendChild(box);
    }
}

//Taken from https://www.w3resource.com/javascript-exercises/javascript-math-exercise-40.php
//Accessed 27/02/19
function createRandomColor() {
    var x = Math.floor(Math.random() * 256);
    var y = Math.floor(Math.random() * 256);
    var z = Math.floor(Math.random() * 256);
    return "rgb(" + x + "," + y + "," + z + ")";
  }

  function deleteBox(element)
  {
      print("dick");
  }