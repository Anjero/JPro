package net.anjero.pro.common.constant;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;

/**
 * <p>polodai Create by 2016/7/19 下午5:44</p>
 * <p>
 * 作为一个真正的程序员，首先应该尊重编程，<br/>
 * 热爱你所写下的程序，他是你的伙伴，而不是工具。</p>
 *
 * @author :anjero
 * @version :1.0
 * @company:Cheshell
 */
public class DefaultStringSerializer extends JsonSerializer<Object> {

    protected static Logger log = Logger.getLogger(DefaultStringSerializer.class);
    @Override
    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        // 可使用过滤 currentName方式过滤字段,非String 情况下返回正常数据,Number类型反正默认数值
        log.debug("value:" + value+" fieldName:"+jgen.getOutputContext().getCurrentName());
        jgen.writeString("-");
    }
}
