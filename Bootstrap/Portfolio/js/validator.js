const contactForm=document.querySelector('#contactus');
const email = document.querySelector('#InputEmail');
const message = document.querySelector('#InputMessage');


contactForm.addEventListener('submit',(e) =>{
    e.preventDefault();

    if(email.value==='' || message.value==='')  
   {

     if(email.value==''){
        alert("Email Cannot Empty");
        
    }

    if(message.value==''){
        alert("Atleast Enter Some Message");
    }
    
   }else{
  
    alert("Your Message Sent Successfully")
   }
})
