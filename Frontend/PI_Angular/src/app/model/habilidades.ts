export class Habilidades {
    id?: number;
    habilidad!: string;
    nivel!: number;

    constructor(
        habilidad: string,
        nivel: number) {

        this.habilidad = habilidad;
        this.nivel = nivel;
    }

}
