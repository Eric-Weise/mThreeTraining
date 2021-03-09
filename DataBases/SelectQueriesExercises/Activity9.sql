-- Activity 9

USE personalTrainer;

SELECT FirstName, LastName, BirthDate
FROM client
WHERE BirthDate BETWEEN '1980-01-01' AND '1989-12-31';