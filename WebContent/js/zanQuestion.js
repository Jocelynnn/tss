function zanQuestion(q_id)
{
	var xmlhttp;
	
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }

	document.getElementById("zanQuestionNum").innerHTML++;

	xmlhttp.onreadystatechange=function()
  	  {
  	  		    		alert(document.getElementById("zanQuestionNum").innerHTML);

	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {

	    	document.getElementById("zanQuestionNum").innerHTML=document.getElementById("zanQuestionNum").innerHTML + 1;
	    }
	  }
	 // xmlhttp.open("GET","../php/zanQuestion?q_id=" + q_id,true);
	 // xmlhttp.send();
	}