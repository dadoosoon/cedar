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
public enum Operation {
  
  EQ("="),GT(">"),LT("<"),BETWEEN("BETWEEN"),LIKE("LIKE");
  
  private final String word;
  
  private Operation(String word) {
    this.word = word;
  }

  public String getWord() {
    return this.word;
  }
}
