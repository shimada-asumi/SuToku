package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//　文字コードを指定するフィルター

@WebFilter({ "/FilterEncoding", "/*" })
public class FilterEncoding implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException { }
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//　文字コード指定"UTF-8"
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}
	
	public void destroy() {	}
	
}
