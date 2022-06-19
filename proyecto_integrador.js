const abrirMenuBtn = document.querySelector(".abrirMenu-responsive");
const cerrarMenuBtn = document.querySelector(".cerrarMenu-responsive");
const redesSociales = document.querySelector(".social-bar");

function abrir() {

    redesSociales.classList.toggle("menu-abierto");
    



}
function cerrar() {

    redesSociales.classList.toggle("menu-abierto");



}

abrirMenuBtn.addEventListener("click",abrir);
cerrarMenuBtn.addEventListener("click",cerrar);
