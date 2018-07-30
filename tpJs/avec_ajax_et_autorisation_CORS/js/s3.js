function initComportementJs(){
	console.log("initComportementJs");
	var btnEnregistrer =  document.querySelector("#btnEnregistrer");
	btnEnregistrer.addEventListener("click",enregistrer,false);
	
	var btnListeInscriptions =  document.querySelector("#btnListeInscriptions");
	btnListeInscriptions.addEventListener("click",recupererListeInscriptions,false);
}

function recupererListeInscriptions(){
	var httpRequest = new XMLHttpRequest(); //objet prédéfini du navigateur
    //pour declencher requête Ajax (XHR : XML Http Request)

	//on enregistre sur httpRequest une fonction anonyme "callback"
	//pour traiter la réponse qui va arriver en différé
	httpRequest.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		//si status HTTP en retour == 200 : OK 
		document.querySelector("#spanTableau").innerHTML = this.responseText; 
		}
	};
	//declenchement de la requête:
	httpRequest.open("GET", "http://localhost:8080/myappWeb/services/rest/client");
	httpRequest.send(null);
}

function enregistrer(){
		  var nom =  document.querySelector("#nom").value; 
		  var prenom =   document.querySelector("#prenom").value;  
		  
		  var client = {
			numClient : null,
			nom : nom ,
			prenom : prenom 
		  }; //expression "objet lit(t)eral javascript" (très proche du format JSON) .
		  
		  //on peut dynamiquement ajouter des propriétés supplémentaires sur l'objet client :
		  client.telephone = document.querySelector("#telephone").value;
		  client.adresse = document.querySelector("#adresse").value;
		  client.email = document.querySelector("#email").value;
	      var clientAsJsonString = JSON.stringify(client);
	      
	      var httpRequest = new XMLHttpRequest(); //objet prédéfini du navigateur
	                  //pour declencher requête Ajax (XHR : XML Http Request)

	      //on enregistre sur httpRequest une fonction anonyme "callback"
	      //pour traiter la réponse qui va arriver en différé
	      httpRequest.onreadystatechange = function() {
	    	  if (this.readyState == 4 && this.status == 200) {
	    		 //si status HTTP en retour == 200 : OK 
	    		  document.querySelector("#spanRes").innerHTML = this.responseText; 
	    	  }
	      };
	      //declenchement de la requête:
	      httpRequest.open("POST", "http://localhost:8080/myappWeb/services/rest/client");
	      httpRequest.setRequestHeader("Content-Type" , "application/json");
	      httpRequest.send(clientAsJsonString);
	      console.log ("donnees de la requete envoyee : " + clientAsJsonString)	; 
	      
          //document.querySelector("#spanRes").innerHTML = clientAsJsonString;		  
}