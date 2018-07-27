function calculerAddition(){
		  
		  var a =  document.getElementById("a").value;
		  console.log("a="+a);
		  var b =  document.getElementById("b").value;
		  console.log("b="+b);
		  var res = Number(a)+Number(b); // le + déclenche une concaténation entre 2 string
		                 //ou bien une addition entre 2 choses numériques
		  
		  document.getElementById("spanRes").innerHTML = res; 
		}