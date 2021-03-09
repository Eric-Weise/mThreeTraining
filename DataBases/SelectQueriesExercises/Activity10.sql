-- Activity 10

USE personalTrainer;

SELECT FirstName, LastName, BirthDate
FROM client
WHERE BirthDate > '1980-01-01' AND BirthDate < '1989-12-31';