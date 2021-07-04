import { MockReceiverEndPoint } from './MockReceiverEndPoint';
import { Twoot } from '../../src/twooter/Twoot';

describe('ReceiverEndPoint class', () => {
  describe('onTwoot method', () => {
    it('Twoot을 받는다', () => {
      // given
      const receiverEndPoint = new MockReceiverEndPoint();
      const twoot = new Twoot();

      // when
      receiverEndPoint.onTwoot(twoot);

      // then
      expect(receiverEndPoint.receivedTwoots).toContain(twoot);
    });
  });
});
