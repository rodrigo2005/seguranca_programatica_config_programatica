package br.com.beans;

import javax.annotation.Resource;
import javax.ejb.SessionContext;

public abstract class SegurancaBeans {

	@Resource
	private SessionContext context;
	
	protected SessionContext getContext() {
		return context;
	}
}
