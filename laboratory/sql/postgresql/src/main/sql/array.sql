SELECT array_agg(num) FROM (VALUES (array[1,2]), (array[3,4]), (array[5,6])) AS t (num);

SELECT array_cat(array[[1,2],[3,4]],array[[5,6],[7,8]]);

SELECT unnest(num) FROM (VALUES (array[[1,2],[3,4]]), (array[[5,6],[7,8]])) AS t (num);

select 1 = any(array[1,2,3]);

SELECT UNNEST(array['two', 'four', 'six'])
INTERSECT
SELECT UNNEST(array['four', 'six', 'eight']);

SELECT ARRAY(SELECT * FROM UNNEST(ARRAY[1, 4, 2]) WHERE UNNEST = ANY(ARRAY[2, 3]));
