
function initComportementJs(){
	console.log("initComportementJs");
	var btnAction =  document.querySelector("#btnAction");
	btnAction.addEventListener("click",doAction,false);
}

function doAction(){
	
	var eltListe = document.getElementById("idListe"); //ou .querySelector("#idListe")
	var listeValeurAsJsonString=
	'[ { "label" : "janvier" , "value" : 120} , { "label" : "fevrier" , "value" : 70 } ]';
	var tableauObjetsJs = JSON.parse(listeValeurAsJsonString);
	for(i=0;i<tableauObjetsJs.length;i++){
		var eltLI = document.createElement("li"); 
		eltListe.appendChild(eltLI); //ajouter <li> dans parent <ul>
		var objetJs = tableauObjetsJs[i]
		var noeudTexte = document.createTextNode(objetJs.label + " : " + objetJs.value);
	    eltLI.appendChild(noeudTexte);
	}
	
    var eltDivA = document.getElementById("divA"); //ou .querySelector("#divA")
	
	var nouvelEltP = document.createElement("p");
	eltDivA.appendChild(nouvelEltP);
	
	var noeudTexte = document.createTextNode("789");
	nouvelEltP.appendChild(noeudTexte);
	
	var listeSousElements = eltDivA.childNodes;
	var nbVal= 0;
	var sommeVal = 0;
	for(i=0;i<listeSousElements.length;i++){
		var sousElement = listeSousElements.item(i);	
		if(sousElement.nodeType==Node.ELEMENT_NODE) {
		    console.log(sousElement.nodeName + " : " + sousElement.innerHTML );
			if(sousElement.nodeName.toLowerCase()  == "p" ){
				nbVal ++;
				sommeVal += Number(sousElement.innerHTML); //encore améliorable
			}
		}
	}
	console.log("nbVal=" + nbVal + ", sommeVal=" + sommeVal + ", moyenne=" + sommeVal/nbVal );
}
