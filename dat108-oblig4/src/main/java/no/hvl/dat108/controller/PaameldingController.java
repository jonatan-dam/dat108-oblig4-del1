package no.hvl.dat108.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import no.hvl.dat108.model.Deltager;
import no.hvl.dat108.model.Deltagere;

@Controller
public class PaameldingController {

	
	@GetMapping("/paamelding")
	public String paamelding() {
		return "paamelding_med_melding";
	}
	
	@GetMapping("/deltagerliste")
	public String deltagerliste(Model model) {
		
		// Legger inn sortering på fornavn først, etterfølgt av sortering på etternavn
		Comparator<Deltager> comp = Comparator
				.comparing(Deltager::getFornavn)
				.thenComparing(Deltager::getEtternavn);
		
		List<Deltager> sortertDeltagere = Deltagere.alleDeltagere.stream()
				.sorted(comp)
				.toList();
		
		model.addAttribute("deltagere", sortertDeltagere);
		
		return "deltagerliste";
	}
	
	@GetMapping("/kvittering")
	public String kvittering() {
		return "paameldt";
	}
	
	@PostMapping("/sjekkDeltager")
	public String sjekkDeltager(@Valid @ModelAttribute("deltager") Deltager deltager, BindingResult bindingResult, HttpSession session) {
		
		if(bindingResult.hasErrors()) {
			List<String> feilmeldinger = bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage())
					.toList();
			
			session.setAttribute("SAfeilmeldinger", feilmeldinger);
			return "redirect:paamelding";
		}
		
		Deltagere.alleDeltagere.add(deltager);
		session.setAttribute("SAdeltager", deltager);
		
		return "redirect:kvittering";
	}
}
