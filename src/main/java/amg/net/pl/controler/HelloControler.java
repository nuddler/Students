package amg.net.pl.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloControler {
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "helloWorld";	
	}
}
