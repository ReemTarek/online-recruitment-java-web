/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
  var userName = $("#username"); //user name field
  var userPass = $("#pwd"); //password field
  var userphone = $("#phone");
  var userEmail = $("#email");
  //function to check name and comment field 
  function checkCommentsForm(){
    if(userName.val() && userPass.val())
      return true;
    else
      return false;
  }

  //When form submitted
  $("#Rform").submit(function(){
    if( checkCommentsForm()){
      $.ajax({
        type: "post"
        ,data:"username="+userName.val()+"&pwd="+userPass.val()+"&telephone="+userphone.val()+"&email="+userEmail.val()
        ,url: "Ccandidate_signup"
        ,success: function(msg) {$('#targetDiv').hide();$("#targetDiv").html ("<h3>" + msg + "</h3>").fadeIn("slow");}
        });
        }
    else alert("Please fill UserName & Password!");
    return false;
  });
});

