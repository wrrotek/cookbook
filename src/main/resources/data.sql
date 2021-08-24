-- CREATE TABLE category ()
-- CREATE TABLE recipe(title varchar (255), ingredients  varchar (255), description varchar (255), likes varchar (255));

INSERT INTO category(id, name)
VALUES (1, 'słodkie ciasta'),
       (2, 'pyry');

INSERT INTO recipe(id, title, category_id, ingredients, description, likes)
VALUE (1, 'Naleśniki', 1, 'mąka, jajka, mleko, sól i cukier',
        'Mieszamy na jednolitą masę i smażymy na patelni.',
        2);

INSERT INTO recipe(id, title, category_id, ingredients, description, likes)
VALUE (2, 'Naleśniki bananowe', 1, 'mąka, jajka, mleko, banan, sól i cukier',
        'Mieszamy na jednolitą masę, dodajemy rozdrobnionego banana i smażymy na patelni.',
        2);

INSERT INTO recipe(id, title, category_id, ingredients, description, likes)
VALUE (3, 'Ziemniaki z kefirem', 2, 'ziemniaki, kefir, koperek i sól',
        'Zimniacki myjemy i gotujemy, podajemy z koperkiem i kefirkiem.',
        4);