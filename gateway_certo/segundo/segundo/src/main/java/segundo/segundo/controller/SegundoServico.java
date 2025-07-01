package segundo.segundo.controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/consumer")

public class SegundoServico {
    
	@GetMapping("/message")
	public String test() {
		return "Hello JavaInUse Called in Second Service";
	}
}
