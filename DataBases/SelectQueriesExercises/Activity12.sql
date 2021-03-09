-- Activity 12

USE personalTrainer;

SELECT COUNT(EmailAddress)
FROM login
WHERE EmailAddress NOT LIKE '%gov';