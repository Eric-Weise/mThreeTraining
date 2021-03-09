-- Activity 8

USE personalTrainer;

SELECT FirstName, LastName, City
FROM client
WHERE City = 'Metairie' OR 'Kenner' OR 'Gretna';