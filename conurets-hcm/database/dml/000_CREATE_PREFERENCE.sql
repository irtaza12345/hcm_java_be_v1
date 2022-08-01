INSERT INTO hcm_preferences(str_name, str_value, str_description, int_status, int_created_by, dat_created_date) VALUES ('conurets.hcm.jwt.secret', 'conurets-hcm', 'Jwt secret', 1, 1, now());
INSERT INTO hcm_preferences(str_name, str_value, str_description, int_status, int_created_by, dat_created_date) VALUES ('conurets.hcm.jwt.expiration', '84600', 'Jwt expire time', 1,1, now());
INSERT INTO hcm_preferences(str_name, str_value, str_description, int_status, int_created_by, dat_created_date) VALUES ('conurets.hcm.jwt.issuer', 'http://api.hcm.conurets.com', 'Jwt issuer', 1,1, now());
