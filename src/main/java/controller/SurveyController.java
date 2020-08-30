package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import survey.AnsweredData;
import survey.Question;
import survey.Respondent;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@GetMapping
	public ModelAndView form(Model model) {
		List<Question> questions = createQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions); //넘겨줄 값 설정
		mav.setViewName("survey/surveyForm"); //결과를 보여줄 뷰 이름 설정
		return mav;
	}
	
	private List<Question> createQuestions(){
		Question q1 = new Question("강아지 이름은 무엇입니까?");
		Question q2 = new Question("강아지 나이는 어떻게 되나요?", Arrays.asList("3개월 미만", "5개월 미만", "1살 미만", "1살 이상", "5살 이상"));
		Question q3 = new Question("강아지 몸무게는 어떻게 되나요?");
		
		return Arrays.asList(q1, q2, q3);
	}
	
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData data, Model model) {
		List<String> responses = data.getResponses();
		if(responses != null) {
			model.addAttribute("amount", Respondent.calculator(Float.parseFloat(responses.get(2)), responses.get(1)));
		}
		return "survey/submitted";
	}
}
