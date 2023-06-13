/**
 * 
 */

 function afficherCB() {
	 
	 var type = document.getElementById("type");
	 	 
	 
	 while (type.firstChild) {
		 type.removeChild(type.firstChild); //Enlève les balises si on a déjà cliqué sur le bouton. Evite répétitions.
		}
	 
	 var numeroCB = document.createElement("input");
	 numeroCB.type = "text";
	 numeroCB.name = "numeroCB";
	 numeroCB.placeholder = "Numéro CB";
	 
	 type.appendChild(numeroCB);
	 
	 
	 var dateE = document.createElement("input");
	 dateE.type = "date";
	 dateE.name = "dateE";
	 dateE.placeholder = "Date d'expiration";
	 
	 type.appendChild(dateE);
	 
 
 }
 
 
 function afficherPaypal() {
	 
	 var type = document.getElementById("type");
	 
	 while (type.firstChild) {
		 type.removeChild(type.firstChild); //Enlève les balises si on a déjà cliqué sur le bouton. Evite répétitions.
	 }
	 
	 var numPaypal = document.createElement("input");
	 numPaypal.type = "text";
	 numPaypal.name = "numPaypal";
	 numPaypal.placeholder = "Numéro PayPal";
	 
	 type.appendChild(numPaypal);
	 
 }