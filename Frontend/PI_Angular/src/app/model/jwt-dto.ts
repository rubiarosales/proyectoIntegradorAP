export class JwtDto {
    token: String;
    type: String;
    nombreUsuario: String;
    authorities: String[];
   
    constructor (
        token: String,
        type: String,
        nombreUsuario: String,
        authorities: String[]){

            this.token=token;
            this.type=type;
            this.nombreUsuario=nombreUsuario;
            this.authorities=authorities;

    }
}
