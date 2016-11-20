package cn.wasu.cloudhospital.fbook.util;

import java.util.Random;

public class LongRandom {

  public long nextlong(Random rng, long n) {
    long bits, val;
    do {
      bits = (rng.nextLong() << 1) >>> 1;
      val = bits % n;
    } while (bits - val + (n - 1) < 0L);
    return val;
  }

}
