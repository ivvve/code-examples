import AdminBro from 'admin-bro';
import * as AdminBroExpress from '@admin-bro/express';
import { Database, Resource} from '@admin-bro/typeorm';
import * as AdminBroMongoose from '@admin-bro/mongoose';

import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { User } from './user/user.entity';

async function runAdmin() {
  // Nest.js App 생성
  const app = await NestFactory.create(AppModule);

  // AdminBro Adapter 등록
  AdminBro.registerAdapter({ Database, Resource })
  AdminBro.registerAdapter(AdminBroMongoose);

  // Mongoose Model
  const boardModel = app.get('BoardModel');

  // AdminBro router 생성
  const adminBro = new AdminBro({
    resources: [
      { resource: User },
      { resource: boardModel }
    ],
    rootPath: '/admin'
  });
  const router = AdminBroExpress.buildRouter(adminBro);

  // Nest.js AdminBro 연결
  app.use(adminBro.options.rootPath, router);

  // App 실행
  await app.listen(3000);
  console.log('Nest.js AdminBro is running on 3000')
}

runAdmin();
