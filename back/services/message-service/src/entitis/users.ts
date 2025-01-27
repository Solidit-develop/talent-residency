import { Column, Entity, JoinColumn, ManyToOne, OneToMany, OneToOne, PrimaryGeneratedColumn } from "typeorm";
// import { Address } from "./adrdess";
import { userTypes } from "./typesUsers";
import { Providers } from "./provedores";
import { Conversation } from "./conversation";
import { appointment } from "./appointment";

@Entity()
export class users {
    @PrimaryGeneratedColumn()
    id_user: number;

    @Column({ type: "varchar", length: 100 })
    name_user: string;

    @Column({ type: "varchar", length: 100 })
    lastname: string;

    @Column({ type: "varchar", length: 100 })
    email: string;

    @Column({ type: "varchar", length: 100 })
    password: string;

    @Column({ type: "varchar", length: 30 })
    age: String;

    @Column({ type: "varchar", length: 20 })
    phoneNumber: string;

    @ManyToOne(() => userTypes, usertypes => usertypes.id_userType)
    usertypes: userTypes;


    @OneToOne(() => Providers, provider => provider.user)
    provedor: Providers;

    @OneToMany(()=>appointment, appointment=>appointment.users)
    appointment:appointment[];

}