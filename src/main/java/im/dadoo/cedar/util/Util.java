/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar.util;

/**
 *
 * @author shuwen.zsw
 */
public final class Util {
  
  private Util(){}
  
  //转换成spring-jdbc中需要的参数占位符
  public static String placeholder(String value) {
    return ":" + value;
  }
}
