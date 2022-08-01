package com.conurets.hcm.commons.persistence.dao.impl;

import com.conurets.hcm.commons.persistence.dao.ErrorCodeDAO;
import com.conurets.hcm.commons.persistence.entity.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class ErrorCodeDAOImpl extends BaseDAOImpl<ErrorCode> implements ErrorCodeDAO {
}