package hello.hellospring.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTraceAop {
    @Around( "execution(* hello.hellospring..*(..))")
    public Object excute(ProceedingJoinPoint joinpPoint) throws Throwable{

        long start =System.currentTimeMillis();
        System.out.println("START : " + joinpPoint.toString());
        try{
            return joinpPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("END : " + joinpPoint.toString() + " " + timeMs + "ms");
        }

    }

}
