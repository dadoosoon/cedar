
import im.dadoo.cedar.SelectCriteria;
import im.dadoo.cedar.condition.Conditions;
import im.dadoo.cedar.order.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shuwen.zsw
 */
@RunWith(JUnit4.class)
public class SelectCriteriaTest {
  
  @Test
  public void print() {
    SelectCriteria sub = new SelectCriteria();
    sub.select("id").from("t_user").limit("limit");
    SelectCriteria c = new SelectCriteria();
    c.select("id","name").from("t_tag")
            .add(Conditions.between("name", "a", "b"))
            .add(Conditions.in("id", sub))
            .addOrder(Orders.desc("id"))
            .limit("pagecount", "pagesize");
    System.out.println(c.sql());
  }
}
