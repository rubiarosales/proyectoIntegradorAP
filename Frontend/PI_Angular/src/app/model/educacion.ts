export class Educacion {
    id?: number;
    institucion!: string;
    titulo!: string;
    fecha!: string;
    url_logo!: string;

    constructor(
        institucion: string,
        titulo: string,
        fecha: string,
        url_logo: string) {

        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.url_logo = url_logo;
    }

}
