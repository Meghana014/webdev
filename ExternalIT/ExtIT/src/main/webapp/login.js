function frmvalidation()
{
	
    if(f1.id.value=="")
     {
        alert("You must enter ID")
        f1.id.focus()
        return false
    }
    if(f1.psd.value=="" || f1.psd.value.length<6)
    {
		alert("you must enter 6 digit password")
		f1.psd.focus();
		return false;
	}
 }