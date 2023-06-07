package tn.esprit.firstproject.Configuration;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


        @Before(" execution(* tn.esprit.firstproject.services.EtudiantServicesImp.*(..)) ")
        public void logMethodEntry(JoinPoint joinPoint) {
            String name = joinPoint.getSignature().getName();
            log.info("In method " + name + " : ");
        }
        @After(" execution(* tn.esprit.firstproject.services.*.*(..)) ")
        public void logMethodExit(JoinPoint joinPoint) {
            String name = joinPoint.getSignature().getName();
            log.info("Out of method  " + name + " : ");
        }
       @AfterReturning(" execution(* tn.esprit.firstproject.services.*.*(..)) ")
       public void logMethodExitReturn(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out of method Return" + name + " : ");
    }
}
