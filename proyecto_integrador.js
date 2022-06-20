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
