
-- use client_db;
insert into clients(id_cl,Nom, Prenom, Email, Telephone) value (4,'TomCat', 'Apache', 'toto@hotmail.com', 0713214569);
insert into operations(id_op, Libelle) value (4, "achat produit 1");
insert into ligneOperations(id_lp, id_operation, id_client, statut, assignation) value (4,4, 4, "en cours", "paye");
