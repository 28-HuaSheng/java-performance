# Java 系统性能优化实战

如下代码，拼接字符串，能否找到5处性能优化点

```java
  public String buildProvince(List<Org> orgs){
      StringBuilder sb = new StringBuilder();
      for(Org org:orgs){
        if(sb.length()!=0){
          sb.append(",")
        }
        sb.append(org.getProvinceId());
      }
      return sb.toString();
    }
```

工程提供了9种性能优化的办法可以尝试看看能否找到所有优化办法
