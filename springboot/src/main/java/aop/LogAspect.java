package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
@Aspect
@Order(2)
public class LogAspect {

	public LogAspect() {
		System.out.println("LogAspect()");
	}

	@Pointcut("execution (* aop.Order.*(..))")
	public void orderMethods() {
	}

	// Associate any method that returns anything(*) and takes anything(..) in
	// aop.Order bean
//	@Before(value = "execution (* aop.Order.*(..))")
//	public void beforeAdviceMethod(JoinPoint jp) {
//		System.out.println("Before Advice --> " + jp.getSignature());
//	}

	// After finally
//	@After(value = "execution (* aop.Order.*(..))")
//	public void afterAdviceMethod(JoinPoint jp) {
//		System.out.println("After Advice --> " + jp.getSignature());
//	}

	// After Returning
//	@AfterReturning(value = "execution (* aop.Order.*(..))")
//	public void afterReturningAdviceMethod(JoinPoint jp) {
//		System.out.println("After Returning Advice --> " + jp.getSignature());
//	}

	// After Throwing
//	@AfterThrowing(value = "execution (* aop.Order.*(..))", throwing = "ex")
//	public void afterThrowingAdviceMethod(JoinPoint jp, Exception ex) {
//		System.out.println("After Throwing Advice --> " + jp.getSignature());
//		System.out.println("Exception is : " + ex.getMessage());
//	}

//	@After(value = "execution (* aop.Order.*(..))")
//	public void beforeAdvice(JoinPoint jp) {
//		System.out.println("After Advice 2 --> " + jp.getSignature());
//	}
	
	@Before("orderMethods()")
	public void beforeAdviceOrderMethods(JoinPoint jp) {
		System.out.println("Before Advice With Order Method --> " + jp.getSignature());
	}

	@After("orderMethods()")
	public void afterAdviceOrderMethods(JoinPoint jp) {
		System.out.println("After Advice With Order Method --> " + jp.getSignature());
	}

//	@Around(value = "execution (* aop.Order.*(int))")
//	public void aroundAdviceMethod(ProceedingJoinPoint pjp) {
//		System.out.println("Before calling : " + pjp.getSignature());
//		try {
//			Object obj = pjp.proceed(pjp.getArgs()); // Call method in Target
//			System.out.println("Returned : " + obj);
//		} catch (Throwable ex) {
//
//		}
//		System.out.println("After completing : " + pjp.getSignature());
//	}

}
