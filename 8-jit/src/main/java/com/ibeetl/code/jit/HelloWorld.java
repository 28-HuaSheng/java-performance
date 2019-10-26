package com.ibeetl.code.jit;

/**
 * -server -XX:+PrintCodeCache -XX:+PrintFlagsFinal -XX:+UnlockDiagnosticVMOptions -XX:+PrintCompilation -XX:+LogCompilation -XX:+PrintInlining
 */
public class HelloWorld {

  public static void main(String[] args) throws Exception{
    HelloWorld say = new HelloWorld();
    for(int i=0;i<1000000;i++){
      say.sayHello();

    }

  }
  public void sayHello(){
    String msg = getMessage();
    String output = "hello"+msg;
  }
  public synchronized  String getMessage() {
    return "world";
  }
}
