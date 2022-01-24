CREATE OR REPLACE FUNCTION GET_TOP_FOUR_TITLES_BY_CATEGORY() RETURNS
 TABLE(id_title bigint,
	name VARCHAR(255), 
	date_register DATE, 
	second_name VARCHAR(255), 
	date_change DATE, 
	genre VARCHAR(255), 
	category VARCHAR(255),		
	poster VARCHAR(255), 
	description VARCHAR(255)) AS $$
 BEGIN
	RETURN QUERY
		(SELECT T2.id_title,
				T2.name , 
				T2.date_register, 
				T2.second_name, 
				T2.date_change, 
				T2.genre, 
				T2.category,		
				T2.poster, 
				T2.description
			FROM TITLE AS T2
			WHERE T2.CATEGORY LIKE 'SERIE'
			ORDER BY T2.DATE_REGISTER DESC
			LIMIT 4 )
UNION ALL
		(SELECT T3.id_title,
				T3.name , 
				T3.date_register, 
				T3.second_name, 
				T3.date_change, 
				T3.genre, 
				T3.category,		
				T3.poster, 
				T3.description
			FROM TITLE AS T3
			WHERE T3.CATEGORY LIKE 'MOVIE'
			ORDER BY T3.DATE_REGISTER DESC
			LIMIT 4 )
UNION ALL
		(SELECT T4.id_title,
				T4.name , 
				T4.date_register, 
				T4.second_name, 
				T4.date_change, 
				T4.genre, 
				T4.category,		
				T4.poster, 
				T4.description
			FROM TITLE AS T4
			WHERE T4.CATEGORY LIKE 'ANIME'
			ORDER BY T4.DATE_REGISTER DESC
			LIMIT 4) ORDER BY category;
END;
$$ LANGUAGE PLPGSQL ;