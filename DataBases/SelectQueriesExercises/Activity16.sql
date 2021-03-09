-- Activity 16

USE personalTrainer;

SELECT FirstName, LastName, City
FROM Client
WHERE LastName LIKE 'L%' 
    OR LastName LIKE 'M%' 
    OR LastName LIKE 'N%'
	AND Client.Address = 'LaPlace';