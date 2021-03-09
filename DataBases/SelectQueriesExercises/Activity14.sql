-- Activity 14

USE personalTrainer;

SELECT Name
FROM ExerciseCategory
WHERE ParentCategoryId Is Not NULL;