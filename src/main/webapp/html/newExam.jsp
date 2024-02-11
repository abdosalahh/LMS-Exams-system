<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/newExam.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Add New Exam</title>
</head>
<body>
    <div class="container">
        <h1>Add New Exam</h1>
        <form id="examForm" action="/examsystem/addexamSrvlt" method="post">
            <!-- Exam Details -->
            <label for="Tid">Teacher id:</label>
            <input type="number" id="Tid" name="Tid" required>
            
            <label for="examName">Exam Name:</label>
            <input type="text" id="examName" name="examName" required>
            
            <label for="examType">Exam Type:</label>
            <input type="text" id="examType" name="examType" required>
            
            <label for="StartTime">StartTime:</label>
            <input type="text" id="StartTime" name="StartTime" required>
            
            <label for="EndTime">EndTime:</label>
            <input type="text" id="EndTime" name="EndTime" required>
            
            <label for="totalGrade">Total Grade:</label>
            <input type="number" id="totalGrade" name="totalGrade" required>
            
            <label for="yearLevel">Year Level:</label>
            <input type="number" id="yearLevel" name="yearLevel" required>

            <!-- Questions -->
            <div id="questionsContainer">
                <div class="question">
                    <label for="question">Question:</label>
                    <input type="text" class="questionInput" name="questions[]" required>

                    <!-- Choices -->
                    <div class="choicesContainer">
                        <label for="choice1">Choice 1:</label>
                        <input type="text" class="choiceInput" name="choices[0][]" required>
                        <input type="radio" name="correct[0]" value="0">

                        <label for="choice2">Choice 2:</label>
                        <input type="text" class="choiceInput" name="choices[0][]" required>
                        <input type="radio" name="correct[0]" value="1">

                        <label for="choice3">Choice 3:</label>
                        <input type="text" class="choiceInput" name="choices[0][]" required>
                        <input type="radio" name="correct[0]" value="2"> 

                        <label for="choice4">Choice 4:</label>
                        <input type="text" class="choiceInput" name="choices[0][]" required>
                        <input type="radio" name="correct[0]" value="3">
                    </div>
                </div>
            </div>

            <!-- Add Question Button -->
            <button type="button" onclick="addQuestion()">Add Question</button>

            <!-- Submit Button -->
            <button type="submit">Save Exam</button>
        </form>
    </div>

    <script src="../js/newExam.js"></script>
</body>
</html>
