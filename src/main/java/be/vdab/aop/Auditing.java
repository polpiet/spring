package be.vdab.aop;

import java.util.Collection;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
class Auditing {
	private final static Logger logger = Logger.getLogger(Auditing.class.getName());

	@AfterReturning(pointcut = "be.vdab.aop.PointcutExpressions.services()", returning = "returnValue")
	void schrijfAudit(JoinPoint joinPoint, Object returnValue) {
		StringBuilder builder = new StringBuilder("\nTijdstip\t").append(new Date());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			builder.append("\nGebruiker\t").append(authentication.getName());
		}
		builder.append("\nMethod\t\t").append(joinPoint.getSignature().toLongString());
		int parameterVolgnummer = 0;
		for (Object object : joinPoint.getArgs()) {
			builder.append("\nParameter ").append(++parameterVolgnummer).append('\t').append(object);
		}
		if (returnValue != null) {
			builder.append("\nReturn\t\t");
			if (returnValue instanceof Collection) { 
			builder.append(((Collection<?>) returnValue).size()).append(" objectss");
			} else {
			builder.append(returnValue.toString());
			}
		}
		logger.info(builder.toString());
	}
}
