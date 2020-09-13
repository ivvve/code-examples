// user/user.module.ts

import { Module } from '@nestjs/common';
import { TypeOrmModule } from '@nestjs/typeorm';
import { User } from './user.entity';

@Module({
  imports: [
    TypeOrmModule.forRoot({
      type: 'mysql',
      host: 'localhost',
      port: 8200,
      username: 'root',
      password: 'root',
      database: 'playground',
      entities: [User],
      synchronize: true,
      logging: true
    })
  ],
  controllers: [],
  providers: [],
})
export class UserModule {}