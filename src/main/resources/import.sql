insert into public.categoria (id, nome) values (1, 'Alimentação');
insert into public.categoria (id, nome) values (2, 'Bebidas');


-- BEBIDAS
insert into public.produto (id, nome, preco, categoria_id) values (1, 'Coca-Cola', 5.00, 2);
insert into public.produto (id, nome, preco, categoria_id) values (2, 'Guaraná', 5.00, 2);
insert into public.produto (id, nome, preco, categoria_id) values (3, 'Fanta', 5.00, 2);
insert into public.produto (id, nome, preco, categoria_id) values (4, 'Sprite', 5.00, 2);

-- ALIMENTAÇÃO
insert into public.produto (id, nome, preco, categoria_id) values (5, 'Arroz', 5.00, 1);
insert into public.produto (id, nome, preco, categoria_id) values (6, 'Feijão', 5.00, 1);
insert into public.produto (id, nome, preco, categoria_id) values (7, 'Macarrão', 5.00, 1);
insert into public.produto (id, nome, preco, categoria_id) values (8, 'Carne', 5.00, 1);
insert into public.produto (id, nome, preco, categoria_id) values (9, 'Frango', 5.00, 1);
insert into public.produto (id, nome, preco, categoria_id) values (10, 'Peixe', 5.00, 1);