/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar.order;

/**
 *
 * @author shuwen.zsw
 */
public final class Orders {
  
  private Orders() {}
  
  public static Order asc(String field) {
    return new Order(field, OrderMode.ASC);
  }
  
  public static Order desc(String field) {
    return new Order(field, OrderMode.DESC);
  }
}
