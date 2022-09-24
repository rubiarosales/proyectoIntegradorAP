export class Experiencia {
    id?: number;
    cargo!: string;
    empresa!: string;
    fecha!: string;
    descripcion_cargo!: string;
    url_logo!: string;

    constructor(
        cargo: string,
        empresa: string,
        fecha: string,
        descripcion_cargo: string,
        url_logo: string) {

        this.cargo = cargo;
        this.empresa = empresa;
        this.fecha = fecha;
        this.descripcion_cargo = descripcion_cargo;
        this.url_logo = url_logo;
    }

}


