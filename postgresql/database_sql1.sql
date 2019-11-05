DROP TABLE IF EXISTS Food;
DROP TABLE IF EXISTS Ingredient;
DROP TABLE IF EXISTS FoodIngred;

-- Create the schema.
CREATE TABLE Food (
	ID integer PRIMARY KEY, 
	name varchar(50)
	);

CREATE TABLE Ingredient (
	ID integer PRIMARY KEY, 
	name varchar(50)
	);

CREATE TABLE FoodIngred (
	foodID integer REFERENCES Food(ID), 
	ingredientID integer REFERENCES Ingredient(ID),
	count integer
	);

-- Allow users to select data from the tables.
GRANT SELECT ON Food TO PUBLIC;
GRANT SELECT ON Ingredient TO PUBLIC;
GRANT SELECT ON FoodIngred TO PUBLIC;

-- Add sample records.
INSERT INTO Food VALUES (1, 'Burger');
INSERT INTO Food VALUES (2, 'Steak');
INSERT INTO Food VALUES (3, 'Pad_Thai');

INSERT INTO Ingredient VALUES (1, 'Beef');
INSERT INTO Ingredient VALUES (2, 'Ground beef');
INSERT INTO Ingredient VALUES (3, 'Tomato');
INSERT INTO Ingredient VALUES (4, 'Rice Noodle');
INSERT INTO Ingredient VALUES (5, 'Garlic');
INSERT INTO Ingredient VALUES (6, 'Lettuce ');
INSERT INTO Ingredient VALUES (7, 'Cheese');
INSERT INTO Ingredient VALUES (8, 'Butter');
INSERT INTO Ingredient VALUES (9, 'Burger Bun');
INSERT INTO Ingredient VALUES (10, 'Pickle');
INSERT INTO Ingredient VALUES (11, 'Onion');
INSERT INTO Ingredient VALUES (12, 'Mushroom');
INSERT INTO Ingredient VALUES (13, 'Pad_Thai sauce');


INSERT INTO FoodIngred VALUES (1, 2, 2);
INSERT INTO FoodIngred VALUES (1, 3, 1);
INSERT INTO FoodIngred VALUES (1, 6, 1);
INSERT INTO FoodIngred VALUES (1, 7, 2);
INSERT INTO FoodIngred VALUES (1, 8, 1);
INSERT INTO FoodIngred VALUES (1, 9, 2);
INSERT INTO FoodIngred VALUES (1, 10, 1);
INSERT INTO FoodIngred VALUES (1, 11, 1);

INSERT INTO FoodIngred VALUES (2, 1, 1);
INSERT INTO FoodIngred VALUES (2, 5, 1);
INSERT INTO FoodIngred VALUES (2, 11, 1);
INSERT INTO FoodIngred VALUES (2, 8, 1);

INSERT INTO FoodIngred VALUES (3, 1, 1);
INSERT INTO FoodIngred VALUES (3, 3, 1);
INSERT INTO FoodIngred VALUES (3, 5, 1);
INSERT INTO FoodIngred VALUES (3, 13, 1);
INSERT INTO FoodIngred VALUES (3, 4, 1);



SELECT Ingredient.name 
FROM Ingredient, Food, FoodIngred
WHERE Ingredient.ID = ingredientID
AND Food.ID = foodID
AND foodID = 1