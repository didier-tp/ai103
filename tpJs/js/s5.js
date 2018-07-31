
function initComportementJs(){
	console.log("initComportementJs");
	var btnAfficher =  document.querySelector("#btnAfficher");
	btnAfficher.addEventListener("click",calculerEtAfficher,false);
}

 
function calculerEtAfficher(){
		  
     var fx =  document.querySelector("#fx").value;
	 var x = 0;
	 for(x=-10;x<=10;x=x+1){
		 y = eval(fx);
		 console.log("x="+x +" ,y=" + y);
	 }
		 	  
}