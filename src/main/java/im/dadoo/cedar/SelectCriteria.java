/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar;

import im.dadoo.cedar.condition.Condition;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author shuwen.zsw
 */
public class SelectCriteria extends Criteria {

  private List<String> fields;
  private List<Condition> conditions;
  //private List<Order> orders;
  
  public SelectCriteria() {
    this.fields = new ArrayList<>();
    this.conditions = new ArrayList<>(3);
  }
  
  public SelectCriteria select() {
    this.fields.add("*");
    return this;
  }
  
  public SelectCriteria from(String table) {
    this.table = table;
    return this;
  }
  
  public SelectCriteria add(Condition condition) {
    if (condition != null) {
      this.conditions.add(condition);
    }
    return this;
  }
  
  @Override
  public String sql() {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT ").append(this.fields.get(0)).append(" ");
    sb.append("FROM ").append(table).append(" ");
    if (this.conditions != null && !this.conditions.isEmpty()) { 
      sb.append("WHERE ").append(this.parseCondition(this.conditions.get(0))).append(" ");
      if (this.conditions.size() > 1) {
        for (int i = 1; i < this.conditions.size(); i++) {
          sb.append("AND ").append(this.parseCondition(this.conditions.get(i))).append(" ");
        }
      }
    }
    return sb.toString();
  }
  
  private String parseCondition(Condition condition) {
    if (condition != null) {
      StringBuilder sb = new StringBuilder();
      switch(condition.getOp()) {
        case EQ:
          sb.append(condition.getField()).append(" ")
                  .append(condition.getOp().getWord()).append(" ")
                  .append(condition.getValue());
          break;
        case BETWEEN:
          Pair<String, String> pair = (Pair<String, String>)condition.getValue();
          sb.append(condition.getField()).append(" ")
                  .append(condition.getOp().getWord()).append(" ")
                  .append(pair.getLeft()).append(" ")
                  .append("AND").append(" ")
                  .append(pair.getRight());
      }
      return sb.toString();
    } else {
      return null;
    }
  }
}
