
import im.dadoo.cedar.Criteria;
import im.dadoo.cedar.SelectCriteria;
import im.dadoo.cedar.condition.Conditions;
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
    SelectCriteria c = new SelectCriteria();
    c.select().from("t_tag").add(Conditions.eq("id"));
    System.out.println(c.sql());
  }
}
