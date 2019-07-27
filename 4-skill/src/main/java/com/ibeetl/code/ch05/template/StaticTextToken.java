package com.ibeetl.code.ch05.template;

import java.io.IOException;

public class StaticTextToken implements  Token {
  private String  text;
  public StaticTextToken(String text){
    this.text = text;
  }
  @Override
  public final void render(Context ctx) throws IOException {
    ctx.getWriter().append(text);
  }
}
