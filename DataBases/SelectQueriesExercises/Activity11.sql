-- Activity 11

USE personalTrainer;

SELECT COUNT(EmailAddress)
FROM login
WHERE EmailAddress LIKE '%gov';