package study.zhx.community.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import study.zhx.community.community.model.User;

//通过MyBatis操作数据库
@Mapper
public interface UserMapper {
    // "#"的作用是把参数中类的变量对应的放入尖括弧中(如果参数不为类需加注解@Param)
    @Insert("insert into community.user (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("select * from community.user where token=#{token}")
    User findByToken(@Param("token") String token);
}
