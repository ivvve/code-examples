import { Module } from "@nestjs/common";
import { MongooseModule } from "@nestjs/mongoose";
import { BoardSchema } from './board.entity';
import { mongoose } from "@typegoose/typegoose";

@Module({
  imports: [
    MongooseModule.forRoot('mongodb://127.0.0.1:8100/playground', {
      useCreateIndex: true,
      useNewUrlParser: true,
      useUnifiedTopology: true
    }),
    MongooseModule.forFeature([
      { name: 'Board', collection: 'boards', schema: BoardSchema }
    ])
  ],
  exports: [MongooseModule]
})
export class BoardModule {}

mongoose.set('debug', true);
