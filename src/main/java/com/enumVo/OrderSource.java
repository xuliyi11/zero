package com.enumVo;

/**
 * Created by xly on 2018/6/2.
 */
public enum OrderSource {
   waite_order(1);

   OrderSource(int orderSource) {
      this.orderSource = orderSource;
   }

   int orderSource;

   public int getOrderSource() {
      return orderSource;
   }

   public void setOrderSource(int orderSource) {
      this.orderSource = orderSource;
   }
}
