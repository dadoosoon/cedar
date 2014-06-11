/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar.condition;

import org.apache.commons.lang3.tuple.ImmutablePair;

/**
 *
 * @author shuwen.zsw
 */
public final class Conditions {
  
  private Conditions() {}
  
  public static Condition eq(String field, String value) {
    return new Condition(field, Operation.EQ, value);
  }
  
  public static Condition eq(String field) {
    return Conditions.eq(field, ":" + field);
  }
  
  public static Condition gt(String field, String value) {
    return new Condition(field, Operation.GT, value);
  }
  
  public static Condition gt(String field) {
    return Conditions.gt(field, ":" + field);
  }
  
  public static Condition between(String field, String begin, String end) {
    return new Condition(field, Operation.BETWEEN, ImmutablePair.of(begin, end));
  }
}
