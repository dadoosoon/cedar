/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar;

/**
 *
 * @author shuwen.zsw
 * 基于表操作的sql生成器
 */
public abstract class TableCriteria extends Criteria {
  
  public TableCriteria() {
    super();
  }
  
  protected String table;
  
    /**
   * @return the table
   */
  public String getTable() {
    return table;
  }

  /**
   * @param table the table to set
   */
  public void setTable(String table) {
    this.table = table;
  }
}
