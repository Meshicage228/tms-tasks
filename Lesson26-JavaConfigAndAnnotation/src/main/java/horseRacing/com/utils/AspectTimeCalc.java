package horseRacing.com.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTimeCalc {

  /*  @Pointcut("execution(public void horseRacing.com.domain.RacingGame.printPip())")
    public void doCacl(){
    }*/
    @Pointcut("@annotation(horseRacing.com.utils.TimeCalc)")
    public void doCacl(){
    }
    @Around("doCacl()")
    public Object doAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
      long start = System.nanoTime();
      Object proceed = proceedingJoinPoint.proceed();
      var end = System.nanoTime();
      System.out.println("Time for method - " + (end - start));
      return proceed;
    }
}
