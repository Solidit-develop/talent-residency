import path from "path";
import { DataSource } from "typeorm";
import { Town } from "./entitis/town";
import { State } from "./entitis/state";
import { Address } from "./entitis/adrdess";
import { users } from "./entitis/users";
import { userTypes } from "./entitis/typesUsers";
import config from "./config";


const DB_TYPE= config.db_type;
const host = config.host;
const port = config.port;
const user = config.user;
const password = config.password;
const database = config.database;

console.log("Variables DB: host " +host);
console.log("Variables DB: port " +port);
console.log("Variables DB: user " +user);
console.log("Variables DB: password " +password);

export const AppDataSource = new DataSource({
    type: 'postgres',
    host: host,
    port: parseInt(port!),
    username: user,
    password: password,
    database: database,
    entities:[State,Town,Address,users,userTypes],
    // logging:true,
    logging: ["error", "schema"],
    synchronize:false 
})
