INSERT INTO public.hcm_users(id_organization, id_department, str_first_name, str_last_name, str_designation, str_email_address, str_mobile_number, id_country, id_state, id_city, int_status, int_created_by, dat_created_date) VALUES (1, 1, 'Super', 'Admin', 'Administrator', 'superadmin@conurets.com', '123', 1, 1, 1, 1, 1, now());

INSERT INTO public.hcm_user_logins(id_user, str_credential, int_status, int_created_by, dat_created_date) VALUES (1, '$2a$12$NoHNSv2KUw3Y8K//QN8mXO51J1/YrsHoUCHlg1j5mXnKYvxkv6C7a', 1, 1, now());
