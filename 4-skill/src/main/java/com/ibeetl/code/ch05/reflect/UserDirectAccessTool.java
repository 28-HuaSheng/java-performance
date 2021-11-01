package com.ibeetl.code.ch05.reflect;

/**
 * 一个简单实现例子
 * @author 公众号 闲谈Java开发
 */
public class UserDirectAccessTool  implements ReflectTool{
  @Override
  public Object getValue(Object target, String attr) {
    return ((User)target).getName();
  }
}
