/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package im.dadoo.cedar;

import im.dadoo.cedar.condition.Condition;
import im.dadoo.cedar.order.Order;
import im.dadoo.cedar.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 *
 * @author shuwen.zsw
 */
public class SelectCriteria extends TableCriteria {

  private final List<String> fields;
  private final List<Condition> conditions;
  private final List<Order> orders;
  private Pair<String, String> limits;
  
  
  public SelectCriteria() {
    super();
    this.fields = new ArrayList<>();
    this.conditions = new ArrayList<>(3);
    this.orders = new ArrayList<>(3);
    this.limits = null;
  }
  
  public SelectCriteria select() {
    this.fields.add("*");
    return this;
  }
  
  public SelectCriteria select(String ... fields) {
    Collections.addAll(this.fields, fields);
    return this;
  }
  
  public SelectCriteria select(List<String> fields) {
    this.fields.addAll(fields);
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
  
  public SelectCriteria addOrder(Order order) {
    if (order != null) {
      this.orders.add(order);
    }
    return this;
  }
  
  public SelectCriteria limit(String limit) {
    this.limits = ImmutablePair.of(Util.placeholder(limit), null);
    return this;
  }
  
  public SelectCriteria limit(String pagecount, String pagesize) {
    this.limits = ImmutablePair.of(Util.placeholder(pagecount), Util.placeholder(pagesize));
    return this;
  }
  
  @Override
  public String sql() {
    StringBuilder sb = new StringBuilder();
    sb.append("SELECT ");
    //字段名缺失无法构造sql
    if (this.fields == null || this.fields.isEmpty()) {
      return null;
    } else {
      int i = 0;
      for (; i < this.fields.size() - 1; i++) {
        sb.append(this.fields.get(i)).append(", ");
      }
      sb.append(this.fields.get(i)).append(" ");
      
      //表名缺失无法构造sql
      if (StringUtils.isBlank(this.table)) {
        return null;
      } else {
        sb.append("FROM ").append(this.table).append(" ");
        
        //增加筛选条件
        if (this.conditions != null && !this.conditions.isEmpty()) { 
          sb.append("WHERE ").append(this.makeConditionSql(this.conditions.get(0))).append(" ");
          if (this.conditions.size() > 1) {
            for (i = 1; i < this.conditions.size(); i++) {
              sb.append("AND ").append(this.makeConditionSql(this.conditions.get(i))).append(" ");
            }
          }
        }
        
        //增加排序条件
        if (this.orders != null && !this.orders.isEmpty()) {
          sb.append("ORDER BY ").append(this.makeOrderSql(this.orders.get(0))).append(" ");
          if (this.orders.size() > 1) {
            for (i = 1; i < this.orders.size(); i++) {
              sb.append(", ").append(this.makeOrderSql(this.orders.get(i))).append(" ");
            }
          }
        }
        //增加limit条件
        if (this.limits != null) {
          if (this.limits.getRight() == null) {
            sb.append("LIMIT ").append(this.limits.getLeft());
          } else {
            sb.append("LIMIT ").append(this.limits.getLeft())
                    .append(", ").append(this.limits.getRight());
          }
        }
      }
    }
    return sb.toString();
  }
  
  private String makeOrderSql(Order order) {
    StringBuilder sb = new StringBuilder();
    if (order != null && order.getField() != null && order.getMode() != null) {
      sb.append(order.getField()).append(" ").append(order.getMode().getWord());
    }
    return sb.toString();
  }
  
  private String makeConditionSql(Condition condition) {
    StringBuilder sb = new StringBuilder();
    if (condition != null && condition.getField() != null 
            && condition.getOp() != null && condition.getValue() != null) {
      switch(condition.getOp()) {
        case EQ:
        case GT:
        case LT:
          sb.append(condition.getField()).append(" ")
                  .append(condition.getOp().getWord()).append(" ")
                  .append(condition.getValue());
          break;
        case IN:
          String temp = null;
          //判断是否为子查询
          if (condition.getValue() instanceof String) {
            temp = (String)condition.getValue();
          } else if (condition.getValue() instanceof SelectCriteria) {
            temp = ((SelectCriteria)condition.getValue()).sql();
          }
          sb.append(condition.getField()).append(" ")
                    .append(condition.getOp().getWord()).append(" ")
                    .append("( ").append(temp).append(" )");
          break;
        case BETWEEN:
          Pair<String, String> pair = (Pair<String, String>)condition.getValue();
          sb.append(condition.getField()).append(" ")
                  .append(condition.getOp().getWord()).append(" ")
                  .append(pair.getLeft()).append(" ")
                  .append("AND").append(" ")
                  .append(pair.getRight());
          break;
      }
    }
    return sb.toString();
  }
}
