package aop.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class InformeFuncionAspect {

	@Around("execution (* funcionUsuarios.AccionesUsuario.*(..))")
	public void informe(ProceedingJoinPoint  joinPoint) throws Throwable
	{
		String username = System.getProperty("Usuario.username");
        System.out.println("El usuario que esta ejecutando el programa es: "+ username);
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();
		long latencia = endTime - startTime;
		System.out.println("se ejecuto el método: " + joinPoint.getSignature().getName()+" con latencia: "+latencia);
	}
}