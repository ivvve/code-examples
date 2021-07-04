import { ReceiverEndPoint } from '../../src/twooter/ReceiverEndPoint';
import { Twoot } from '../../src/twooter/Twoot';

export class MockReceiverEndPoint implements ReceiverEndPoint {
  readonly receivedTwoots: Array<Twoot> = [];

  onTwoot(twoot: Twoot) {
    this.receivedTwoots.push(twoot);
  }
}
