INSERT INTO public.hcm_countries(str_name, str_code, int_status, int_created_by, dat_created_date) VALUES ('Pakistan', 'PK', 1, 1, now());

INSERT INTO public.hcm_states(str_name, str_code, id_country, int_status, int_created_by, dat_created_date) VALUES ('Sindh', 'SH', 1, 1, 1, now());

INSERT INTO public.hcm_cities(str_code, str_name, id_state, int_status, int_created_by, dat_created_date) VALUES ('Karachi', 'Khi', 1, 1, 1, now());
