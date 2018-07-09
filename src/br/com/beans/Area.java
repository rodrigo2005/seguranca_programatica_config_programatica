package br.com.beans;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBAccessException;
import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.SecurityDomain;

@Stateless
@SecurityDomain("mysqldomain")
public class Area extends SegurancaBeans implements AreaInt {
		
	@Override
	@RolesAllowed({"ADMIN","USER"})
	public String getLogin() throws EJBAccessException {
		StringBuilder sb = new StringBuilder();
		sb.append("CallerPrincipal : "+getContext().getCallerPrincipal().getName());
		sb.append("CallerInRole    : "+getContext().isCallerInRole("ADMIN"));	
		return sb.toString();
	}

}
