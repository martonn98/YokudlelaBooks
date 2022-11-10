/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yokudlela.books.utils.logging;


import static yokudlela.books.utils.logging.CustomRequestLoggingFilter.NOT_DEF;
import static yokudlela.books.utils.logging.CustomRequestLoggingFilter.REQUEST_ID;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import net.logstash.logback.marker.ObjectAppendingMarker;
import yokudlela.books.spring.ApplicationContextProvider;
import yokudlela.books.utils.request.RequestBean;

/**
 *
 * @author oe
 */
public class RequestIdMessageConverter extends ClassicConverter {

    ApplicationContextProvider appContext = new ApplicationContextProvider();

    @Override
    @AspectLogger
    public String convert(ILoggingEvent event) {

        try {
            RequestBean request = appContext.getApplicationContext().getBean("requestScopedBean", RequestBean.class);
            if (request != null) {
                return ("" + request.getRequestId());
            }
        } catch (Exception e) {
            if (event != null && event.getArgumentArray() != null) {
                ObjectAppendingMarker tmp;
                for (Object bean : event.getArgumentArray()) {
                    if (bean instanceof ObjectAppendingMarker) {
                        tmp = (ObjectAppendingMarker) bean;
                        if (REQUEST_ID.equals(tmp.getFieldName())) {
                            return "" + tmp.getFieldValue();
                        }
                    }
                }
            }
        }
        return NOT_DEF;
    }
}
