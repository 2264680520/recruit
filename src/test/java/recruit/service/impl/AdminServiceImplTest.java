package recruit.service.impl;


import com.recruit.entity.*;
import com.recruit.service.IAdminService;
import com.recruit.utils.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:容合
 * @create:2019-10-02 17:
 * @description:
 */
@Service
public class AdminServiceImplTest {
    String xmlPath = "spring-mybatis.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
    IAdminService bean = context.getBean(IAdminService.class);
    @Test
    public void getUserPage() {

        Page<User> page = bean.getUserPage(2);
        System.out.println(page.getList());
    }
    @Test
    public  void getUserById(){
        User user = bean.getUserById(2);
        System.out.println(user);
    }
    @Test
    public void getCompanyPage() {
        Page<Company> companyPage = bean.getCompanyPage(2);
        System.out.println(companyPage);
    }
    @Test
    public void updateCompanyByAdmin(){
        Company company = new Company();
        company.setId(1);
        company.setUsername("c5");
        company.setPassword("123456");
        company.setName("京东");
        company.setAddress("北京");
        company.setEmail("email");
        company.setPhone("11113333");
        company.setIntrodu("只卖真品的购物网站");
        System.out.println(company);
        Integer integer = bean.updateCompanyByAdmin(company);
        System.out.println(integer);
    }

    @Test
    public void  getPositionsPage(){
        Page<Positions> positionsPage = bean.getPositionsPage(1);
        System.out.println(positionsPage.getList());
    }
    @Test
    public void getPositionsById(){
        Positions positions = bean.getPositionsById(1);
        System.out.println(positions);
    }
    @Test
    public void  findPositionsWithCompany(){
        Page<Company> page = bean.getCompanyPage(1);
        System.out.println(page);
    }
    @Test
    public void  getPositionsWithCompanyPage(){
        Page<Comment> positionsWithCompanyPage = bean.getPositionsWithCompanyPage(1);
        System.out.println(positionsWithCompanyPage);
    }

    @Test
    public void  getCommentByPositionsId(){
       /* List<Comment> commentByPositionsId = bean.getCommentByPositionsId(2);
        System.out.println(commentByPositionsId);*/
    }

    @Test
    public void getCommentPage(){
        Page<Comment> commentPage = bean.getCommentPage(2, 1);
        System.out.println(commentPage);
    }
}
