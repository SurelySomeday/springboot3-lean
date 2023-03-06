package top.yxlgx.config;

import org.hibernate.dialect.Database;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author yanxin.
 * @Date 2023/3/6 13:31.
 * Created by IntelliJ IDEA
 * File Description:
 */
public class MyStandardDialectResolver implements DialectResolver {
    @Override
    public Dialect resolveDialect(DialectResolutionInfo info) {
        for ( Database database : Database.values() ) {
            if (database.matchesResolutionInfo(info)) {
                Dialect dialect = database.createDialect(info);
                if (dialect != null) {
                    MyInterceptor myInterceptor = new MyInterceptor();
                    Enhancer enhancer = new Enhancer();
                    enhancer.setSuperclass(dialect.getClass());  // 设置超类，cglib是通过继承来实现的
                    enhancer.setCallback(myInterceptor);
                    return (Dialect) enhancer.create();
                }
            }
        }

        return null;
    }
}
