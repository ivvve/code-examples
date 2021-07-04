import { FollowStatus } from './FollowStatus';

export interface SenderEndpoint {
  /**
   * 다른 유저를 Follow 할 때 사용되는 메서드
   * @param targetUserId Follow 하고자하는 유저의 ID
   * @return FollowStatus Follow 결과
   */
  onFollow(targetUserId: String): FollowStatus;
}
