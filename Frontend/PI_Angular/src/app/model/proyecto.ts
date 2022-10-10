export class Proyecto {
    id?: number;
    titulo: string;
    fecha: string;
    url_img: string;
    url_proyecto: string;

    constructor(
        titulo: string,
        fecha: string,
        url_img: string,
        url_proyecto: string) {

        this.titulo = titulo;
        this.fecha = fecha;
        this.url_img = url_img;
        this.url_proyecto = url_proyecto;
    }

}
