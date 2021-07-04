import { defaults } from 'jest-config';

module.exports = {
  ...defaults,
  testMatch: [
    '<rootDir>/test/**/*ts'
  ],
  transform: {
    '^.+\\.ts?$': 'ts-jest'
  },
};
