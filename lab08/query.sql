--SELECT * FROM Game ORDER BY time DESC;
--SELECT * FROM Game WHERE time >= date_trunc('week', CURRENT_TIMESTAMP - interval '1 week');
--SELECT name FROM Player WHERE name IS NOT NULL;
--SELECT ID FROM Player, PlayerGame WHERE score > 2000;
--SELECT name FROM Player WHERE emailAddress LIKE '%gmail%';

SELECT name, Score from Player, PlayerGame WHERE name LIKE '%The King%' ORDER BY Score DESC; 
SELECT name, score
	FROM Player, PlayerGame, Game
	WHERE Player.ID = PlayerGame.playerID
	AND Game.ID = PlayerGame.gameID
	AND time = '2006-06-28 13:20:00'
	ORDER BY score DESC LIMIT 1;

	--Answer for 8.2-c: It choses the specific ID releated to a specific game, and not one that is unrelated
	--Answer for 8.2-d: Comparing data in a company table would be helped by joining the table with itself, with different data. 