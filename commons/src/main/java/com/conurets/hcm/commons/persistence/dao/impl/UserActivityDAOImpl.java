package com.conurets.hcm.commons.persistence.dao.impl;

import com.conurets.hcm.commons.persistence.dao.UserActivityDAO;
import com.conurets.hcm.commons.persistence.entity.UserActivity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class UserActivityDAOImpl extends BaseDAOImpl<UserActivity> implements UserActivityDAO {
}