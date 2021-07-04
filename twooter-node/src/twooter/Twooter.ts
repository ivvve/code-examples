import { SenderEndpoint } from './SenderEndpoint';
import { ReceiverEndPoint } from './ReceiverEndPoint';

export class Twooter {
  onLogon(userId: String, password: String, receiverEndPoint: ReceiverEndPoint): SenderEndpoint | null {
    throw Error('Not implemented');
  }
}
