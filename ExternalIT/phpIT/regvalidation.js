function frmvalidation()
{
	
    if(f.name.value=="")
     {
        alert("You must enter Name")
        f.name.focus()
        return false
    }
   
    if(f.name.value.length<3)
     {
        alert("Name must consist of atleast 3 character") 
        f.name.focus()
        return false
    }
    flag=true
    if(f.phno.value.length!=10)
        flag=false
    var ph=f.phno.value 
    for(i=0;i<ph.length;i++)
    {
        if(!(ph.charCodeAt(i)>=48&&ph.charCodeAt(i)<=57))
        flag=false
    }
    if(!flag)
    {
     alert("Please enter valid Phone Number with 10 digits") 
     f.phno.focus()
     return false
    }
    flag=true 
    if(f.email.value=="") 
    flag=false
    var str=f.email.value; 
    for(i=0;i<str.length;i++)
    {
        if(str.charAt(i)=="@")
        {
            if((str.substr(i+1,9)=="yahoo.com")||(str.substr(i+1,9)=="gmail.com"))
            {
                flag=true
                break
            }
        }
        else
            flag=false
    }
    if(!flag)
    {
        alert("Please enter a valid Email ID") 
        f.email.focus()
        return false
    }
    
    flag=false
    for(i=0;i<f.gender.length;i++)
    {
       if(f.gender[i].checked)
        flag=true
    }
    if(!(flag))
    {
        alert("Please choose a Gender")
        return false
    }
   
    if(f.psd.value.length<6)
    {
        alert("Please enter Password not less than 6")
        f.psd.focus()
        return false
    }
    if((f.date.selectedIndex<=0)||(f.month.selectedIndex<=0)||(f.year.selectedIndex<=0))
    {
     alert("Please choose a Date of Birth"); 
     return false;
    }
    //checkbox validation flag=false;

    for (i=0;i<f.lang.length;i++)
    {
     if (f.lang[i].checked)
      flag = true;
    }
   if(!(flag))
   {
    alert("Please select at least one of the \"Language\" options."); 
    return false;
   }
//address validation 
if(f.address.value.length<25)
{
alert("Please enter a Correct Address");
return false;
}
else
{
	alert("registration success!!");
}
}