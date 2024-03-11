import java.util.ArrayList;
import java.util.Scanner;

class Question {
    private String questionText;
    private ArrayList<String> options;

    public Question(String questionText, ArrayList<String> options) {
        this.questionText = questionText;
        this.options = options;
    }

    public String getQuestionText() {
        return questionText;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}

class Response {
    private Question question;
    private String selectedOption;

    public Response(Question question, String selectedOption) {
        this.question = question;
        this.selectedOption = selectedOption;
    }

    public Question getQuestion() {
        return question;
    }

    public String getSelectedOption() {
        return selectedOption;
    }
}

class Survey {
    private ArrayList<Question> questions;
    private ArrayList<Response> responses;

    public Survey() {
        this.questions = new ArrayList<>();
        this.responses = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void recordResponse(Response response) {
        responses.add(response);
    }

    public ArrayList<Response> getResponses() {
        return responses;
    }
}

public class OnlineSurveySystem {
    public static void main(String[] args) {
        // Create a sample survey
        Survey survey = new Survey();
        ArrayList<String> options1 = new ArrayList<>();
        options1.add("Option A");
        options1.add("Option B");
        options1.add("Option C");
        Question question1 = new Question("What is your favorite color?", options1);

        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Yes");
        options2.add("No");
        Question question2 = new Question("Have you used Java before?", options2);

        survey.addQuestion(question1);
        survey.addQuestion(question2);

        // Simulate a user taking the survey
        Scanner scanner = new Scanner(System.in);

        for (Question question : survey.getQuestions()) {
            System.out.println(question.getQuestionText());

            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            System.out.print("Enter your choice (1-" + question.getOptions().size() + "): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String selectedOption = question.getOptions().get(choice - 1);
            Response response = new Response(question, selectedOption);
            survey.recordResponse(response);

            System.out.println(); // Add a newline for clarity
        }

        // Display survey responses
        System.out.println("Survey Responses:");
        for (Response response : survey.getResponses()) {
            System.out.println(response.getQuestion().getQuestionText() + ": " + response.getSelectedOption());
        }

        // Close the scanner
        scanner.close();
    }
}