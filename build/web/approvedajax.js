function checkform(form){
                 if(form.user.value === "" ){
                   alert("this is null name");
                   return false;
               }
                 else if(form.pwd.value === ""){
                   alert("this is null password");
                   return false;
               }   
            }
 $(document).ready(function(){
  //global vars
  var option = $("#option"); //user name field
  //function to check name and comment field 
  function checkCommentsForm(){
    if(option.val())
      return true;
    else
      return false;
  }

//When form submitted
  $("#approval").submit(function(){
    if( checkCommentsForm()){
      $.ajax({
        type: "post"
        ,data:"option="+ option.val()// username="+userName.val()+"&pwd="+userPass.val()+"&telephone="+userphone.val()+"&email="+userEmail.val()
        ,url: "Cres_cv_approval"
        ,success: function(msg) {$('#targetDiv').hide();$("#targetDiv").html ("<h3>" + msg + "</h3>").fadeIn("slow");}
        });
        }
    else alert("Please submit cv");
    return false;
  });
});


