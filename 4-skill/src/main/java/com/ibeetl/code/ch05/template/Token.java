package com.ibeetl.code.ch05.template;

import java.io.IOException;

public interface Token {
  public void render(Context ctx) throws IOException;
}
