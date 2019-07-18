package com.ibeetl.code.ch05.template;

import java.io.IOException;
import java.io.Writer;

public class EmptyWriter extends Writer {

  public void write(String str, int off, int len){

  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {

  }

  @Override
  public void flush() throws IOException {

  }

  @Override
  public void close() throws IOException {

  }
}
