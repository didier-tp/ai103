
function initComportementJs(){
	console.log("initComportementJs");
	var btnEnregistrer =  document.querySelector("#btnEnregistrer");
	btnEnregistrer.addEventListener("click",enregistrer,false);
}

//fonction constructeur pour type d'objet "Client"
function Client(nom, prenom){
	this.prenom = prenom;
	this.nom = nom;
}

function myStringify(obj){
	var jsonString = "{" ;
	for(indice in obj){
		if(jsonString != "{"){
			jsonString+=",";
		}
		if( typeof obj[indice] == 'string'){
			jsonString += '"'+ indice + '"="' + obj[indice] + '"';
		}else {
			jsonString += '"'+ indice + '"=' + obj[indice] ;
		}
	}
	jsonString +="}";
	return jsonString;
}

function enregistrer(){
		  var nom =  document.querySelector("#nom").value; 
		  var prenom =   document.querySelector("#prenom").value;  
		  
		  var client = new Client(nom,prenom);//création d'une instance de Client
		  
		  //on peut dynamiquement ajouter des propriétés supplémentaires sur l'objet client :
		  client.telephone = document.querySelector("#telephone").value;
		  client.adresse = document.querySelector("#adresse").value;
		  client.email = document.querySelector("#email").value;
		  client["age"]=30; //client.age=30;
		  client.estFou=false;
		   
		  // JSON.stringify() est une fonction prédéfinie de javascript qui construit automatiquement
		  // une chaine de caractère au format JSON à partir de toutes les valeurs d'un objet javascript
		  // ça ressemble un peu au .toString() de java ou à la serialization java
	      var clientAsJsonString = JSON.stringify(client);
		  //var clientAsJsonString = myStringify(client);
		  
          document.querySelector("#spanRes").innerHTML = clientAsJsonString;
		 	  
}