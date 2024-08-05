package com.example.QuizProject.Controller;

import com.example.QuizProject.Model.Question;
import com.example.QuizProject.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionservice;
    @GetMapping("allquestions")
    public ResponseEntity<List<Question>>  getAllQuestion(){
        return questionservice.getAllQuestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category){
        return questionservice.getByCategory(category);
    }
    @PostMapping("Questions")
    public ResponseEntity<String> postAQuestion(@RequestBody Question q){
        return questionservice.postAQuestion(q);
    }
}
