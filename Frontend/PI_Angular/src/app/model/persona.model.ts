export class persona{
    id?:number;
    nombre: String;
    apellido: String;
    titulo: String;
    domicilio: String;
    telefono: String;
    email: String;
    sobre_mi: String;
    url_foto: String;
   
    constructor (
        nombre: String,
        apellido: String,
        titulo: String,
        domicilio: String,
        telefono: String,
        email: String,
        sobre_mi: String,
        url_foto: String){

            this.nombre=nombre;
            this.apellido=apellido;
            this.titulo=titulo;
            this.domicilio=domicilio;
            this.telefono=telefono;
            this.email=email;
            this.sobre_mi=sobre_mi;
            this.url_foto=url_foto;

    }
}