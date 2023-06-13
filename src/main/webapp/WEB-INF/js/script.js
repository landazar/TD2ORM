function afficherCB()
{
	var type = document.getElementById("type");
	
	while (type.firstChild) {
  		type.removeChild(type.firstChild);
	}
	
	var numeroCB = document.createElement("input");
	numeroCB.type = "text";
	numeroCB.name = "numeroCB";
	numeroCB.placeholder = "Numéro CB";
	
	type.appendChild(numeroCB);
	
	var dateE = document.createElement("input");
	dateE.type = "date";
	dateE.name = "dateE";
	dateE.placeholder = "Date expiration";
	
	type.appendChild(dateE);
}
function afficherPaypal()
{
	var type = document.getElementById("type");
	while (type.firstChild) {
  		type.removeChild(type.firstChild);
	}
	
	var numPaypal = document.createElement("input");
	numPaypal.type = "number";
	numPaypal.name = "numPaypal";
	numPaypal.placeholder = "Numéro Paypal";
	
	type.appendChild(numPaypal);
}