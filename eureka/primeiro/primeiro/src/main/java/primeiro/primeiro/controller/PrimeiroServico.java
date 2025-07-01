package primeiro.primeiro.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/employee")
public class PrimeiroServico {
	@GetMapping("/message")
	public String test() {
		return "Oi ! Chamando First Service";
	}
}
