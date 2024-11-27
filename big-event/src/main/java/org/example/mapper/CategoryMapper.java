package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category (category_name,category_alias,create_user,create_time,update_time)"
    + "values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    public void add(Category category);


    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);

    @Select("select * from category where id=#{id}")
    Category findById(Integer id);
}