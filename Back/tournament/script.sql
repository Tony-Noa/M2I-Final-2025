CREATE DATABASE tournament_stn;
DROP DATABASE tournament_stn;
USE tournament_stn;
SELECT * FROM tourney;
SELECT * FROM useraccount;
SELECT * FROM gamecategory;
ALTER TABLE gamecategory RENAME COLUMN game_id to game_category_id;
ALTER TABLE tourney DROP COLUMN founder_id;