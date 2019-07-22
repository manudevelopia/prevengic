insert into USERS(id, email, password, name) values
(1, 'admin@prevengic.com', 'password', 'admin'),
(2, 'user1@prevengic.com', 'password', 'user1'),
(3, 'user2@prevengic.com', 'password', 'user3'),
(4, 'user3@prevengic.com', 'password', 'user4');

insert into CHEMICAL_PROFILES(id, vla_Ed_Ppm, vla_Ed_Mgm, vla_Ec_Ppm, vla_Ec_Mgm) values
(991, null, null, 25, 46),
(992, null, null,null, null),
(993, null, null,null, null),
(994, null, null,null, null),
(995, null, null,null, null),
(996, null, null,null, null),
(997, null, null,null, null);

insert into NOTES(id, code, description) values
(991, 'note-code1', 'note description 1'),
(992, 'note-code2', 'note description 2'),
(993, 'note-code3', 'note description 3'),
(994, 'note-code4', 'note description 4'),
(995, 'note-code5', 'note description 5'),
(996, 'note-code6', 'note description 6'),
(997, 'note-code7', 'note description 7');

insert into WARNING_ADVICES(id, code, description) values
(991, '224', 'Líquido y vapores extremadamenteinflamables'),
(992, '351', 'Se sospecha que provoca cáncer'),
(993, '319', 'Provoca irritación ocular grave'),
(994, '335', 'Puede irritar las vías respiratorias'),
(995, 'warning-code5', 'warning description 5'),
(996, 'warning-code6', 'warning description 6'),
(997, 'warning-code7', 'warning description 7');

insert into CHEMICAL_PROFILES_NOTES(CHEMICAL_PROFILE_ID, NOTES_ID ) values
(992, 991),
(992, 992),
(993, 993),
(994, 994),
(995, 995),
(996, 996),
(997, 997);

insert into CHEMICAL_PROFILES_WARNING_ADVICES(CHEMICAL_PROFILE_ID, WARNING_ADVICES_ID ) values
(991, 991),
(991, 992),
(991, 993),
(991, 994),
(992, 992),
(993, 993),
(994, 994),
(995, 995),
(996, 996),
(997, 997);

insert into COMPOUNDS(id, nce, ncas, name, chemical_profile_id) values
(991, '200-836-8', '75-07-0', 'Acetaldehído', 991),
(992, 'nce2', '150-76-5', '4-Metoxifenol', 992),
(993, 'nce3', '151-50-8', 'Cianuro de potasio', 993),
(994, 'nce4', '151-56-4', 'Etilenimina', 994),
(995, 'nce5', '151-67-7', 'Halotano', 995),
(996, null , null, 'Partículas (insolubles o poco solubles) no especificadas de otra forma: Fracción inhalable', 996),
(997, null, null, 'Partículas (insolubles o poco solubles) no especificadas de otra forma: Fracción respirable', 997);