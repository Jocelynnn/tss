function zanAnswer($answer_id)
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

	document.getElementById("zanAnswerNum").innerHTML++;

	xmlhttp.onreadystatechange=function()
  	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	    	document.getElementById("zanQuestionNum").innerHTML=document.getElementById("zanQuestionNum").innerHTML + 1;
	    }
	  }
	// xmlhttp.open("GET","gethint.asp?q="+str,true);
	// xmlhttp.send();
	}