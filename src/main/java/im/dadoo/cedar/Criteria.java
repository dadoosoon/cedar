/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar;

/**
 *
 * @author shuwen.zsw
 */
public abstract class Criteria {
  
  protected String table;
  
  public abstract String sql();
}
