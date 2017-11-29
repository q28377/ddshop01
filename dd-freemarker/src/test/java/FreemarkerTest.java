import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerTest {
    /**
     * 在本地硬盘的d:\ft文件夹中生成静态页面
     */
    @Test
    public void testFreemarker1() throws Exception {
        //创建一个Configuration对象。构造函数的参数就是对应的版本号
        Configuration configuration = new Configuration(Configuration.getVersion());
        //设置模板文件所在的路径
        configuration.setClassForTemplateLoading(this.getClass(),"/ftl");
        //设置模板文件使用的字符集，使用UTF-8字符集
        configuration.setDefaultEncoding("UTF-8");
        //加载模板，创建模板对象
        Template template = configuration.getTemplate("01.ftl");
        //创建数据集，可以是POJO也可以是Map，多使用Map
        Map<String, Object> dataModel = new HashMap<String, Object>();
        dataModel.put("name","qqq");
        //创建一个Writer对象，多创建FileWriter对象，并制定生成的文件名
        Writer out = new FileWriter("d:/GONGJU/Java/java_study/projectsTest/ftl/freemark01.html");
        //调用模板对象的process方法输出文件
        template.process(dataModel, out);
        //关闭流
        out.close();
    }
}
