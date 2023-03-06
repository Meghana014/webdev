function validatereg()
{
    if(f.fname.value=="")
     {
        alert("You must enter firstName")
        f.fname.focus()
        return false
    }
    if(f.fname.value.length<3)
    {
        alert("firstName must consist of atleast 3 character")
        f.fname.focus()
        return false
    }
    if(f.lname.value=="")
    {
        alert("you must enter lastname!!")
        f.lname.focus()
        return false
    }
    if(f.lname.value.length<3)
     {
        alert("lastName must consist of atleast 3 character") 
        f.lname.focus()
        return false
    }
    flag=true
    if(f.ph.value.length!=10)
        flag=false
    var ph=f.ph.value 
    for(i=0;i<ph.length;i++)
    {
        if(!(ph.charCodeAt(i)>=48&&ph.charCodeAt(i)<=57))
        flag=false
    }
    if(!flag)
    {
     alert("Please enter valid Phone Number with 10 digits") 
     f.ph.focus()
     return false
    }
    flag=true 
    if(f.mail.value=="") 
    flag=false
    var str=f.mail.value; 
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
        f.mail.focus()
        return false
    }
    
    flag=false
    for(i=0;i<f.m.length;i++)
    {
       if(f.m[i].checked)
        flag=true
    }
    if(!(flag))
    {
        alert("Please choose a Gender")
        return false
    }
   
    if(f.pass.value.length<6)
    {
        alert("Please enter Password not less than 6")
        f.pass.focus()
        return false
    }
    if(!(f.pass.value==f.pass1.value))
    {
       alert("Re-enter corrert Password,passwords must be same")
       f.pass1.focus()
       return false
    }
    else
    {
		alert("You can proceed to register")
		return false
	}
}