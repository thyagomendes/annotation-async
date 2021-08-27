package com.assync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
	public void asyncMethod() throws InterruptedException {

		Thread.sleep(5000);
		System.out.println("service method call");
		System.out.println("Thread: " + Thread.currentThread().getName());
//		Lançar exception (somente no console)
//		int a = 1000;
//		int b = 0;
//		System.out.println(a / b);
	}
}