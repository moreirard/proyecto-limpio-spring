package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MiControlador {
	@RequestMapping(path = "/saludar", method = RequestMethod.GET)
	public ModelAndView saludar() {
		return new ModelAndView("saludar");

	}
	@RequestMapping(path = "/saludarConDato", method = RequestMethod.GET)
	public ModelAndView saludarConDato() {
		ModelMap mapa=new ModelMap();
		mapa.put("nombre","Sebastián");
		
		return new ModelAndView("saludar",mapa);

	}

}
