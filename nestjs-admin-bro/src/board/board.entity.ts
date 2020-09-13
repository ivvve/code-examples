import { buildSchema, prop } from "@typegoose/typegoose";

export class Board {
  @prop()
  private title: string;

  @prop()
  private content: string;
}

export const BoardSchema = buildSchema(Board);
