package com.ibeetl.code.ch01.com.ibeetl.code.ch01.jmh;

import org.junit.Assert;
import org.junit.Test;

public class InLineTestJunit {
  @Test
  public void test(){
    Inline inline = new Inline();
    inline.init();
    int expectd = inline.x+inline.y;
    int ret = inline.add();
    int ret2 = inline.addInline();
    Assert.assertEquals(expectd,ret);
    Assert.assertEquals(expectd,ret2);
  }
}
