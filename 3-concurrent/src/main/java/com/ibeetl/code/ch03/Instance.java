package com.ibeetl.code.ch03;

public class Instance {
  static Instance ins = null;
  private Instance(){}
  public static Instance instance(){
    if(ins==null){
      ins = new Instance();
      ins.init();
    }
    return ins;
  }

  private void init(){
    // Instance对象初始化
  }

}
