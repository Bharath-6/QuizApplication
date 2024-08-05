package com.example.QuizProject.Service;

import com.example.QuizProject.Dao.QuestionDao;
import com.example.QuizProject.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questiondao;
    public ResponseEntity<List<Question>> getAllQuestion() {
        try{
            return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity< List<Question>> getByCategory(String s) {
        try{
            return new ResponseEntity<>(questiondao.findByCategory(s),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> postAQuestion(Question q) {
        questiondao.save(q);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}
