package com.ibeetl.code.ch05.template;

import java.io.IOException;
import java.io.Writer;

public class Context {
  Writer out;
  Object[] args;

  public Context(Writer out, Object[] args){
    this.out = out;
    this.args= args;
  }




  public Writer getWriter(){
    return this.out;
  }

  public Object[] getArgs() {
    return args;
  }

  public void setArgs(Object[] args) {
    this.args = args;
  }

}
