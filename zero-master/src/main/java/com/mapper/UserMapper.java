package com.mapper;

import com.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenyuan on 2018-04-15.
 */
public interface UserMapper {

    List<User> selectAll(@Param("id") int name );

}
