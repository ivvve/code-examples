import { SenderEndpoint } from '../../src/twooter/SenderEndpoint';
import { FollowStatus } from '../../src/twooter/FollowStatus';

export class MockSenderEndPoint implements SenderEndpoint {
  onFollow(targetUserId: String): FollowStatus {
    throw Error('Not implemented');
  }
}
