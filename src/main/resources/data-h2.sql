insert into USERS(id, email, password, name) values
(1, 'admin@prevengic.com', 'password', 'admin'),
(2, 'user1@prevengic.com', 'password', 'user1'),
(3, 'user2@prevengic.com', 'password', 'user3'),
(4, 'user3@prevengic.com', 'password', 'user4');

insert into CHEMICAL_PROFILES(id) values
(1),
(2),
(3),
(4),
(5),
(6),
(7);

insert into NOTES(id, code, description) values
(1, 'note-code1', 'note description 1'),
(2, 'note-code2', 'note description 2'),
(3, 'note-code3', 'note description 3'),
(4, 'note-code4', 'note description 4'),
(5, 'note-code5', 'note description 5'),
(6, 'note-code6', 'note description 6'),
(7, 'note-code7', 'note description 7');

insert into WARNING_ADVICES(id, code, description) values
(1, 'warning-code1', 'warning description 1'),
(2, 'warning-code2', 'warning description 2'),
(3, 'warning-code3', 'warning description 3'),
(4, 'warning-code4', 'warning description 4'),
(5, 'warning-code5', 'warning description 5'),
(6, 'warning-code6', 'warning description 6'),
(7, 'warning-code7', 'warning description 7');

insert into CHEMICAL_PROFILES_NOTES(CHEMICAL_PROFILE_ID, NOTES_ID ) values
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7);

insert into CHEMICAL_PROFILES_WARNING_ADVICES(CHEMICAL_PROFILE_ID, WARNING_ADVICES_ID ) values
(1, 1),
(1, 2),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7);

insert into COMPOUNDS(id, nce, cas, name, chemical_profile_id) values
(1, 'nce1', '149-57-5', 'Ácido 2-etilhexanoico', 1),
(2, 'nce2', '150-76-5', '4-Metoxifenol', 2),
(3, 'nce3', '151-50-8', 'Cianuro de potasio', 3),
(4, 'nce4', '151-56-4', 'Etilenimina', 4),
(5, 'nce5', '151-67-7', 'Halotano', 5),
(6, null , null, 'Partículas (insolubles o poco solubles) no especificadas de otra forma: Fracción inhalable', 6),
(7, null, null, 'Partículas (insolubles o poco solubles) no especificadas de otra forma: Fracción respirable', 7);