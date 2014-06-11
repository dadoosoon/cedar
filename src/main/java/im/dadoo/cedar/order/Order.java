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
public class Order {
  
  private String field;
  private OrderMode mode;
  
  public Order() {
    this.field = null;
    this.mode = null;
  }
  
  public Order(String field, OrderMode mode) {
    this.field = field;
    this.mode = mode;
  }

  /**
   * @return the field
   */
  public String getField() {
    return field;
  }

  /**
   * @param field the field to set
   */
  public void setField(String field) {
    this.field = field;
  }

  /**
   * @return the mode
   */
  public OrderMode getMode() {
    return mode;
  }

  /**
   * @param mode the mode to set
   */
  public void setMode(OrderMode mode) {
    this.mode = mode;
  }
 
}
