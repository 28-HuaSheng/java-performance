package com.ibeetl.code.ch05.reflect;

public class UserDirectAccessTool  implements ReflectTool{
  @Override
  public Object getValue(Object target, String attr) {
    return ((User)target).getName();
  }
}
