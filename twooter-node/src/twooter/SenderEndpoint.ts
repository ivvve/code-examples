import { ReceiverEndPoint } from './ReceiverEndPoint';
import { FollowStatus } from './FollowStatus';

export interface SenderEndpoint {
  onFollow(targetUserId: String): FollowStatus;
}
