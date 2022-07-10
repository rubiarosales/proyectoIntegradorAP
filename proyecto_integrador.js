// SCRIPT DEL HEADER
const abrirMenuBtn = document.querySelector(".abrirMenu-responsive");
const cerrarMenuBtn = document.querySelector(".cerrarMenu-responsive");
const redesSociales = document.querySelector(".social-bar");

function abrir() {
    redesSociales.classList.toggle("menu-abierto");
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