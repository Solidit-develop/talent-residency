import dotenv from 'dotenv';

// Cargar las variables de entorno desde el archivo .env
dotenv.config();

console.log(" ");
console.log("Estas son las variables de entorno")
// console.log(process.env)

interface Config {
    db_type?: string;
    host?: string;
    db_port?: string;
    user?: string;
    password?: string;
    database?: string;
    port?: string;
    Ambiente?: string;
}
const config: Config = {
    db_type: process.env.DB_TYPE,
    host: process.env.DB_HOST,
    port: process.env.PORT,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB,
    db_port: process.env.DB_PORT,
    Ambiente: process.env.Ambiente
};

export default config;