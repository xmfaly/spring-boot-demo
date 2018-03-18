首先创建一个注解用于面权限认证的接口

```
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NoAuth {
}

```
配置拦截器
```
  @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 不是本项目的不进行拦截
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        NoAuth noAuth = method.getMethodAnnotation(NoAuth.class);
        if (noAuth != null) {
            return true;
        } else {
            if (request.getSession().getAttribute("admin") == null) {
                response.sendRedirect("/login");;
                return false;
            }
            return true;
        }
    }
```
拦截器会拦截下所有没有 `NoAuth` 注解的方法进项权限认证。

注册拦截器
```
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private AuthIntercepter authIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authIntercepter).addPathPatterns("/**");

    }
}
```