import { Twoot } from './Twoot';

export interface ReceiverEndPoint {
  /**
   * Follow 하는 유저가 Twoot 될 때 사용되는 메서드
   * @param twoot
   */
  onTwoot(twoot: Twoot);
}
