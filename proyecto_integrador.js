// SCRIPT DEL HEADER
const abrirMenuBtn = document.querySelector(".abrirMenu-responsive");
const cerrarMenuBtn = document.querySelector(".cerrarMenu-responsive");
const redesSociales = document.querySelector(".social-bar");

function abrir() {
    redesSociales.classList.toggle("menu-abierto");
    inicioDeSesion.style.display="none";
    recuperarContraseña.style.display="none";
    registrarse.style.display="none";
    entrarBtn.style.display="flex";
    salirBtn.style.display="none";
    // redesSociales.classList.remove("menu-cerrado");
}
function cerrar() {
    redesSociales.classList.remove("menu-abierto");
    // redesSociales.classList.add("menu-cerrado");
    // redesSociales.style.transition="width 0.5s";
}
abrirMenuBtn.addEventListener("click",abrir);
cerrarMenuBtn.addEventListener("click",cerrar);


//SCRIPT DEL INICIO DE SESIÓN
const entrarBtn = document.querySelector(".login-logo");
const salirBtn = document.querySelector(".logout-logo");
const inicioDeSesion = document.querySelector(".login-section");

function entrar() {
    inicioDeSesion.style.display="flex";
    entrarBtn.style.display="none";
    salirBtn.style.display="flex";
}
function salir() {
    inicioDeSesion.style.display="none";
    entrarBtn.style.display="flex";
    salirBtn.style.display="none";
    recuperarContraseña.style.display="none";
    registrarse.style.display="none";
    
}
entrarBtn.addEventListener("click",entrar);
salirBtn.addEventListener("click",salir);

//SCRIPT DEL REGISTRO
const registro = document.querySelector(".registro");
const registrarse = document.querySelector(".register-section");

function registrar() {
    registrarse.style.display="flex";
    inicioDeSesion.style.display="none";
}

registro.addEventListener("click",registrar);

//SCRIPT DEL RECUPERO
const recupero = document.querySelector(".recupero");
const recuperarContraseña = document.querySelector(".forgot-section");

function recuperar() {
    recuperarContraseña.style.display="flex";
    inicioDeSesion.style.display="none";
    registrarse.style.display="none";
}

recupero.addEventListener("click",recuperar);

// SCRIPT DE SKILLS
let progressBar=document.querySelector(".skill-graphic");
let valueContainer=document.querySelector(".skill-level");
let value=document.querySelector(".skill-level").innerHTML;
let container= document.querySelector(".skill-container").children;
console.log(container)

let progressValue=0;
let speed= 80;

for (let elemento of container) {
console.log(elemento);
}

let progress = setInterval( ()=>{
    progressValue++;
    // progressBar.style.backgroundColor=`green`;
    console.log(progressBar);
    progressBar.style.background=`conic-gradient(
        blue ${progressValue * 3.6}deg,
        green ${progressValue * 3.6}deg
    )`;
    // console.log(progressValue);
    if(progressValue==value){
        clearInterval(progress);
    }
    valueContainer.textContent=`${progressValue}%`;
},speed);


