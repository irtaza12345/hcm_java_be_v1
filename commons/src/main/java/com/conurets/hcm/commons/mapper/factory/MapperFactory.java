package com.conurets.hcm.commons.mapper.factory;

import com.conurets.hcm.commons.mapper.AttendanceMapper;
import com.conurets.hcm.commons.mapper.UserMapper;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Getter
@Component
public class MapperFactory {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private UserMapper userMapper;
}
