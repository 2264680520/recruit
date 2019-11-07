package recruit.service.impl;

import com.recruit.entity.Comment;
import com.recruit.entity.Positions;
import com.recruit.entity.User;
import com.recruit.service.ICompanyService;
import com.recruit.service.IUserService;
import com.recruit.utils.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:容合
 * @create:2019-10-09 17:
 * @description:
 */
public class UserServiceImplTest {
    String xmlPath = "spring-mybatis.xml";
    ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
    IUserService bean = context.getBean(IUserService.class);

    @Test
    public void getCommentPage() {
        Page<Comment> commentPage = bean.getCommentPage(2, 1);
        System.out.println(commentPage);
    }

    @Test
    public void searchPostPage() {
        Page<Positions> positionsPage = bean.searchPostPage("早", 1);
        System.out.println(positionsPage);
    }

    @Test
    public void findById(){
        User user = bean.findUser(2);
        System.out.println(user);
    }
}
