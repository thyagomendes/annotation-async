# annotation-async

Em resumo, trabalhar com chamadas assicronas com spring é muito simples. Basta uma annotation @EnableAsync em um @Component e o método a ser executado tb estar sendo gerenciado pelo contexto do spring e estar anotado com @Async e algumas pequenas configurações.

exemplo:
AsyncController.java

@RestController
@EnableAsync
public class AsyncController {
	
	@Autowired
	AsyncService asyncService;

	@GetMapping("/async")
	public String asyncCallerMethod() throws InterruptedException {
		
		long start = System.currentTimeMillis();
		asyncService.asyncMethod();
		return "asyncCallerMethod complete in :" + (start - System.currentTimeMillis()) + "milliseconds";
	}
}
#########################################
AsyncService.java
@Service
public class AsyncService {

	@Async
	public void asyncMethod() throws InterruptedException {

		Thread.sleep(5000);
		System.out.println("service method call");
		System.out.println("Thread: " + Thread.currentThread().getName());
	}
}

