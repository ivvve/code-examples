// user/user.entity.ts

import { Entity, PrimaryGeneratedColumn, Column, BaseEntity } from "typeorm";

@Entity()
export class User extends BaseEntity {
  @PrimaryGeneratedColumn('increment')
  private id: number;

  @Column({ unique: true })
  private email: string;

  @Column()
  private name: string;
}