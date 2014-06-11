/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar.condition;

/**
 *
 * @author shuwen.zsw
 */
public class Condition {
  
  protected String field;
  protected Operation op;
  protected Object value;

  public Condition() {
    this.field = null;
    this.op = null;
    this.value = null;
  }
  
  public Condition(String field, Operation op, Object value) {
    this.field = field;
    this.op = op;
    this.value = value;
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
   * @return the op
   */
  public Operation getOp() {
    return op;
  }

  /**
   * @param op the op to set
   */
  public void setOp(Operation op) {
    this.op = op;
  }

  /**
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(Object value) {
    this.value = value;
  }
}
