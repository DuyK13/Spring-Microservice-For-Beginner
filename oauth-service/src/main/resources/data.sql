INSERT INTO oauth_client_details (client_id, client_secret, web_server_redirect_uri, scope, access_token_validity, refresh_token_validity, resource_ids, authorized_grant_types, additional_information) VALUES ('web', '{bcrypt}$2a$10$nu1iAvc4BmU5S5dSPtVIiOQNfbOX.ggnEotbMONc2cmPKsON3loD.', 'http://localhost:8080/login', 'READ,WRITE', '3600', '10000', 'user-service,order-service', 'authorization_code,password,refresh_token,implicit', '{}');

INSERT INTO user VALUES (1, "{bcrypt}$2a$10$nG0D5YvqgUtGQVKvhOea.Oh5H2uxiIPli5ftmQSonfFzaO4Djco7C", "trantheduyk13@gmail.com");

INSERT INTO role VALUES (1, "ROLE_CUSTOMER"), (2, "ROLE_ADMIN");

INSERT INTO user_role VALUES (1, 1);