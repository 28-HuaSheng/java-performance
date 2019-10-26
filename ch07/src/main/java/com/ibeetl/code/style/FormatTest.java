package com.ibeetl.code.style;

public class FormatTest {
  private Integer id;
  private String name;
  private String description;
  private Integer age;

  public void genSql(){
    StringBuilder sb =  new StringBuilder();
    sb.append("select u.name,u.id,u.type,d.name,d.type orgType  " +
      "from user u left join department d on u.orgId=d.id  " +
      "where id=?");
  }


  @Override
  public String toString() {
    return "FormatTest{" + "id=" + id + ",name='" + name + '\'' + ", " +
      "description='" + description + '\'' + ", age=" + age  + '}';
  }
}
