import { Twooter } from '../../src/twooter/Twooter';
import { MockReceiverEndPoint } from './MockReceiverEndPoint';

describe('Twooter class', () => {
  describe('onLogon method', () => {
    it('유저가 로그온을 실패한다', () => {
      // given
      const twooter = new Twooter();
      const receiverEndPoint = new MockReceiverEndPoint();

      // when
      const senderEndPoint = twooter.onLogon("user", "password", receiverEndPoint);

      // then
      expect(senderEndPoint).toBeNull();
    });
  });
});
