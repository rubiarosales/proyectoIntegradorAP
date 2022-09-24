export class Habilidades {
    id?: number;
    habilidad!: string;
    nivel!: string;

    constructor(
        habilidad: string,
        nivel: string) {

        this.habilidad = habilidad;
        this.nivel = nivel;
    }

}
