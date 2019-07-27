package com.ibeetl.code.ch05.template;

import java.io.IOException;

public class VarToken implements Token {
  int varIndex = 0;
  public VarToken(int varIndex){
    this.varIndex = varIndex;
  }
  @Override
  public final void render(Context ctx) throws IOException {
    Object obj = ctx.getArgs()[varIndex];
    ctx.getWriter().append(String.valueOf(obj));
  }
}
