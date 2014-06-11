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
public enum OrderMode {
  
  ASC("ASC"), DESC("DESC");
  
  private final String word;
  
  private OrderMode(String word) {
    this.word = word;
  }

  public String getWord() {
    return this.word;
  }

}
