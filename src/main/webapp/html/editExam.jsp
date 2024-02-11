<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/editExam.css">
    <link rel="stylesheet" href="../css/all.css">
    <link rel="icon" href="../img/icon.jpg">
    <title>Exam Details</title>
</head>
<body>

    <header>
        <h1>Exam Details</h1>
    </header>
    
    <div class="container">
        <label for="examIdInput">Enter Exam ID:</label>
        <input type="text" id="examIdInput">
        <button class="button" onclick="editExam()">Edit Exam</button>
        <button class="button" onclick="deleteExam()">Delete Exam</button>
    
        <form id="editExamForm" style="display: none;">
            <h2>Edit Exam</h2>
            <label for="examNameInput">Exam Name:</label>
            <input type="text" id="examNameInput">
    
            <h3>Edit Questions and Choices</h3>
            <div id="questionsContainer">
                <!-- Questions and choices will be dynamically added here -->
            </div>
    
            <button class="button" type="submit">Save Changes</button>
        </form>
    </div>
    
    <script>
        function editExam() {
            var examId = document.getElementById('examIdInput').value;
            if (!examId) {
                alert('Please enter an Exam ID.');
                return;
            }
    
            // Logic to fetch exam details, questions, and choices from the server/database based on examId
            // Populate the form fields with the fetched data
    
            // For demo purposes, let's assume there are 10 questions, each with four choices
            var questions = Array.from({ length: 10 }, (_, questionIndex) => ({
                question: `Question ${questionIndex + 1}`,
                choices: Array.from({ length: 4 }, (_, choiceIndex) => `Choice ${choiceIndex + 1}`)
            }));
    
            populateQuestions(questions);
            document.getElementById('editExamForm').style.display = 'block';
        }
    
        function populateQuestions(questions) {
            var container = document.getElementById('questionsContainer');
            container.innerHTML = '';
    
            questions.forEach(function (questionData, questionIndex) {
                var questionLabel = document.createElement('label');
                questionLabel.textContent = 'Question ' + (questionIndex + 1) + ':';
    
                var questionInput = document.createElement('input');
                questionInput.type = 'text';
                questionInput.value = questionData.question;
    
                container.appendChild(questionLabel);
                container.appendChild(questionInput);
    
                // Add input fields for choices
                for (var i = 0; i < 4; i++) {
                    var choiceLabel = document.createElement('label');
                    choiceLabel.textContent = 'Choice ' + (i + 1) + ':';
    
                    var choiceInput = document.createElement('input');
                    choiceInput.type = 'text';
                    choiceInput.value = questionData.choices[i];
    
                    container.appendChild(choiceLabel);
                    container.appendChild(choiceInput);
                }
            });
        }
    
        function deleteExam() {
            var examId = document.getElementById('examIdInput').value;
            if (!examId) {
                alert('Please enter an Exam ID.');
                return;
            }
    
            // Logic to delete the exam based on examId
            // You may want to show a confirmation dialog before deletion
            alert('Exam deleted successfully.');
            // Reload the page or update the UI as needed
        }
    </script>
    
    </body>
    </html>