package com.conurets.hcm.commons.persistence.dao.impl;

import com.conurets.hcm.commons.persistence.dao.CountryDAO;
import com.conurets.hcm.commons.persistence.entity.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Repository
public class CountryDAOImpl extends BaseDAOImpl<Country> implements CountryDAO {
}