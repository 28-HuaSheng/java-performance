package com.ibeetl.code.javadoc;

import java.math.BigDecimal;

/**
 *  价格调用接口
 */
public interface IPriceService {
  /**
   *  查询商品价格
   * @param code 商品代码
   * @return  商品价格
   */
  BigDecimal queryPrice(String code);
}
