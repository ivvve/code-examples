import { MockSenderEndPoint } from './MockSenderEndPoint';
import { FollowStatus } from '../../src/twooter/FollowStatus';

describe('SenderEndpoint class', () => {
  describe('onFollow method', () => {
    it('유저를 팔로우한다', () => {
      // given
      const mockSenderEndPoint = new MockSenderEndPoint();

      // when
      let followStatus = mockSenderEndPoint.onFollow("OTHER_USER_ID");

      // then
      expect(followStatus).toEqual(FollowStatus.SUCCESS);

      // when
      followStatus = mockSenderEndPoint.onFollow("OTHER_USER_ID");

      // then
      expect(followStatus).toEqual(FollowStatus.ALREADY_FOLLOWING);
    });
  });
});
