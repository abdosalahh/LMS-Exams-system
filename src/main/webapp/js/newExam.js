function addQuestion() {
    // Clone the first question and append it to the questions container
    var firstQuestion = document.querySelector('.question');
    var newQuestion = firstQuestion.cloneNode(true);
    document.getElementById('questionsContainer').appendChild(newQuestion);

    // Clear the inputs in the new question
    var inputs = newQuestion.querySelectorAll('input');
    inputs.forEach(function (input) {
        input.value = '';
    });

    // Uncheck radio buttons in the new question
    var radios = newQuestion.querySelectorAll('input[type="radio"]');
    radios.forEach(function (radio) {
        radio.checked = false;
    });
}

// You can add additional JavaScript for form validation or other dynamic behavior
