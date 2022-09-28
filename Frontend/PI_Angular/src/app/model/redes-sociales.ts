export class RedesSociales {
    id?: number;
    nombre!: string;
    url_red!: string;
    url_logo!: string;

    constructor(
        nombre: string,
        url_red: string,
        url_logo: string) {

        this.nombre = nombre;
        this.url_red = url_red;
        this.url_logo = url_logo;
    }
}
