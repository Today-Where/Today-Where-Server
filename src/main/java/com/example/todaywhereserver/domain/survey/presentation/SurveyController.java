package com.example.todaywhereserver.domain.survey.presentation;

import com.example.todaywhereserver.domain.survey.domain.Survey;
import com.example.todaywhereserver.domain.survey.presentation.dto.request.SurveyAnswerRequest;
import com.example.todaywhereserver.domain.survey.presentation.dto.response.SurveyDetailsResponse;
import com.example.todaywhereserver.domain.survey.service.SurveyAnswerService;
import com.example.todaywhereserver.domain.survey.service.SurveyDetailsService;
import com.example.todaywhereserver.domain.survey.service.SurveyListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/survey")
@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyListService surveyListService;
    private final SurveyDetailsService surveyDetailsService;
    private final SurveyAnswerService surveyAnswerService;

    @GetMapping
    public Iterable<Survey> surveyList() {
        return surveyListService.execute();
    }

    @GetMapping("/{id}")
    public SurveyDetailsResponse surveyDetails(@PathVariable("id") Long id) {
        return surveyDetailsService.execute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/answer")
    public List<String> surveyAnswer(@RequestBody @Valid SurveyAnswerRequest request){
        return surveyAnswerService.execute(request);
    }
}
