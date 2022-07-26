package com.conurets.hcm.persistence.dao.impl;

import com.conurets.hcm.persistence.dao.StateDAO;
import com.conurets.hcm.persistence.entity.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class StateDAOImpl extends BaseDAOImpl<State> implements StateDAO {
}