-- Activity 15

USE personalTrainer;

SELECT Name, Notes
FROM workout
WHERE LevelId = 3 AND notes LIKE '%you%';