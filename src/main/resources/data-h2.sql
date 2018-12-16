insert into USERS(id, email, name) values
(1, 'user1@user.com','User 1'),
(2, 'user2@user.com','User 2'),
(3, 'user3@user.com','User 3');

insert into CHEMICAL_PROFILES(id) values
(1),
(2),
(3),
(4),
(5);

insert into NOTES(id, code, description) values
(1, 'note-code1', 'note description 1'),
(2, 'note-code2', 'note description 2'),
(3, 'note-code3', 'note description 3'),
(4, 'note-code4', 'note description 4'),
(5, 'note-code5', 'note description 5');

insert into WARNING_ADVICES(id, code, description) values
(1, 'warning-code1', 'warning description 1'),
(2, 'warning-code2', 'warning description 2'),
(3, 'warning-code3', 'warning description 3'),
(4, 'warning-code4', 'warning description 4'),
(5, 'warning-code5', 'warning description 5');

insert into CHEMICAL_PROFILES_NOTES(CHEMICAL_PROFILE_ID, NOTES_ID ) values
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

insert into CHEMICAL_PROFILES_WARNING_ADVICES(CHEMICAL_PROFILE_ID, WARNING_ADVICES_ID ) values
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

insert into COMPOUNDS(id, nce, cas, name, chemical_profile_id) values
(1, 'nce1', '149-57-5', 'Ácido 2-etilhexanoico', 1),
(2, 'nce2', '150-76-5', '4-Metoxifenol', 2),
(3, 'nce3', '151-50-8', 'Cianuro de potasio', 3),
(4, 'nce4', '151-56-4', 'Etilenimina', 4),
(5, 'nce5', '151-67-7', 'Halotano', 5);
