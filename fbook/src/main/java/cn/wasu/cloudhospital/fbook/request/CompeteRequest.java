package cn.wasu.cloudhospital.fbook.request;

public class CompeteRequest {

  private long person_index_1;
  private long person_index_2;
  private int winner_index;// 1 or 2

  public long getPerson_index_1() {
    return person_index_1;
  }

  public void setPerson_index_1(long person_index_1) {
    this.person_index_1 = person_index_1;
  }

  public long getPerson_index_2() {
    return person_index_2;
  }

  public void setPerson_index_2(long person_index_2) {
    this.person_index_2 = person_index_2;
  }

  public int getWinner_index() {
    return winner_index;
  }

  public void setWinner_index(int winner_index) {
    this.winner_index = winner_index;
  }

}
