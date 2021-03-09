-- Activity 13

USE personalTrainer;

SELECT FirstName, LastName
FROM client
WHERE BirthDate IS NULL;