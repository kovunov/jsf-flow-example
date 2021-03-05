package com.kovunov;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Named("trivia")
@SessionScoped
public class TriviaBean implements Serializable {

    private long correctAnswersCount = 0;

    public long getCorrectAnswersCount() {
        //1: you fill the form to add the game on the page
        //2: you press add game and call GameBean addGame method
        //3: Game Bean creates a Game object using data from the page
        //4: Game is added to the games list through GameManagementService
        return correctAnswersCount;
    }

    @Inject
    private QuestionService questionService;

    private String question1;

    private String question2;

    private String question3;

    private String question4;

    private String question5;

    private String question6;


    public String submitAnswers() {
        //creates stream from the answers
        Stream<String> submittedAnswers = Stream.of(question1, question2,
                question3, question4, question5, question6);

        //encode answers to Base64
        correctAnswersCount = submittedAnswers.map(a ->
                Base64.getEncoder().encodeToString(a.getBytes(StandardCharsets.UTF_8)))
                //filters incorrect answers
                .filter(a -> questionService.getResults().contains(a))
                //calculates numbers of correct ones
                .count();
        //forwards you to the page with name - results
        return "results";
    }


    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public void setQuestion5(String question5) {
        this.question5 = question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public void setQuestion6(String question6) {
        this.question6 = question6;
    }

    public void tip() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Question 6", "One of them is Ecuador"));
    }
}

