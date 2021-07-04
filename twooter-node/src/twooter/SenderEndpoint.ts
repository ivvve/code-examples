import { ReceiverEndPoint } from './ReceiverEndPoint';

export interface SenderEndpoint {
  onLogon(userId: String, receiver: ReceiverEndPoint): SenderEndpoint | null;
}
