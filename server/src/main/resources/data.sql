INSERT INTO user (id, fullname, password, login) VALUES
  (1, 'Renato Serra', '$2a$10$/spowNku4SJqotOcJReZS.nCYJwYbtlC4IsLSR3SEPI7YobWL6bfq', 'serra'),
  (2, 'Admin user', '$2a$10$/spowNku4SJqotOcJReZS.nCYJwYbtlC4IsLSR3SEPI7YobWL6bfq', 'admin'); --password =12345

  insert INTO role (id, role, user_id) values
  (1,'ROLE_USER',1),
  (2,'ROLE_USER',2),
  (3,'ROLE_ADMIN',2);


