package com.ibeetl.code.ch06;

import com.ibeetl.code.ch06.model.Department;
import com.ibeetl.code.ch06.model.User;
import fr.xebia.extras.selma.Mapper;

@Mapper(withCustom = UserCustomMapper.class)
public interface DepartmentMapper {

  Department clone(Department source);

}
class UserCustomMapper{
  public UserCustomMapper(){}
  public User toUser(User source){
    User target = new User();
    target.setId(source.getId());
    target.setAge(source.getAge());
    return target;
  }
}


