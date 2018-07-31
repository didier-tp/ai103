
function initComportementJs(){
	console.log("initComportementJs");
	var btnAfficher =  document.querySelector("#btnAfficher");
	btnAfficher.addEventListener("click",calculerEtAfficher,false);
}

 
function calculerEtAfficher(){
		  
     var fx =  document.querySelector("#fx").value;
	 var x = 0;
	 
	 
	 var canvasElement = document.getElementById("idCanvas");
	 var ctx = canvasElement.getContext("2d");
		ctx.beginPath();
		
	var h=400;
    var	l=600;
	var oh = h/2 
	var ol=l/2;
	
	ctx.moveTo(0,oh); ctx.lineTo(l,oh); //axe horizontal
	ctx.moveTo(ol,0); ctx.lineTo(ol,h); //axe vertical
	
	for(x=-10;x<=10;x=x+1){
		 y = eval(fx);
		 console.log("x="+x +" ,y=" + y);
	 }
		
     ctx.closePath();
	 ctx.stroke(); 	  
}