FROM node:16-alpine

WORKDIR /usr/src/app
# directory 내의 파일들이 container 바깥에 있기 때문에 내부로 옮겨야한다
COPY package.json ./
RUN npm install
COPY ./ ./

CMD ["npm", "start"]