package br.com.caelum.eats.zuul.filters.pre;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class ZuulFilter extends com.netflix.zuul.ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(ZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}
	// TODO: Implementar roteamento padrão para monolito
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL()));
		System.out.println(request.getMethod() + " request to " + request.getRequestURL());
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "monolito";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
