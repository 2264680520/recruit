package recruit.service.impl;

import com.recruit.entity.Company;
import com.recruit.entity.Employ;
import com.recruit.entity.Positions;
import com.recruit.service.IAdminService;
import com.recruit.service.ICompanyService;
import com.recruit.utils.Page;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.aspectj.weaver.ast.Var;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:容合
 * @create:2019-10-07 15:
 * @description:
 */
public class CompanyServiceImplTest {
    String xmlPath = "spring-mybatis.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
    ICompanyService bean = context.getBean(ICompanyService.class);

    @Test
    public void getPositionsPage() {

        Page<Positions> positionsPage = bean.getPositionsPage(3, 1);
        System.out.println(positionsPage);
    }

    @Test
    public void getPositionsById() {
        Positions positions = bean.getPositionsById(10);
        System.out.println(positions);
    }

    @Test
    public void updatePositionsByCompany() {
        Positions positions = new Positions();
        positions.setId(4);
        positions.setStauts(0);
        positions.setPost("豪爽");
        positions.setSalary("1000");
        positions.setPuttime("2016-10-21");
        positions.setRequire("团结友爱");

        Integer integer = bean.updatePositionsByCompany(positions);
        System.out.println(integer);
    }

    @Test
    public void getCommentPage() {
        Page<Employ> employPage = bean.getEmployPage(1, 1);
        System.out.println(employPage);
    }

    @Test
    public void updateEmployByCompany() {
        Integer integer = bean.updateEmployByCompany(1, 2);
        System.out.println(integer);
    }

    @Test
    public void companyLogin() {
        Company company1 = new Company("c1", "123456");
        Company company = bean.companyLogin(company1);
        System.out.println(company);
    }
}
