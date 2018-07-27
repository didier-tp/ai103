function calculerAddition(){
		  
		  var a =  document.getElementById("a").value;
		  console.log("a="+a);
		  var b =  document.getElementById("b").value;
		  console.log("b="+b);
		  var res = a+b;
		  
		  document.getElementById("spanRes").innerHTML = res; 
		}