export class Persona {

    id?: number;
    nombre!: string;
    apellido!: string;
    titulo!: string;
    domicilio!: string;
    telefono!: string;
    email!: string;
    sobre_mi!: string;
    url_foto!: string;

    constructor(
        nombre: string,
        apellido: string,
        titulo: string,
        domicilio: string,
        telefono: string,
        email: string,
        sobre_mi: string,
        url_foto: string) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.sobre_mi = sobre_mi;
        this.url_foto = url_foto;
    }
}
