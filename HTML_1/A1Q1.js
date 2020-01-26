function reset()
{

    document.getElementById("formID").reset();
}

function display()
{

    var table = document.getElementById("tBody");
    var row = table.insertRow();
    var cell1 = row.insertCell();
    var cell2 = row.insertCell();
    var cell3 = row.insertCell();
    var cell4 = row.insertCell();
    var btn = document.createElement("BUTTON");

    cell1.innerHTML = document.getElementById("formName").value;
    cell2.innerHTML = document.getElementById("formDOB").value;
    cell3.innerHTML = document.getElementById("formEyeColour").value;
    text = document.createTextNode("Delete");
    btn.appendChild(text)
    document.body.appendChild(btn)
    cell4.appendChild(btn);
    
    btn.setAttribute("onclick", "deleteRow(this)")

    document.getElementById("counter").innerHTML++;
    reset();
}

function deleteRow(element)
{
    element.closest("tr").remove();
    document.getElementById("counter").innerHTML--;

}