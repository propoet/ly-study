package cn.itcast.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {
	/**
	 *  过滤器类型，前置过滤器
	 * @return
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 *  过滤器的执行顺序
	 * @return
	 */
	@Override
	public int filterOrder() {
		return 10;
	}

	/**
	 * 该过滤器是否生效
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 登陆校验逻辑
	 * @return
	 * @throws ZuulException
	 */
	@Override
	public Object run() throws ZuulException {
		// 获取zuul提供的上下文对象
		RequestContext currentContext = RequestContext.getCurrentContext();
		// 从上下文对象中获取请求对象
		HttpServletRequest request = currentContext.getRequest();
		// 获取token信息
		String token = request.getParameter("token");
		if (StringUtils.isBlank(token)){
			// 过滤该请求，不对其进行路由
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
			currentContext.setResponseBody("request error!");
		}
		currentContext.set("token", token);
		return null;
	}
}
