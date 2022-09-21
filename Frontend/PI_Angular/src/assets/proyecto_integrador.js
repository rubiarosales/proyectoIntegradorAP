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
}
abrirMenuBtn.addEventListener("click",abrir);
cerrarMenuBtn.addEventListener("click",cerrar);

// SCRIPT DE SKILLS
let container= document.querySelector(".skill-container").children;

for (let elemento of container) {
    let progressBar=elemento.querySelector(".skill-graphic");
    let valueContainer=elemento.querySelector(".skill-level");
    let value=elemento.querySelector(".skill-level").innerHTML;
    let progressValue=0;
    let speed= 70;
    
    let progress = setInterval( ()=>{
        progressValue++;
        progressBar.style.background=`conic-gradient(
            var(--color-secundario) ${progressValue * 3.6}deg,
            #ffffff00 ${progressValue * 3.6}deg
            )`;
        if(progressValue==value){
            clearInterval(progress);
        }
        valueContainer.textContent=`${progressValue}%`;
    },speed);

}