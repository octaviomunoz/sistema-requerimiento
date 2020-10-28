import React from 'react';

import axios from 'axios';

class Login extends React.Component{

    constructor(props){
        super(props);
    }


    clicEventos(evento){
        evento.preventDefault();
        console.log(evento.target[0].value);
        console.log(evento.target[1].value);

        var data = JSON.stringify({
            "rut": evento.target[0].value,
            "pass": evento.target[1].value
          });
          
          var xhr = new XMLHttpRequest();
          xhr.withCredentials = true;
          
          xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
              console.log(this.responseText);
            }
          });
          
          xhr.open("POST", "/login");
          xhr.setRequestHeader("content-type", "application/json");
          xhr.setRequestHeader("token", localStorage.getItem("token"));
          
          xhr.send(data);

          xhr.onreadystatechange = function(){
            if(xhr.readyState === 4 && xhr.status === 200) {
                var token = xhr.getResponseHeader("authorization");
                localStorage.setItem('token', token);
                console.log(token);
            }else if (xhr.status === 404){
              console.log(xhr.responseText);
              console.log(xhr.statusText);
      
            }else{
              console.log("la peticion  http no funciona");
              console.log(xhr.statusText)
            }
      
            }
      }
    
      render(){
        return(
          <form onSubmit={this.clicEventos}>
            <h1>{"Formularios EWebik"}</h1>
            <input type="text" placeholder="Nombre" />
            <input type="text" placeholder="Correo" />
            <button>
              Enviar
            </button>
          </form>
        )
      }
}

export default Login;