SELECT array_agg(num) FROM (VALUES (array[1,2]), (array[3,4]), (array[5,6])) AS t (num);

SELECT array_cat(array[[1,2],[3,4]],array[[5,6],[7,8]]);

SELECT unnest(num) FROM (VALUES (array[[1,2],[3,4]]), (array[[5,6],[7,8]])) AS t (num);