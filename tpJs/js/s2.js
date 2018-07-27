function calculerOperation(pOperation){
		  
		  var a =  document.querySelector("#a").value; //document.getElementById("a").value;
		  console.log("a="+a);
		  var b =   document.querySelector("#b").value;  //document.getElementById("b").value;
		  console.log("b="+b);
		  
		  var res = 0;
		  if(pOperation == '+'){
		      res = Number(a)+Number(b); // le + déclenche une concaténation entre 2 string
		                 //ou bien une addition entre 2 choses numériques
		    }else if(pOperation == '*'){
			  res=a*b;
		   }
		  
		  //document.getElementById("spanRes").innerHTML = res;
          document.querySelector("#spanRes").innerHTML = res;
		  
		  document.querySelector(".enEvidence").style.backgroundColor = "yellow";	
          /* 
          var tabInputs = document.querySelectorAll("input");
		  for( index in tabInputs){
			  if(tabInputs[index] != null)
			     tabInputs[index].style.backgroundColor = "green";	
		  }
          */
          		  
		}